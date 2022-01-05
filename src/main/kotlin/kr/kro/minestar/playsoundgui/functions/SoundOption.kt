package kr.kro.minestar.playsoundgui.functions

import kr.kro.minestar.playsoundgui.Main
import kr.kro.minestar.playsoundgui.enums.Scale
import org.bukkit.SoundCategory
import org.bukkit.entity.Player

class SoundOption(player: Player) {
    var soundCategory = SoundCategory.MASTER
    var volume = 1F
    var pitch = 1F
    var scale: Scale? = null

    init {
        Main.soundOptionMap[player] = this
    }
}