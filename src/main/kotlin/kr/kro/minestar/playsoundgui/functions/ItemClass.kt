package kr.kro.minestar.playsoundgui.functions

import kr.kro.minestar.playsoundgui.enums.Scale
import kr.kro.minestar.playsoundgui.enums.SoundMaterial
import kr.kro.minestar.utility.item.Slot
import kr.kro.minestar.utility.item.setDisplay
import kr.kro.minestar.utility.material.item
import org.bukkit.Material
import org.bukkit.SoundCategory
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import kotlin.math.round

object ItemClass {

    fun convertItem(soundMaterial: SoundMaterial): ItemStack {
        val item = soundMaterial.material.item().setDisplay("§f$soundMaterial")
        for (flag in ItemFlag.values()) item.addItemFlags(flag)
        return item
    }

    fun buttonSlots(guiSize: Int, soundCategory: SoundCategory, volume: Float, pitch: Float, scale: Scale?): List<Slot> {
        val line: Int = if (guiSize < 9) 0
        else if (guiSize > 9 * 6) 5
        else guiSize / 9 - 1

        return listOf(
            Slot(line, 0, backItem()),
            Slot(line, 2, outPortItem(soundCategory)),
            Slot(line, 4, stopItem()),
            Slot(line, 6, volumeItem(volume)),
            Slot(line, 7, pitchItem(pitch)),
            Slot(line, 8, scaleItem(scale)),
        )
    }

    fun backItem(): ItemStack {
        val item = Material.MOJANG_BANNER_PATTERN.item().setDisplay("§f§9MOVE TO BACK")
        for (flag in ItemFlag.values()) item.addItemFlags(flag)
        return item
    }

    fun stopItem() = Material.BARRIER.item().setDisplay("§f§cSOUND STOP")

    fun outPortItem(soundCategory: SoundCategory): ItemStack {
        val material = when (soundCategory) {
            SoundCategory.MASTER -> Material.STRUCTURE_VOID
            SoundCategory.MUSIC -> Material.MUSIC_DISC_PIGSTEP
            SoundCategory.RECORDS -> Material.MUSIC_DISC_CAT
            SoundCategory.WEATHER -> Material.WATER_BUCKET
            SoundCategory.BLOCKS -> Material.GRASS_BLOCK
            SoundCategory.HOSTILE -> Material.ZOMBIE_HEAD
            SoundCategory.NEUTRAL -> Material.OAK_SAPLING
            SoundCategory.PLAYERS -> Material.PLAYER_HEAD
            SoundCategory.AMBIENT -> Material.DEAD_BUSH
            SoundCategory.VOICE -> Material.PARROT_SPAWN_EGG
        }
        val item = material.item().setDisplay("§fSOUND CATEGORY : §9$soundCategory")
        item.lore = mutableListOf(
            " ",
            "§f§8PREV : LEFT CLICK",
            "§f§8NEXT : RIGHT CLICK"
        )
        for (flag in ItemFlag.values()) item.addItemFlags(flag)
        return item
    }

    fun volumeItem(volume: Float): ItemStack {
        val item = Material.JUKEBOX.item().setDisplay("§fVOLUME : §9${round(volume * 100) / 100}")
        item.lore = mutableListOf(
            " ",
            "§f§8+0.01 : SHIFT LEFT CLICK",
            "§f§8+0.1 : LEFT CLICK",
            "§f§8-0.1 : RIGHT CLICK",
            "§f§8-0.01 : SHIFT RIGHT CLICK",
        )
        return item
    }

    fun pitchItem(pitch: Float): ItemStack {
        val item = Material.JUKEBOX.item().setDisplay("§fPITCH : §9${round(pitch * 100) / 100}")
        item.lore = mutableListOf(
            " ",
            "§f§8+0.01 : SHIFT LEFT CLICK",
            "§f§8+0.1 : LEFT CLICK",
            "§f§8-0.1 : RIGHT CLICK",
            "§f§8-0.01 : SHIFT RIGHT CLICK",
        )
        return item
    }

    fun scaleItem(scale: Scale?): ItemStack {
        val item = scale?.material?.item()?.setDisplay("§fSCALE : §9$scale") ?: Material.STRUCTURE_VOID.item().setDisplay("§fSCALE : §9NULL")
        item.lore = mutableListOf(
            " ",
            "§f§8PREV : LEFT CLICK",
            "§f§8NEXT : RIGHT CLICK",
            "§f§8CLEAR : SHIFT LEFT CLICK",
        )
        return item
    }
}