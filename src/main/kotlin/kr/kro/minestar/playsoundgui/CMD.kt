package kr.kro.minestar.playsoundgui

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CMD : CommandExecutor {
    override fun onCommand(p: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        if (p !is Player) return false
        if (!p.isOp) return false
        GUI().guiOpenFromCMD(p,GUI().categoryGUI())
        return false
    }
}