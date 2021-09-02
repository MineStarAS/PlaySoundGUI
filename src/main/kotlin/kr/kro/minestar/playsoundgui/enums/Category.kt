package kr.kro.minestar.playsoundgui.enums

import org.bukkit.Material

enum class Category(override var material: Material): SoundMaterial{
    AMBIENT(Material.DEAD_BUSH),
    BLOCK1(Material.STONE),
    BLOCK2(Material.GRASS_BLOCK),
    BLOCK3(Material.DIRT),
    ENCHANT(Material.ENCHANTING_TABLE),
    HOSTILE_ENTITY(Material.CREEPER_HEAD),
    NON_HOSTILE_ENTITY(Material.PLAYER_HEAD),
    OBJECT_ENTITY(Material.MINECART),
    EVENT(Material.IRON_AXE),
    ITEM(Material.ITEM_FRAME),
    MUSIC(Material.MUSIC_DISC_CAT),
    PARTICLE(Material.ENDER_EYE),
    UI(Material.CRAFTING_TABLE),
    WEATHER(Material.WATER_BUCKET),
}