package kr.kro.minestar.playsoundgui.enums

import org.bukkit.Material

interface SoundMaterial {
    var material: Material

    fun prefix(): String {
        return "${this.javaClass.simpleName.toUpperCase()}_${toString()}"
    }
}