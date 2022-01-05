package kr.kro.minestar.playsoundgui.enums.menus

import kr.kro.minestar.playsoundgui.enums.SoundMaterial
import org.bukkit.Material

enum class Music(override var material: Material): SoundMaterial {
    CREATIVE(Material.CRAFTING_TABLE),
    CREDITS(Material.CRAFTING_TABLE),
    DISC_11(Material.MUSIC_DISC_11),
    DISC_13(Material.MUSIC_DISC_13),
    DISC_BLOCKS(Material.MUSIC_DISC_BLOCKS),
    DISC_CAT(Material.MUSIC_DISC_CAT),
    DISC_CHIRP(Material.MUSIC_DISC_CHIRP),
    DISC_FAR(Material.MUSIC_DISC_FAR),
    DISC_MALL(Material.MUSIC_DISC_MALL),
    DISC_MELLOHI(Material.MUSIC_DISC_MELLOHI),
    DISC_PIGSTEP(Material.MUSIC_DISC_PIGSTEP),
    DISC_STAL(Material.MUSIC_DISC_STAL),
    DISC_STRAD(Material.MUSIC_DISC_STRAD),
    DISC_WAIT(Material.MUSIC_DISC_WAIT),
    DISC_WARD(Material.MUSIC_DISC_WARD),
    DRAGON(Material.DRAGON_HEAD),
    END(Material.GRASS_BLOCK),
    GAME(Material.GRASS_BLOCK),
    MENU(Material.GRASS_BLOCK),
    NETHER_BASALT_DELTAS(Material.BASALT),
    NETHER_CRIMSON_FOREST(Material.CRIMSON_NYLIUM),
    NETHER_NETHER_WASTES(Material.NETHERRACK),
    NETHER_SOUL_SAND_VALLEY(Material.SOUL_SAND),
    NETHER_WARPED_FOREST(Material.WARPED_NYLIUM),
    UNDER_WATER(Material.WATER),
}