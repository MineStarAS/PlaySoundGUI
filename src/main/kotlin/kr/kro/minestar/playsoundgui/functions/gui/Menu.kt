package kr.kro.minestar.playsoundgui.functions.gui

import kr.kro.minestar.playsoundgui.Main
import kr.kro.minestar.playsoundgui.enums.CategoryEnum
import kr.kro.minestar.playsoundgui.enums.Scale
import kr.kro.minestar.playsoundgui.functions.ItemClass
import kr.kro.minestar.utility.gui.GUI
import kr.kro.minestar.utility.item.display
import kr.kro.minestar.utility.string.unColor
import net.kyori.adventure.sound.SoundStop
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.HandlerList
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent

class Menu(override val player: Player, val categoryEnum: CategoryEnum, val backGUI: GUI) : GUI {
    override val pl = Main.pl
    override val gui = Bukkit.createInventory(null, MenuClass.guiSize(categoryEnum), "$categoryEnum")

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
        val values = MenuClass.getValues(categoryEnum)
        for ((slot, e) in values.withIndex()) gui.setItem(slot, ItemClass.convertItem(e))
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
                        if (option.pitch < 0.5) option.pitch = 0.5F
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
        PlaySound(player, display, clickItem.type, this)
        player.playSound(player.location, Sound.BLOCK_WOODEN_DOOR_OPEN, SoundCategory.MASTER, 1.0F, 1.5F)
    }

    @EventHandler
    override fun closeGUI(e: InventoryCloseEvent) {
        if (e.player != player) return
        if (e.inventory != gui) return
        HandlerList.unregisterAll(this)
        player.stopSound(SoundStop.all())
    }
}