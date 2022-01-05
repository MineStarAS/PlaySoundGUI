package kr.kro.minestar.playsoundgui.enums.menus

import kr.kro.minestar.playsoundgui.enums.SoundMaterial
import org.bukkit.Material

enum class Weather(override var material: Material): SoundMaterial {
    RAIN(Material.WATER_BUCKET),
    RAIN_ABOVE(Material.WATER_BUCKET),
}