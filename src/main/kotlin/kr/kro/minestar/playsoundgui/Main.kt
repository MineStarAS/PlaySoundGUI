package kr.kro.minestar.playsoundgui

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        var pl: Main? = null
        const val prefix = "§f§7[§9PlaySoundGUI§7]§f"
    }

    override fun onEnable() {
        pl = this
        logger.info("$prefix §aEnable")
        getCommand("sound")?.setExecutor(CMD())
    }

    override fun onDisable() {

    }
}