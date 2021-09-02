package kr.kro.minestar.playsoundgui.enums

import org.bukkit.Material

enum class Enchant(override var material: Material): SoundMaterial{
    THORNS_HIT(Material.ENCHANTING_TABLE),
}