package kr.kro.minestar.playsoundgui.enums.menus

import kr.kro.minestar.playsoundgui.enums.SoundMaterial
import org.bukkit.Material

enum class Block2(override var material: Material): SoundMaterial {
    END_GATEWAY(Material.END_PORTAL_FRAME),
    END_PORTAL(Material.END_PORTAL_FRAME),
    FENCE_GATE(Material.OAK_FENCE_GATE),
    FIRE(Material.FIRE_CHARGE),
    FLOWERING_AZALEA(Material.FLOWERING_AZALEA),
    FUNGUS(Material.CRIMSON_FUNGUS),
    FURNACE(Material.FURNACE),
    GILDED_BLACKSTONE(Material.GILDED_BLACKSTONE),
    GRASS(Material.GRASS),
    GRAVEL(Material.GRAVEL),
    GRINDSTONE(Material.GRINDSTONE),
    HANGING_ROOTS(Material.HANGING_ROOTS),
    HONEY_BLOCK(Material.HONEY_BLOCK),
    IRON_DOOR(Material.IRON_DOOR),
    LADDER(Material.LADDER),
    LANTERN(Material.LANTERN),
    LARGE_AMETHYST(Material.LARGE_AMETHYST_BUD),
    LAVA(Material.LAVA_BUCKET),
    LEVER(Material.LEVER),
    LILY_PAD(Material.LILY_PAD),
    LODESTONE(Material.LODESTONE),
    MEDIUM_AMETHYST(Material.MEDIUM_AMETHYST_BUD),
    METAL(Material.IRON_BLOCK),
    MOSS(Material.MOSS_BLOCK),
    NETHERITE_BLOCK(Material.NETHERITE_BLOCK),
    NETHERRACK(Material.NETHERRACK),
    NETHER_BRICKS(Material.NETHER_BRICKS),
    NETHER_GOLD_ORE(Material.NETHER_GOLD_ORE),
    NETHER_ORE(Material.NETHER_QUARTZ_ORE),
    NETHER_SPROUTS(Material.NETHER_SPROUTS),
    NETHER_WART(Material.NETHER_WART),
    NOTE_BLOCK(Material.NOTE_BLOCK),
    NYLIUM(Material.CRIMSON_NYLIUM),
    PISTON_EXTEND(Material.PISTON),
    ;

    override fun prefix(): String {
        return "BLOCK_${toString()}"
    }
}