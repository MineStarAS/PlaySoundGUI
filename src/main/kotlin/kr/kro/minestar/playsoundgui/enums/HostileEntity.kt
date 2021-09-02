package kr.kro.minestar.playsoundgui.enums

import org.bukkit.Material

enum class HostileEntity(override var material: Material): SoundMaterial{
    BLAZE(Material.BLAZE_ROD),
    CREEPER(Material.CREEPER_HEAD),
    DROWNED(Material.TRIDENT),
    ELDER_GUARDIAN(Material.ELDER_GUARDIAN_SPAWN_EGG),
    ENDERMAN(Material.ENDER_PEARL),
    ENDERMITE(Material.ENDERMITE_SPAWN_EGG),
    ENDER_DRAGON(Material.DRAGON_HEAD),
    EVOKER(Material.EVOKER_SPAWN_EGG),
    GHAST(Material.GHAST_TEAR),
    GUARDIAN(Material.GUARDIAN_SPAWN_EGG),
    HOSTILE(Material.IRON_AXE),
    HUSK(Material.SAND),
    ILLUSIONER(Material.STICK),
    MAGMA_CUBE(Material.MAGMA_CREAM),
    PHANTOM(Material.PHANTOM_MEMBRANE),
    PIGLIN(Material.GOLD_INGOT),
    PILLAGER(Material.IRON_AXE),
    POLAR_BEAR(Material.SNOW_BLOCK),
    RAVAGER(Material.RAVAGER_SPAWN_EGG),
    SHULKER(Material.SHULKER_BOX),
    SILVERFISH(Material.INFESTED_CRACKED_STONE_BRICKS),
    SKELETON(Material.SKELETON_SKULL),
    SLIME(Material.SLIME_BLOCK),
    SPIDER(Material.SPIDER_EYE),
    STRAY(Material.STRAY_SPAWN_EGG),
    STRIDER(Material.CRIMSON_NYLIUM),
    VEX(Material.IRON_SWORD),
    VINDICATOR(Material.IRON_AXE),
    WITCH(Material.SPLASH_POTION),
    WITHER(Material.WITHER_SKELETON_SKULL),
    WITHER_SKELETON(Material.WITHER_SKELETON_SKULL),
    ZOGLIN(Material.ZOGLIN_SPAWN_EGG),
    ZOMBIE(Material.ZOMBIE_HEAD),
    ZOMBIE_VILLAGER(Material.ZOMBIE_VILLAGER_SPAWN_EGG),
    ZOMBIFIED_PIGLIN(Material.GOLDEN_SWORD),
    ;

    override fun prefix(): String {
        return "ENTITY_${toString()}"
    }
}