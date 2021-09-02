package kr.kro.minestar.playsoundgui.enums

import org.bukkit.Material

enum class Block1(override var material: Material) : SoundMaterial {
    AMETHYST_BLOCK(Material.AMETHYST_BLOCK),
    AMETHYST_CLUSTER(Material.AMETHYST_CLUSTER),
    ANCIENT_DEBRIS(Material.ANCIENT_DEBRIS),
    ANVIL(Material.ANVIL),
    AZALEA(Material.AZALEA),
    BAMBOO(Material.BAMBOO),
    BARREL(Material.BARREL),
    BASALT(Material.BASALT),
    BEACON(Material.BEACON),
    BEEHIVE(Material.BEEHIVE),
    BELL(Material.BELL),
    BIG_DRIPLEAF(Material.BIG_DRIPLEAF),
    BLASTFURNACE(Material.BLAST_FURNACE),
    BONE_BLOCK(Material.BONE_BLOCK),
    BREWING_STAND(Material.BREWING_STAND),
    BUBBLE_COLUMN(Material.WATER_BUCKET),
    CAKE(Material.CAKE),
    CALCITE(Material.CALCITE),
    CAMPFIRE(Material.CAMPFIRE),
    CANDLE(Material.CANDLE),
    CAVE_VINES(Material.GLOW_BERRIES),
    CHAIN(Material.CHAIN),
    CHEST(Material.CHEST),
    CHORUS_FLOWER(Material.CHORUS_FLOWER),
    COMPOSTER(Material.COMPOSTER),
    CONDUIT(Material.CONDUIT),
    COPPER(Material.COPPER_BLOCK),
    CORAL_BLOCK(Material.BRAIN_CORAL),
    CROP(Material.WHEAT),
    DEEPSLATE_TILES(Material.DEEPSLATE_TILES),
    DISPENSER(Material.DISPENSER),
    DRIPSTONE_BLOCK(Material.DRIPSTONE_BLOCK),
    ENCHANTMENT_TABLE(Material.ENCHANTING_TABLE),
    ENDER_CHEST(Material.ENDER_CHEST),
    ;

    override fun prefix(): String {
        return "BLOCK_${toString()}"
    }
}