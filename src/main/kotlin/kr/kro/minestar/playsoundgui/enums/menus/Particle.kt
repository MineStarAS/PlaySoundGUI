package kr.kro.minestar.playsoundgui.enums.menus

import kr.kro.minestar.playsoundgui.enums.SoundMaterial
import org.bukkit.Material

enum class Particle(override var material: Material): SoundMaterial {
    SOUL_ESCAPE(Material.ENDER_EYE),
}