package kr.kro.minestar.playsoundgui.enums.menus

import kr.kro.minestar.playsoundgui.enums.SoundMaterial
import org.bukkit.Material

enum class Block3(override var material: Material): SoundMaterial {
    POINTED_DRIPSTONE(Material.POINTED_DRIPSTONE),
    POLISHED_DEEPSLATE(Material.POLISHED_DEEPSLATE),
    PORTAL(Material.OBSIDIAN),
    POWDER_SNOW(Material.POWDER_SNOW_BUCKET),
    PUMPKIN(Material.PUMPKIN),
    REDSTONE(Material.REDSTONE),
    RESPAWN_ANCHOR(Material.RESPAWN_ANCHOR),
    ROOTED_DIRT(Material.ROOTED_DIRT),
    ROOTS(Material.WARPED_ROOTS),
    SAND(Material.SAND),
    SCAFFOLDING(Material.SCAFFOLDING),
    SCULK_SENSOR(Material.SCULK_SENSOR),
    SHROOMLIGHT(Material.SHROOMLIGHT),
    SHULKER_BOX(Material.SHULKER_BOX),
    SLIME_BLOCK(Material.SLIME_BLOCK),
    SMALL_DRIPLEAF(Material.SMALL_DRIPLEAF),
    SMITHING_TABLE(Material.SMITHING_TABLE),
    SMOKER(Material.SMOKER),
    SNOW(Material.SNOW),
    SOUL_SOIL(Material.SOUL_SOIL),
    SPORE_BLOSSOM(Material.SPORE_BLOSSOM),
    STEM(Material.PUMPKIN_SEEDS),
    STONE(Material.STONE),
    SWEET_BERRY_BUSH(Material.SWEET_BERRIES),
    TRIPWIRE(Material.TRIPWIRE_HOOK),
    TUFF(Material.TUFF),
    VINE(Material.VINE),
    WART_BLOCK(Material.NETHER_WART_BLOCK),
    WATER(Material.WATER_BUCKET),
    WEEPING_VINES(Material.WEEPING_VINES),
    WET_GRASS(Material.GRASS_BLOCK),
    WOODEN_BUTTON(Material.OAK_BUTTON),
    WOODEN_DOOR(Material.OAK_DOOR),
    WOODEN_TRAPDOOR(Material.OAK_TRAPDOOR),
    WOOL(Material.WHITE_WOOL),
    ;

    override fun prefix(): String {
        return "BLOCK_${toString()}"
    }
}