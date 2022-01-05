package kr.kro.minestar.playsoundgui.enums.menus

import kr.kro.minestar.playsoundgui.enums.SoundMaterial
import org.bukkit.Material

enum class NonHostileEntity(override var material: Material) : SoundMaterial {
    AXOLOTL(Material.AXOLOTL_BUCKET),
    BAT(Material.BAT_SPAWN_EGG),
    BEE(Material.BEE_NEST),
    CAT(Material.CAT_SPAWN_EGG),
    CHICKEN(Material.EGG),
    COD(Material.COD),
    COW(Material.MILK_BUCKET),
    DOLPHIN(Material.DOLPHIN_SPAWN_EGG),
    DONKEY(Material.DONKEY_SPAWN_EGG),
    FISH(Material.COD_BUCKET),
    FOX(Material.SWEET_BERRIES),
    GLOW_SQUID(Material.GLOW_INK_SAC),
    GOAT(Material.GOAT_SPAWN_EGG),
    HORSE(Material.LEATHER_HORSE_ARMOR),
    IRON_GOLEM(Material.IRON_BLOCK),
    LLAMA(Material.LLAMA_SPAWN_EGG),
    MULE(Material.MULE_SPAWN_EGG),
    OCELOT(Material.OCELOT_SPAWN_EGG),
    PANDA(Material.BAMBOO),
    PARROT(Material.PARROT_SPAWN_EGG),
    PIG(Material.PORKCHOP),
    PLAYER(Material.PLAYER_HEAD),
    PUFFER_FISH(Material.PUFFERFISH),
    RABBIT(Material.RABBIT_HIDE),
    SALMON(Material.SALMON),
    SHEEP(Material.WHITE_WOOL),
    SNOW_GOLEM(Material.CARVED_PUMPKIN),
    SQUID(Material.INK_SAC),
    TROPICAL_FISH(Material.TROPICAL_FISH_BUCKET),
    TURTLE(Material.TURTLE_EGG),
    VILLAGER(Material.VILLAGER_SPAWN_EGG),
    WANDERING_TRADER(Material.WANDERING_TRADER_SPAWN_EGG),
    WOLF(Material.BONE),
    ZOMBIE_HORSE(Material.ZOMBIE_HORSE_SPAWN_EGG),
    ;

    override fun prefix(): String {
        return "ENTITY_${toString()}"
    }
}