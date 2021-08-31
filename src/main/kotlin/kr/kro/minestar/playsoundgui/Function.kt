package kr.kro.minestar.playsoundgui

import kr.kro.minestar.playsoundgui.enums.SoundMaterial
import net.kyori.adventure.sound.SoundStop
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

class Function {
    companion object {
        var list: MutableList<String>? = null
    }

    fun searchSounds(string: String): List<Sound> {
        val list = mutableListOf<Sound>()
        for (sound in Sound.values()) if (sound.name.contains(ChatColor.stripColor(string)!!.toUpperCase())) list.add(sound)
        return list
    }

    fun playSound(p: Player, sound:Sound){
        p.stopSound(SoundStop.all())
        p.playSound(p.location,sound,SoundCategory.MASTER,1F,1F)
        p.sendMessage("${Main.prefix} play $sound")
    }

    fun playSound(p: Player, string:String){
        p.stopSound(SoundStop.all())
        val sound = Sound.valueOf(string)
        p.playSound(p.location,sound,SoundCategory.MASTER,1F,1F)
        p.sendMessage("${Main.prefix} play $sound")
    }

    fun convertItem(soundMaterial: SoundMaterial): ItemStack {
        val item = ItemStack(soundMaterial.material)
        val itemMeta = item.itemMeta
        itemMeta.setDisplayName("§f$soundMaterial")
        for(flag in ItemFlag.values()){
            itemMeta.addItemFlags(flag)
        }
        item.itemMeta = itemMeta
        return item
    }

    fun convertSound(soundMaterial: SoundMaterial): ItemStack {
        val item = ItemStack(soundMaterial.material)
        val itemMeta = item.itemMeta
        itemMeta.setDisplayName("§f${soundMaterial.prefix()}")
        for (flag in ItemFlag.values()) {
            itemMeta.addItemFlags(flag)
        }
        item.itemMeta = itemMeta
        return item
    }

    fun convertItem(soundMaterial: SoundMaterial, sound: Sound): ItemStack {
        val item = ItemStack(soundMaterial.material)
        val itemMeta = item.itemMeta
        itemMeta.setDisplayName("§f$sound")
        for(flag in ItemFlag.values()){
            itemMeta.addItemFlags(flag)
        }
        item.itemMeta = itemMeta
        return item
    }
}
