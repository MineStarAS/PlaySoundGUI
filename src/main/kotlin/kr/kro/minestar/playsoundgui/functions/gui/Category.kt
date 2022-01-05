package kr.kro.minestar.playsoundgui.functions.gui

import kr.kro.minestar.playsoundgui.Main
import kr.kro.minestar.playsoundgui.enums.CategoryEnum
import kr.kro.minestar.playsoundgui.functions.ItemClass
import kr.kro.minestar.playsoundgui.functions.SoundOption
import kr.kro.minestar.utility.gui.GUI
import kr.kro.minestar.utility.item.display
import kr.kro.minestar.utility.string.unColor
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.HandlerList
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent

class Category(override val player: Player) : GUI {
    override val pl = Main.pl
    override val gui = Bukkit.createInventory(null, 9 * 2, "Category")

    init {
        openGUI()
    }

    override fun openGUI() {
        Bukkit.getPluginManager().registerEvents(this, pl)
        displaying()
        player.openInventory(gui)
        Main.soundOptionMap[player] = SoundOption(player)
    }

    override fun displaying() {
        gui.clear()
        for ((slot, e) in CategoryEnum.values().withIndex()) gui.setItem(slot, ItemClass.convertItem(e))
    }

    @EventHandler
    override fun clickGUI(e: InventoryClickEvent) {
        if (e.whoClicked != player) return
        if (e.inventory != gui) return
        e.isCancelled = true
        if (e.clickedInventory != e.view.topInventory) return
        if (e.click != ClickType.LEFT) return
        val clickItem = e.currentItem ?: return
        val display = clickItem.display().unColor()
        val categoryEnum = CategoryEnum.valueOf(display)
        CategoryClass.openGUI(this, categoryEnum, clickItem.type)
    }

    @EventHandler
    override fun closeGUI(e: InventoryCloseEvent) {
        if (e.player != player) return
        if (e.inventory != gui) return
        HandlerList.unregisterAll(this)
    }
}