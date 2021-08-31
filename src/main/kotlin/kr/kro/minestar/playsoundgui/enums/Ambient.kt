package kr.kro.minestar.playsoundgui.enums

import org.bukkit.Material

enum class Ambient(override var material: Material): SoundMaterial{
    BASALT_DELTAS(Material.BASALT),
    CAVE(Material.STONE),
    CRIMSON_FOREST(Material.CRIMSON_NYLIUM),
    NETHER_WASTES(Material.NETHERRACK),
    SOUL_SAND_VALLEY(Material.SOUL_SAND),
    UNDERWATER(Material.WATER_BUCKET),
    WARPED_FOREST(Material.WARPED_NYLIUM),
}