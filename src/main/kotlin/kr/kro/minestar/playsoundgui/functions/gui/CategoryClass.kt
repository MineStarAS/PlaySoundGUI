package kr.kro.minestar.playsoundgui.functions.gui

import kr.kro.minestar.playsoundgui.enums.CategoryEnum
import kr.kro.minestar.utility.gui.GUI
import org.bukkit.Material

object CategoryClass {

    fun openGUI(gui: GUI, categoryEnum: CategoryEnum, material: Material) {
        if (categoryEnum.isMenu) Menu(gui.player, categoryEnum, gui)
        else PlaySound(gui.player, categoryEnum.name, material, gui)
    }
}