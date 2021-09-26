package kr.kro.minestar.playsoundgui

import kr.kro.minestar.playsoundgui.enums.*
import net.kyori.adventure.sound.SoundStop
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.HoverEvent
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.chat.hover.content.Text
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.Inventory
import java.util.*

class GUI : Listener {

    companion object {
        val invList: HashMap<UUID, MutableList<Inventory>> = HashMap()
        var soundCategory: HashMap<UUID, SoundCategory> = HashMap()
        var volume: HashMap<UUID, Int> = HashMap()
        var pitch: HashMap<UUID, Int> = HashMap()
        var scale: HashMap<UUID, Scale> = HashMap()
    }

    var player: Player? = null
    var inventory: Inventory? = null

    private fun playSound(string: String): Boolean {
        var soundCategory: SoundCategory = soundCategory[player!!.uniqueId]!!
        var volume: Int = volume[player!!.uniqueId]!!
        var pitch: Int = pitch[player!!.uniqueId]!!
        var scale: Scale = scale[player!!.uniqueId]!!
        try {
            player!!.stopSound(SoundStop.all())
            val sound = Sound.valueOf(string)
            if (scale == Scale.NULL) player!!.playSound(player!!.location, sound, soundCategory, volume / 100F, pitch / 100F)
            else player!!.playSound(player!!.location, sound, soundCategory, volume / 100F, scale.float)

            player!!.sendMessage(" ")
            player!!.sendMessage("${Main.prefix} play §e$sound")

            val tcCMD = TextComponent("§6[Copy to command]")
            var soundCategoryText = soundCategory.name.lowercase()
            if (soundCategoryText.toCharArray()[soundCategoryText.toCharArray().size - 1] == 's') soundCategoryText = soundCategoryText.replace("s", "")
            tcCMD.hoverEvent = HoverEvent(HoverEvent.Action.SHOW_TEXT, Text("Click to copy"))
            if (scale != Scale.NULL) tcCMD.clickEvent = ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, "/playsound ${sound.key} $soundCategoryText @s ~ ~ ~ ${volume / 100F} ${scale.float}")
            else tcCMD.clickEvent = ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, "/playsound ${sound.key} $soundCategoryText @s ~ ~ ~ ${volume / 100F} ${pitch / 100F}")

            val tcCode = TextComponent("§e[Copy to code]")
            tcCode.hoverEvent = HoverEvent(HoverEvent.Action.SHOW_TEXT, Text("Click to copy"))
            if (scale != Scale.NULL) tcCode.clickEvent = ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, "playSound(location, Sound.$sound, SoundCategory.$soundCategory, ${volume / 100F}F, ${scale.float}F)")
            else tcCode.clickEvent = ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, "playSound(Location, Sound.$sound, SoundCategory.$soundCategory, ${volume / 100F}F, ${pitch / 100F}F)")

            val split = TextComponent("§f / ")

            val tcArray = arrayOf(tcCMD, split, tcCode)

            player!!.spigot().sendMessage(*tcArray)

        } catch (e1: Exception) {
            return false
        }
        return true
    }

    private fun guiOpen(p: Player, inv: Inventory) {
        try {
            player!!.closeInventory()
        } catch (e1: Exception) {
        }
        p.playSound(p.location, Sound.BLOCK_WOODEN_DOOR_OPEN, SoundCategory.MASTER, 0.5F, 1.2F)
        Bukkit.getPluginManager().registerEvents(this, Main.pl!!)
        val list = invList[p.uniqueId]
        list!!.add(inv)
        invList[p.uniqueId] = list
        player = p
        inventory = inv
        p.openInventory(inv)
    }

    private fun guiOpenToBack(p: Player, inv: Inventory) {
        try {
            player!!.closeInventory()
        } catch (e1: Exception) {
        }
        p.playSound(p.location, Sound.BLOCK_WOODEN_DOOR_CLOSE, SoundCategory.MASTER, 0.5F, 1.2F)
        Bukkit.getPluginManager().registerEvents(this, Main.pl!!)
        player = p
        inventory = inv
        p.openInventory(inv)
    }

    fun guiOpenFromCMD(p: Player, inv: Inventory) {
        try {
            player!!.closeInventory()
        } catch (e1: Exception) {
        }
        p.playSound(p.location, Sound.BLOCK_WOODEN_DOOR_OPEN, SoundCategory.MASTER, 0.5F, 1.2F)
        Bukkit.getPluginManager().registerEvents(this, Main.pl!!)
        if (invList.contains(p.uniqueId)) invList.remove(p!!.uniqueId)
        invList[p!!.uniqueId] = mutableListOf(inv)
        soundCategory[p.uniqueId] = SoundCategory.MASTER
        volume[p.uniqueId] = 100
        pitch[p.uniqueId] = 100
        scale[p.uniqueId] = Scale.NULL
        player = p
        inventory = inv
        p.openInventory(inv)
    }

    @EventHandler
    fun guiClick(e: InventoryClickEvent) {
        if (e.whoClicked != player) return
        if (e.inventory != inventory) return
        e.isCancelled = true
        if (e.currentItem == null) return
        val display = ChatColor.stripColor(e.currentItem!!.itemMeta.displayName)!!
        if (display.contains("MOVE TO BACK")) {
            moveToBack()
            return
        }
        if (display.contains("SOUND STOP")) {
            player!!.stopSound(SoundStop.all())
            return
        }
        if (display.contains("SOUND CATEGORY")) {
            editSoundCategory(e)
            return
        }
        if (display.contains("VOLUME")) {
            editVolume(e)
            return
        }
        if (display.contains("PITCH")) {
            editPitch(e)
            return
        }
        if (display.contains("SCALE")) {
            editScale(e)
            return
        }
        when (e.view.title) {
            "PlaySound" -> if (playSound(display)) return
            "Category" -> guiOpen(player!!, soundGUI(display)!!)
            else -> if (display.contains("MOVE TO BACK")) moveToBack()
            else guiOpen(player!!, soundGUI(Function().getSoundMaterial(e.view.title, display)!!))
        }
    }

    @EventHandler
    fun closeGUI(e: InventoryCloseEvent) {
        if (e.inventory != inventory) return
        player!!.stopSound(SoundStop.all())
        HandlerList.unregisterAll(this)
    }

    private fun setInventorySize(value: Int): Int {
        return when {
            value <= 9 * 1 -> 9 * 1
            value <= 9 * 2 -> 9 * 2
            value <= 9 * 3 -> 9 * 3
            value <= 9 * 4 -> 9 * 4
            value <= 9 * 5 -> 9 * 5
            value > 9 * 5 -> 9 * 6
            else -> 9 * 6
        }
    }

    fun categoryGUI(): Inventory {
        val list = Category.values()
        val inv = Bukkit.createInventory(null, setInventorySize(list.size), "Category")
        for ((slot, constant) in list.withIndex()) inv.setItem(slot, Function().convertItem(constant))
        return inv
    }


    private fun soundGUI(string: String): Inventory? {
        var soundCategory: SoundCategory = soundCategory[player!!.uniqueId]!!
        var volume: Int = volume[player!!.uniqueId]!!
        var pitch: Int = pitch[player!!.uniqueId]!!
        var scale: Scale = scale[player!!.uniqueId]!!

        var array: Array<*>? = null
        var title = ""
        var other: String? = null
        when (string) {
            "AMBIENT" -> {
                array = Ambient.values()
                title = string
            }
            "BLOCK1" -> {
                array = Block1.values()
                title = string
            }
            "BLOCK2" -> {
                array = Block2.values()
                title = string
            }
            "BLOCK3" -> {
                array = Block3.values()
                title = string
            }
            "HOSTILE_ENTITY" -> {
                array = HostileEntity.values()
                title = string
            }
            "NON_HOSTILE_ENTITY" -> {
                array = NonHostileEntity.values()
                title = string
            }
            "OBJECT_ENTITY" -> {
                array = ObjectEntity.values()
                title = string
            }
            "ITEM" -> {
                array = Item.values()
                title = string
            }
            "MUSIC" -> {
                array = Music.values()
                title = "PlaySound"
            }
            "UI" -> {
                array = UI.values()
                title = "PlaySound"
            }

            "EVENT" -> {
                array = Event.values()
                title = "PlaySound"
            }
            "PARTICLE" -> {
                array = Particle.values()
                title = "PlaySound"
            }
            "WEATHER" -> {
                array = Weather.values()
                title = "PlaySound"
            }
            "ENCHANT" -> {
                array = Enchant.values()
                title = "PlaySound"
            }
        }
        if (array == null) return null
        var size = 0

        size = setInventorySize(array.size) + 9
        val inv = Bukkit.createInventory(null, size, title)
        if (title != "PlaySound") for ((slot, constant) in array.withIndex()) inv.setItem(slot, Function().convertItem(constant as SoundMaterial))
        else for ((slot, constant) in array.withIndex()) inv.setItem(slot, Function().convertSound(constant as SoundMaterial))
        var offset = size - 9
        inv.setItem(0 + offset, Function().backItem())
        inv.setItem(2 + offset, Function().outPortItem(soundCategory))
        inv.setItem(4 + offset, Function().stopItem())
        inv.setItem(6 + offset, Function().volumeItem(volume / 100F))
        inv.setItem(7 + offset, Function().pitchItem(pitch / 100F))
        inv.setItem(8 + offset, Function().scaleItem(scale))
        return inv
    }

    private fun soundGUI(soundMaterial: SoundMaterial): Inventory {
        var soundCategory: SoundCategory = soundCategory[player!!.uniqueId]!!
        var volume: Int = volume[player!!.uniqueId]!!
        var pitch: Int = pitch[player!!.uniqueId]!!
        var scale: Scale = scale[player!!.uniqueId]!!

        val array = Function().searchSounds(soundMaterial.prefix())
        val size = setInventorySize(array.size) + 9
        val inv = Bukkit.createInventory(null, size, "PlaySound")
        for ((slot, sound) in array.withIndex()) inv.setItem(slot, Function().convertItem(soundMaterial, sound))
        var offset = size - 9
        inv.setItem(0 + offset, Function().backItem())
        inv.setItem(2 + offset, Function().outPortItem(soundCategory))
        inv.setItem(4 + offset, Function().stopItem())
        inv.setItem(6 + offset, Function().volumeItem(volume / 100F))
        inv.setItem(7 + offset, Function().pitchItem(pitch / 100F))
        inv.setItem(8 + offset, Function().scaleItem(scale))
        return inv
    }

    private fun moveToBack() {
        val list = invList[player!!.uniqueId]
        list!!.remove(inventory)
        guiOpenToBack(player!!, list[list.size - 1])
    }

    private fun editSoundCategory(e: InventoryClickEvent) {
        if (e.isShiftClick) return
        val array = SoundCategory.values()
        var int = 0
        for (it in array) {
            if (it == soundCategory[player!!.uniqueId]!!) break
            ++int
        }
        if (e.isLeftClick) {
            if (int == 0) return
            soundCategory[player!!.uniqueId] = array[int - 1]
        } else if (e.isRightClick) {
            if (int + 1 == array.size) return
            soundCategory[player!!.uniqueId] = array[int + 1]
        }
        e.currentItem = Function().outPortItem(soundCategory[player!!.uniqueId]!!)
    }

    private fun editVolume(e: InventoryClickEvent) {
        var int: Int = volume[player!!.uniqueId]!!
        if (e.isLeftClick) {
            int -= if (e.isShiftClick) 1
            else 10
            if (int <= 0) int = 0
            volume[player!!.uniqueId] = int
        } else if (e.isRightClick) {
            int += if (e.isShiftClick) 1
            else 10
            if (int > 100) int = 100
            volume[player!!.uniqueId] = int
        }
        e.currentItem = Function().volumeItem(volume[player!!.uniqueId]!! / 100F)
    }

    private fun editPitch(e: InventoryClickEvent) {
        var int: Int = pitch[player!!.uniqueId]!!
        if (e.isLeftClick) {
            int -= if (e.isShiftClick) 1
            else 10
            if (int <= 50) int = 50
            pitch[player!!.uniqueId] = int
        } else if (e.isRightClick) {
            int += if (e.isShiftClick) 1
            else 10
            if (int > 200) int = 200
            pitch[player!!.uniqueId] = int
        }
        e.currentItem = Function().pitchItem(pitch[player!!.uniqueId]!! / 100F)
    }

    private fun editScale(e: InventoryClickEvent) {
        if (e.isShiftClick) return
        val array = Scale.values()
        var int = 0
        for (it in array) {
            if (it == scale[player!!.uniqueId]!!) break
            ++int
        }
        if (e.isLeftClick) {
            if (int == 0) return
            scale[player!!.uniqueId] = array[int - 1]
        } else if (e.isRightClick) {
            if (int + 1 == array.size) return
            scale[player!!.uniqueId] = array[int + 1]
        }
        e.currentItem = Function().scaleItem(scale[player!!.uniqueId]!!)
    }
}