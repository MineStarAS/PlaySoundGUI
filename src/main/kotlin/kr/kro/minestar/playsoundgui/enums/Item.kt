package kr.kro.minestar.playsoundgui.enums

import org.bukkit.Material

enum class Item(override var material: Material): SoundMaterial{

    ARMOR(Material.IRON_CHESTPLATE),
    AXE(Material.IRON_AXE),
    BONE(Material.BONE),
    BOOK(Material.BOOK),
    BOTTLE(Material.GLASS_BOTTLE),
    BUCKET(Material.BUCKET),
    CHORUS_FRUIT(Material.CHORUS_FRUIT),
    CROP(Material.WHEAT),
    CROSSBOW(Material.CROSSBOW),
    DYE(Material.RED_DYE),
    ELYTRA(Material.ELYTRA),
    FIRECHARGE(Material.FIRE_CHARGE),
    FLINTANDSTEEL(Material.FLINT_AND_STEEL),
    GLOW_INK_SAC(Material.GLOW_INK_SAC),
    HOE(Material.IRON_HOE),
    HONEYCOMB(Material.HONEYCOMB),
    HONEY_BOTTLE(Material.HONEY_BOTTLE),
    INK_SAC(Material.INK_SAC),
    LODESTONE(Material.LODESTONE),
    NETHER_WART(Material.NETHER_WART),
    SHIELD(Material.SHIELD),
    SHOVEL(Material.IRON_SHOVEL),
    SPYGLASS(Material.SPYGLASS),
    TOTEM(Material.TOTEM_OF_UNDYING),
    TRIDENT(Material.TRIDENT),
}