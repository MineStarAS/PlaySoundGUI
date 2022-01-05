package kr.kro.minestar.playsoundgui.functions.gui

import kr.kro.minestar.playsoundgui.enums.CategoryEnum
import kr.kro.minestar.playsoundgui.enums.SoundMaterial
import kr.kro.minestar.playsoundgui.enums.menus.*

object MenuClass {

    fun getValues(categoryEnum: CategoryEnum): Array<SoundMaterial> {
        return when (categoryEnum) {
            CategoryEnum.AMBIENT -> Ambient.values() as Array<SoundMaterial>
            CategoryEnum.BLOCK1 -> Block1.values() as Array<SoundMaterial>
            CategoryEnum.BLOCK2 -> Block2.values() as Array<SoundMaterial>
            CategoryEnum.BLOCK3 -> Block3.values() as Array<SoundMaterial>
            CategoryEnum.ENCHANT -> Enchant.values() as Array<SoundMaterial>
            CategoryEnum.HOSTILE_ENTITY -> HostileEntity.values() as Array<SoundMaterial>
            CategoryEnum.NON_HOSTILE_ENTITY -> NonHostileEntity.values() as Array<SoundMaterial>
            CategoryEnum.OBJECT_ENTITY -> ObjectEntity.values() as Array<SoundMaterial>
            CategoryEnum.EVENT -> Event.values() as Array<SoundMaterial>
            CategoryEnum.ITEM -> Item.values() as Array<SoundMaterial>
            CategoryEnum.MUSIC -> Music.values() as Array<SoundMaterial>
            CategoryEnum.PARTICLE -> Particle.values() as Array<SoundMaterial>
            CategoryEnum.UI -> UI.values() as Array<SoundMaterial>
            CategoryEnum.WEATHER -> Weather.values() as Array<SoundMaterial>
        }
    }

    fun guiSize(categoryEnum: CategoryEnum): Int {
        val enumValues = getValues(categoryEnum)
        return if (enumValues.size % 9 > 0) (enumValues.size / 9) * 9 + 18
        else (enumValues.size / 9) * 9 + 9
    }
}