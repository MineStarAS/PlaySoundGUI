package kr.kro.minestar.playsoundgui.enums.menus

import kr.kro.minestar.playsoundgui.enums.SoundMaterial
import org.bukkit.Material

enum class ObjectEntity(override var material: Material) : SoundMaterial {
    ARMOR_STAND(Material.ARMOR_STAND),
    ARROW(Material.ARROW),
    BOAT_PADDLE(Material.OAK_BOAT),
    DRAGON_FIREBALL(Material.FIRE_CHARGE),
    EGG(Material.EGG),
    ENDER_EYE(Material.ENDER_EYE),
    EXPERIENCE(Material.EXPERIENCE_BOTTLE),
    FIREWORK_ROCKET(Material.FIREWORK_ROCKET),
    FISHING_BOBBER(Material.FISHING_ROD),
    GENERIC(Material.STRUCTURE_VOID),
    GLOW_ITEM_FRAME(Material.GLOW_ITEM_FRAME),
    ITEM_FRAME(Material.ITEM_FRAME),
    ITEM(Material.ITEM_FRAME),
    LINGERING(Material.LINGERING_POTION),
    MINECART(Material.MINECART),
    PAINTING(Material.PAINTING),
    SNOWBALL(Material.SNOWBALL),
    SPLASH_POTION(Material.SPLASH_POTION),
    TNT(Material.TNT),
    ;

    override fun prefix(): String {
        return "ENTITY_${toString()}"
    }
}