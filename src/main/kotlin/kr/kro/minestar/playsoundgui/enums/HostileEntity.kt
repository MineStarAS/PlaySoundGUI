package kr.kro.minestar.playsoundgui.enums

import org.bukkit.Material

enum class HostileEntity(override var material: Material): SoundMaterial{
    BLAZE(Material.BLAZE_ROD),
    CREEPER(Material.CREEPER_HEAD),
    DROWNED(Material.TRIDENT),
    ELDER_GUARDIAN(Material.ELDER_GUARDIAN_SPAWN_EGG),
    ENDERMAN(Material.ENDERMAN_SPAWN_EGG),
    ENDERMITE(Material.ENDERMITE_SPAWN_EGG),
    ENDER_DRAGON(Material.DRAGON_HEAD),
    EVOKER(Material.EVOKER_SPAWN_EGG),
    GHAST(Material.GHAST_SPAWN_EGG),
    GUARDIAN(Material.GUARDIAN_SPAWN_EGG),
    HOSTILE(Material.IRON_AXE),
    HUSK(Material.HUSK_SPAWN_EGG),
    ILLUSIONER(Material.STICK),
    MAGMA_CUBE(Material.MAGMA_CUBE_SPAWN_EGG),
    PHANTOM(Material.PHANTOM_SPAWN_EGG),
    PIGLIN(Material.PIGLIN_SPAWN_EGG),
    PILLAGER(Material.PILLAGER_SPAWN_EGG),
    POLAR_BEAR(Material.POLAR_BEAR_SPAWN_EGG),
    RAVAGER(Material.RAVAGER_SPAWN_EGG),
    SHULKER(Material.SHULKER_SPAWN_EGG),
    SILVERFISH(Material.SILVERFISH_SPAWN_EGG),
    SKELETON(Material.SKELETON_SPAWN_EGG),
    SLIME(Material.SLIME_SPAWN_EGG),
    SPIDER(Material.SPIDER_SPAWN_EGG),
    STRAY(Material.STRAY_SPAWN_EGG),
    STRIDER(Material.STRIDER_SPAWN_EGG),
    VEX(Material.VEX_SPAWN_EGG),
    VINDICATOR(Material.VINDICATOR_SPAWN_EGG),
    WITCH(Material.WITCH_SPAWN_EGG),
    WITHER(Material.WITHER_SKELETON_SKULL),
    WITHER_SKELETON(Material.WITHER_SKELETON_SPAWN_EGG),
    ZOGLIN(Material.ZOGLIN_SPAWN_EGG),
    ZOMBIE(Material.ZOMBIE_SPAWN_EGG),
    ZOMBIE_VILLAGER(Material.ZOMBIE_VILLAGER_SPAWN_EGG),
    ZOMBIFIED_PIGLIN(Material.ZOMBIFIED_PIGLIN_SPAWN_EGG),
    ;

    override fun prefix(): String {
        return "ENTITY_${toString()}"
    }
}