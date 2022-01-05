package kr.kro.minestar.playsoundgui.enums

import org.bukkit.Material

enum class CategoryEnum(override val material: Material, val isMenu: Boolean): SoundMaterial {
    AMBIENT(Material.DEAD_BUSH, true),
    BLOCK1(Material.STONE, true),
    BLOCK2(Material.GRASS_BLOCK, true),
    BLOCK3(Material.DIRT, true),
    ENCHANT(Material.ENCHANTING_TABLE, false),
    HOSTILE_ENTITY(Material.CREEPER_HEAD, true),
    NON_HOSTILE_ENTITY(Material.PLAYER_HEAD, true),
    OBJECT_ENTITY(Material.MINECART, true),
    EVENT(Material.IRON_AXE, false),
    ITEM(Material.ITEM_FRAME, true),
    MUSIC(Material.MUSIC_DISC_CAT, false),
    PARTICLE(Material.ENDER_EYE, false),
    UI(Material.CRAFTING_TABLE, false),
    WEATHER(Material.WATER_BUCKET, false),
}