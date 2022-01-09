package kr.kro.minestar.playsoundgui

import kr.kro.minestar.playsoundgui.functions.gui.Category
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object CMD : CommandExecutor {
    override fun onCommand(player: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if (player !is Player) return false
        if (!player.isOp) return false
        Category(player)
        player.playSound(player.location, Sound.BLOCK_WOODEN_DOOR_OPEN, SoundCategory.MASTER, 1.0F, 1.5F)
        return false
    }
}