package kr.kro.minestar.playsoundgui.enums

import org.bukkit.Material

enum class Event(override var material: Material): SoundMaterial{
    RAID_HORN(Material.IRON_AXE),
}