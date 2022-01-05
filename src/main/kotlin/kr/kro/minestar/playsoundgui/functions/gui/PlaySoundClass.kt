package kr.kro.minestar.playsoundgui.functions.gui

import kr.kro.minestar.utility.string.unColor
import org.bukkit.Sound

object PlaySoundClass {

    fun guiSize(size : Int): Int {
        return if (size % 9 > 0) size / 9 * 9 + 18
        else size / 9 * 9 + 9
    }

    fun searchSounds(string: String): List<Sound> {
        val list = mutableListOf<Sound>()
        for (sound in Sound.values()) if (sound.name.contains(string.unColor().uppercase())) list.add(sound)
        return list
    }
}