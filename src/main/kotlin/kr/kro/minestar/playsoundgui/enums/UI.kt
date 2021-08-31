package kr.kro.minestar.playsoundgui.enums

import org.bukkit.Material

enum class UI(override var material: Material): SoundMaterial{
    BUTTON_CLICK(Material.OAK_BUTTON),
    CARTOGRAPHY_TABLE_TAKE_RESULT(Material.SPRUCE_BUTTON),
    LOOM_SELECT_PATTERN(Material.BIRCH_BUTTON),
    LOOM_TAKE_RESULT(Material.JUNGLE_BUTTON),
    STONECUTTER_SELECT_RECIPE(Material.ACACIA_BUTTON),
    STONECUTTER_TAKE_RESULT(Material.DARK_OAK_BUTTON),
    TOAST_CHALLENGE_COMPLETE(Material.EMERALD),
    TOAST_IN(Material.CRIMSON_BUTTON),
    TOAST_OUT(Material.WARPED_BUTTON),
}