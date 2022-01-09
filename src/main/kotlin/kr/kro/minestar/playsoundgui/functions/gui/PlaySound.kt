package kr.kro.minestar.playsoundgui.functions.gui

import kr.kro.minestar.playsoundgui.Main
import kr.kro.minestar.playsoundgui.enums.Scale
import kr.kro.minestar.playsoundgui.enums.menus.Music
import kr.kro.minestar.playsoundgui.functions.ItemClass
import kr.kro.minestar.utility.gui.GUI
import kr.kro.minestar.utility.item.display
import kr.kro.minestar.utility.item.setDisplay
import kr.kro.minestar.utility.material.item
import kr.kro.minestar.utility.string.toServer
import kr.kro.minestar.utility.string.unColor
import net.kyori.adventure.sound.SoundStop
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.HoverEvent
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.chat.hover.content.Text
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.HandlerList
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.ItemFlag
import kotlin.math.round

class PlaySound(override val player: Player, val sound: String, val material: Material, val backGUI: GUI) : GUI {
    override val pl = Main.pl
    val sounds = PlaySoundClass.searchSounds(sound)
    override val gui = Bukkit.createInventory(null, PlaySoundClass.guiSize(sounds.size), "PlaySound")

    init {
        openGUI()
    }

    override fun openGUI() {
        Bukkit.getPluginManager().registerEvents(this, pl)
        displaying()
        player.openInventory(gui)
    }

    override fun displaying() {
        gui.clear()
        if (sound == "MUSIC") for ((slot, s) in Music.values().withIndex()) {
            val item = s.material.item().setDisplay("${sound}_$s")
            for (flag in ItemFlag.values()) item.addItemFlags(flag)
            gui.setItem(slot, item)
        }
        else for ((slot, s) in sounds.withIndex()) gui.setItem(slot, material.item().setDisplay(s.name))
        val option = Main.soundOptionMap[player]!!
        val slots = ItemClass.buttonSlots(gui.size, option.soundCategory, option.volume, option.pitch, option.scale)
        for (slot in slots) gui.setItem(slot.get, slot.item)
    }

    @EventHandler
    override fun clickGUI(e: InventoryClickEvent) {
        if (e.whoClicked != player) return
        if (e.inventory != gui) return
        e.isCancelled = true
        if (e.clickedInventory != e.view.topInventory) return
        val clickItem = e.currentItem ?: return
        val display = clickItem.display().unColor()
        val option = Main.soundOptionMap[player]!!
        if (e.slot in gui.size - 9 until gui.size) {
            if (display.contains("MOVE TO BACK")) {
                backGUI.openGUI()
                return player.playSound(player.location, Sound.BLOCK_WOODEN_DOOR_CLOSE, SoundCategory.MASTER, 1.0F, 1.5F)
            }
            if (display.contains("SOUND STOP")) return player.stopSound(SoundStop.all())
            if (display.contains("SOUND CATEGORY")) {
                when (e.click) {
                    ClickType.LEFT -> {
                        val ordinal = option.soundCategory.ordinal
                        if (ordinal == 0) option.soundCategory = SoundCategory.values().last()
                        else option.soundCategory = SoundCategory.values()[ordinal - 1]
                        displaying()
                    }
                    ClickType.RIGHT -> {
                        val ordinal = option.soundCategory.ordinal
                        if (ordinal == SoundCategory.values().lastIndex) option.soundCategory = SoundCategory.values().first()
                        else option.soundCategory = SoundCategory.values()[ordinal + 1]
                        displaying()
                    }
                    else -> return
                }
            }
            if (display.contains("VOLUME")) {
                when (e.click) {
                    ClickType.RIGHT -> {
                        option.volume -= 0.1F
                        if (option.volume < 0) option.volume = 0F
                        displaying()
                    }
                    ClickType.SHIFT_RIGHT -> {
                        option.volume -= 0.01F
                        if (option.volume < 0) option.volume = 0F
                        displaying()
                    }
                    ClickType.LEFT -> {
                        option.volume += 0.1F
                        if (option.volume > 1) option.volume = 1F
                        displaying()
                    }
                    ClickType.SHIFT_LEFT -> {
                        option.volume += 0.01F
                        if (option.volume > 1) option.volume = 1F
                        displaying()
                    }
                    else -> return
                }
            }
            if (display.contains("PITCH")) {
                when (e.click) {
                    ClickType.RIGHT -> {
                        option.pitch -= 0.1F
                        if (option.pitch < 0.5) option.pitch = 0.5F
                        displaying()
                    }
                    ClickType.SHIFT_RIGHT -> {
                        option.pitch -= 0.01F
                        if (option.pitch < 0.5) option.pitch = 0F
                        displaying()
                    }
                    ClickType.LEFT -> {
                        option.pitch += 0.1F
                        if (option.pitch > 2) option.pitch = 2F
                        displaying()
                    }
                    ClickType.SHIFT_LEFT -> {
                        option.pitch += 0.01F
                        if (option.pitch > 2) option.pitch = 2F
                        displaying()
                    }
                    else -> return
                }
            }
            if (display.contains("SCALE")) {
                if (option.scale != null) when (e.click) {
                    ClickType.LEFT -> {
                        val ordinal = option.scale!!.ordinal
                        if (ordinal == 0) option.scale = Scale.values().last()
                        else option.scale = Scale.values()[ordinal - 1]
                        displaying()
                    }
                    ClickType.RIGHT -> {
                        val ordinal = option.scale!!.ordinal
                        if (ordinal == Scale.values().lastIndex) option.scale = Scale.values().first()
                        else option.scale = Scale.values()[ordinal + 1]
                        displaying()
                    }
                    ClickType.SHIFT_LEFT -> {
                        option.scale = null
                        displaying()
                    }
                    else -> return
                } else when (e.click) {
                    ClickType.LEFT, ClickType.RIGHT -> {
                        option.scale = Scale.DO
                        displaying()
                    }
                    else -> return
                }
            }
            return
        }
        if (e.click != ClickType.LEFT) return
        val soundCategory = option.soundCategory
        val volume = option.volume
        val pitch = if (option.scale == null) option.pitch
        else option.scale!!.float

        player.stopSound(SoundStop.all())

        val sound = Sound.valueOf(display)
        player.playSound(player.location, sound, soundCategory, volume, pitch)

        player.sendMessage(" ")
        player.sendMessage("${Main.prefix} play §e$sound")

        val tcCMD = TextComponent("§6[Copy to command]")
        var soundCategoryText = soundCategory.name.lowercase()
        if (soundCategoryText.toCharArray()[soundCategoryText.toCharArray().size - 1] == 's') soundCategoryText = soundCategoryText.replace("s", "")
        tcCMD.hoverEvent = HoverEvent(HoverEvent.Action.SHOW_TEXT, Text("Click to copy"))
        tcCMD.clickEvent = ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, "/playsound ${sound.key} $soundCategoryText @s ~ ~ ~ ${round(volume * 100) / 100} ${round(pitch * 100) / 100}")

        val tcCode = TextComponent("§e[Copy to code]")
        tcCode.hoverEvent = HoverEvent(HoverEvent.Action.SHOW_TEXT, Text("Click to copy"))
        tcCode.clickEvent = ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, "playSound(Location, Sound.$sound, SoundCategory.$soundCategory, ${round(volume * 100) / 100}F, ${round(pitch * 100) / 100}F)")

        val split = TextComponent("§f / ")

        val tcArray = arrayOf(tcCMD, split, tcCode)

        player.spigot().sendMessage(*tcArray)
        return
    }

    @EventHandler
    override fun closeGUI(e: InventoryCloseEvent) {
        if (e.player != player) return
        if (e.inventory != gui) return
        HandlerList.unregisterAll(this)
        player.stopSound(SoundStop.all())
    }
}