package kr.kro.minestar.playsoundgui

import kr.kro.minestar.playsoundgui.functions.gui.Category
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CMD : CommandExecutor {
    override fun onCommand(player: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if (player !is Player) return false
        if (!player.isOp) return false
        Category(player)
        return false
    }
}