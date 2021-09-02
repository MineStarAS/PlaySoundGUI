package kr.kro.minestar.playsoundgui

import kr.kro.minestar.playsoundgui.enums.*
import org.bukkit.*
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

class Function {
    companion object {
        var list: MutableList<String>? = null
    }

    fun getSoundMaterial(title: String, display: String): SoundMaterial? {
        var array: Array<*>? = null
        when (title) {
            "AMBIENT" -> array = Ambient.values()
            "BLOCK1" -> array = Block1.values()
            "BLOCK2" -> array = Block2.values()
            "BLOCK3" -> array = Block3.values()
            "HOSTILE_ENTITY" -> array = HostileEntity.values()
            "NON_HOSTILE_ENTITY" -> array = NonHostileEntity.values()
            "OBJECT_ENTITY" -> array = ObjectEntity.values()
            "ITEM" -> array = Item.values()
        }
        for (soundMaterial in array!!) if (soundMaterial.toString().contains(display)) return soundMaterial as SoundMaterial
        return null
    }

    fun searchSounds(string: String): List<Sound> {
        val list = mutableListOf<Sound>()
        for (sound in Sound.values()) if (sound.name.contains(ChatColor.stripColor(string)!!.toUpperCase())) list.add(sound)
        return list
    }

    fun convertItem(soundMaterial: SoundMaterial): ItemStack {
        val item = ItemStack(soundMaterial.material)
        val itemMeta = item.itemMeta
        itemMeta.setDisplayName("§f$soundMaterial")
        for (flag in ItemFlag.values()) {
            itemMeta.addItemFlags(flag)
        }
        item.itemMeta = itemMeta
        return item
    }

    fun convertSound(soundMaterial: SoundMaterial): ItemStack {
        val item = ItemStack(soundMaterial.material)
        val itemMeta = item.itemMeta
        itemMeta.setDisplayName("§f${soundMaterial.prefix()}")
        for (flag in ItemFlag.values()) itemMeta.addItemFlags(flag)
        item.itemMeta = itemMeta
        return item
    }

    fun convertItem(soundMaterial: SoundMaterial, sound: Sound): ItemStack {
        val item = ItemStack(soundMaterial.material)
        val itemMeta = item.itemMeta
        itemMeta.setDisplayName("§f$sound")
        for (flag in ItemFlag.values()) itemMeta.addItemFlags(flag)
        item.itemMeta = itemMeta
        return item
    }

    fun backItem(): ItemStack {
        var display = "§f§9MOVE TO BACK"
        val item = ItemStack(Material.MOJANG_BANNER_PATTERN)
        val itemMeta = item.itemMeta
        itemMeta.setDisplayName(display)
        for (flag in ItemFlag.values()) itemMeta.addItemFlags(flag)
        item.itemMeta = itemMeta
        return item
    }

    fun stopItem(): ItemStack {
        var display = "§f§cSOUND STOP"
        val item = ItemStack(Material.BARRIER)
        val itemMeta = item.itemMeta
        itemMeta.setDisplayName(display)
        item.itemMeta = itemMeta
        return item
    }

    fun outPortItem(soundCategory: SoundCategory): ItemStack {
        var display = "§fSOUND CATEGORY : §9$soundCategory"
        var description = mutableListOf(
            "PREV : LEFT CLICK",
            "NEXT : RIGHT CLICK"
        )
        var material = when (soundCategory) {
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
        val item = ItemStack(material)
        val itemMeta = item.itemMeta
        val lore = mutableListOf(" ")
        for (s in description) lore.add("§f§8$s")
        itemMeta.lore = lore
        itemMeta.setDisplayName(display)
        for (flag in ItemFlag.values()) itemMeta.addItemFlags(flag)
        item.itemMeta = itemMeta
        return item
    }

    fun volumeItem(volume: Float): ItemStack {
        var display = "§fVOLUME : §9$volume"
        var description = mutableListOf(
            "+0.01 : LEFT CLICK",
            "+0.1 : SHIFT LEFT CLICK",
            "-0.1 : SHIFT RIGHT CLICK",
            "-0.01 : RIGHT CLICK",
        )
        val item = ItemStack(Material.JUKEBOX)
        val itemMeta = item.itemMeta
        val lore = mutableListOf(" ")
        for (s in description) lore.add("§f§8$s")
        itemMeta.lore = lore
        itemMeta.setDisplayName(display)
        item.itemMeta = itemMeta
        return item
    }

    fun pitchItem(pitch: Float): ItemStack {
        var display = "§fPITCH : §9$pitch"
        var description = mutableListOf(
            "+0.01 : LEFT CLICK",
            "+0.1 : SHIFT LEFT CLICK",
            "-0.1 : SHIFT RIGHT CLICK",
            "-0.01 : RIGHT CLICK",
        )
        val item = ItemStack(Material.JUKEBOX)
        val itemMeta = item.itemMeta
        val lore = mutableListOf(" ")
        for (s in description) lore.add("§f§8$s")
        itemMeta.lore = lore
        itemMeta.setDisplayName(display)
        item.itemMeta = itemMeta
        return item
    }

    fun scaleItem(scale: Scale): ItemStack {
        var display = "§fSCALE : §9$scale"
        var description = mutableListOf(
            "PREV : LEFT CLICK",
            "NEXT : RIGHT CLICK"
        )
        val item = ItemStack(scale.material)
        val itemMeta = item.itemMeta
        val lore = mutableListOf(" ")
        for (s in description) lore.add("§f§8$s")
        itemMeta.lore = lore
        itemMeta.setDisplayName(display)
        item.itemMeta = itemMeta
        return item
    }
}
