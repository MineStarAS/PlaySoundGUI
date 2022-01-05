package kr.kro.minestar.playsoundgui.enums

import org.bukkit.Material

enum class Scale(val float: Float, val material: Material) {
    L_FA_SHARP(0.5F, Material.PINK_TERRACOTTA),
    L_SOL(0.53F, Material.PINK_CONCRETE_POWDER),
    L_SOL_SHARP(0.56F, Material.MAGENTA_TERRACOTTA),
    L_LA(0.6F, Material.MAGENTA_CONCRETE_POWDER),
    L_LA_SHARP(0.63F, Material.PURPLE_TERRACOTTA),
    L_TI(0.67F, Material.PURPLE_CONCRETE_POWDER),
    DO(0.7F, Material.RED_WOOL),
    DO_SHARP(0.75F, Material.RED_CONCRETE),
    RE(0.8F, Material.ORANGE_WOOL),
    RE_SHARP(0.85F, Material.ORANGE_CONCRETE),
    MI(0.9F, Material.YELLOW_WOOL),
    FA(0.95F, Material.LIME_WOOL),
    FA_SHARP(1.0F, Material.LIME_CONCRETE),
    SOL(1.05F, Material.GREEN_WOOL),
    SOL_SHARP(1.1F, Material.GREEN_CONCRETE),
    LA(1.2F, Material.CYAN_WOOL),
    LA_SHARP(1.25F, Material.CYAN_CONCRETE),
    TI(1.32F, Material.LIGHT_BLUE_WOOL),
    H_DO(1.4F, Material.BLUE_WOOL),
    H_DO_SHAR(1.5F, Material.BLUE_CONCRETE),
    H_RE(1.6F, Material.PINK_WOOL),
    H_RE_SHARP(1.7F, Material.PINK_CONCRETE),
    H_MI(1.8F, Material.MAGENTA_WOOL),
    H_FA(1.9F, Material.PURPLE_WOOL),
    H_FA_SHARP(2.0F, Material.PURPLE_CONCRETE),
    ;
}
