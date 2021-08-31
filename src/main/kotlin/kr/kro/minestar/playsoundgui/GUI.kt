package kr.kro.minestar.playsoundgui

import kr.kro.minestar.playsoundgui.enums.*
import net.kyori.adventure.sound.SoundStop
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.Inventory

class GUI : Listener {

    var player: Player? = null
    var inventory: Inventory? = null


    fun guiOpen(p: Player, inv: Inventory) {
        try {
            player!!.closeInventory()
        } catch (e1: Exception) {
        }
        Bukkit.getPluginManager().registerEvents(this, Main.pl!!)
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
        when (e.view.title) {
            "PlaySound" -> Function().playSound(player!!, ChatColor.stripColor(e.currentItem!!.itemMeta.displayName)!!)
            "Category" -> guiOpen(player!!, soundGUI(ChatColor.stripColor(e.currentItem!!.itemMeta.displayName)!!)!!)

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
        var array: Array<*>? = null
        var title = ""
        var other: String? = null
        when (string) {
            "AMBIENT" -> {
                array = Ambient.values()
                title = "PlaySound"
            }
            "BLOCK" -> {
                array = Block.values()
                title = "BLOCK"
            }
            "HOSTILE_ENTITY" -> {
                array = HostileEntity.values()
                title = "HOSTILE_ENTITY"
            }
            "NON_HOSTILE_ENTITY" -> {
                array = NonHostileEntity.values()
                title = "NON_HOSTILE_ENTITY"
            }
            "OBJECT_ENTITY" -> {
                array = ObjectEntity.values()
                title = "OBJECT_ENTITY"
            }
            "ITEM" -> {
                array = Item.values()
                title = "ITEM"
            }
            "MUSIC" -> {
                array = Music.values()
                title = "PlaySound"
            }
            "UI" -> {
                array = UI.values()
                title = "PlaySound"
            }

            "EVENT",
            "PARTICLE",
            "WEATHER",
            "ENCHANT" -> other = string
        }
        if (array != null) {
            val inv = Bukkit.createInventory(null, setInventorySize(array.size), title)
            for ((slot, constant) in array.withIndex()) {
                if (title == "PlaySound") inv.setItem(slot, Function().convertSound(constant as SoundMaterial))
                else inv.setItem(slot, Function().convertItem(constant as SoundMaterial))
            }
            return inv
        }
        return null
    }

    private fun soundGUI(soundMaterial: SoundMaterial): Inventory {
        val list = Function().searchSounds(soundMaterial.prefix())
        val inv = Bukkit.createInventory(null, setInventorySize(list.size), "PlaySound")
        for ((slot, sound) in list.withIndex()) inv.setItem(slot, Function().convertItem(soundMaterial, sound))
        return inv
    }
}