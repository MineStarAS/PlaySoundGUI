package kr.kro.minestar.playsoundgui.enums

import org.bukkit.Material

enum class NonHostileEntity(override var material: Material) : SoundMaterial {
    AXOLOTL(Material.AXOLOTL_SPAWN_EGG),
    BAT(Material.BAT_SPAWN_EGG),
    BEE(Material.BEE_SPAWN_EGG),
    CAT(Material.CAT_SPAWN_EGG),
    CHICKEN(Material.CHICKEN_SPAWN_EGG),
    COD(Material.COD),
    COW(Material.COW_SPAWN_EGG),
    DOLPHIN(Material.DOLPHIN_SPAWN_EGG),
    DONKEY(Material.DONKEY_SPAWN_EGG),
    FISH(Material.COD_BUCKET),
    FOX(Material.FOX_SPAWN_EGG),
    GLOW_SQUID(Material.GLOW_SQUID_SPAWN_EGG),
    GOAT(Material.GOAT_SPAWN_EGG),
    HORSE(Material.HORSE_SPAWN_EGG),
    IRON_GOLEM(Material.IRON_BLOCK),
    LLAMA(Material.LLAMA_SPAWN_EGG),
    MULE(Material.MULE_SPAWN_EGG),
    OCELOT(Material.OCELOT_SPAWN_EGG),
    PANDA(Material.PANDA_SPAWN_EGG),
    PARROT(Material.PARROT_SPAWN_EGG),
    PIG(Material.PIG_SPAWN_EGG),
    PLAYER(Material.PLAYER_HEAD),
    PUFFER_FISH(Material.PUFFERFISH),
    RABBIT(Material.RABBIT_SPAWN_EGG),
    SALMON(Material.SALMON),
    SHEEP(Material.SHEEP_SPAWN_EGG),
    SNOW_GOLEM(Material.CARVED_PUMPKIN),
    SQUID(Material.SQUID_SPAWN_EGG),
    TROPICAL_FISH(Material.TROPICAL_FISH_SPAWN_EGG),
    TURTLE(Material.TURTLE_SPAWN_EGG),
    VILLAGER(Material.VILLAGER_SPAWN_EGG),
    WANDERING_TRADER(Material.WANDERING_TRADER_SPAWN_EGG),
    WOLF(Material.WOLF_SPAWN_EGG),
    ZOMBIE_HORSE(Material.ZOMBIE_HORSE_SPAWN_EGG),
    ;

    override fun prefix(): String {
        return "ENTITY_${toString()}"
    }
}