package kr.kro.minestar.playsoundgui

import kr.kro.minestar.playsoundgui.functions.SoundOption
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        lateinit var pl: Main
        const val prefix = "§f§7[§9PlaySoundGUI§7]§f"
        val soundOptionMap = hashMapOf<Player, SoundOption>()
    }

    override fun onEnable() {
        pl = this
        logger.info("$prefix §aEnable")
        getCommand("soundgui")?.setExecutor(CMD())
    }

    override fun onDisable() {
        for (player in Bukkit.getOnlinePlayers()) {
            try {
                player.closeInventory()
            } catch (e1: Exception) {
            }
        }
    }
}