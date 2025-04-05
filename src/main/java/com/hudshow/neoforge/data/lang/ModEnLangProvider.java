package com.hudshow.neoforge.data.lang;

import com.hudshow.neoforge.MagicMirror;
import com.hudshow.neoforge.core.init.BlockInit;
import com.hudshow.neoforge.core.init.CreativeModeTabInit;
import com.hudshow.neoforge.core.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnLangProvider extends LanguageProvider {
    public ModEnLangProvider(PackOutput output) {
        super(output, MagicMirror.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        // items
//        addItem(ItemInit.EXAMPLE_ITEM, "Example Item");
//        addItem(ItemInit.RAW_EXAMPLE, "Raw Example");
        //addItem(ItemInit.HEALING_APPLE, "Healing apple");

        addItem(ItemInit.MAGIC_MIRROR, "Magic mirror");

        // blocks
//        addBlock(BlockInit.EXAMPLE_BLOCK, "Example Block");
//        addBlock(BlockInit.EXAMPLE_ORE, "Example Ore");
//        addBlock(BlockInit.DEEPSLATE_EXAMPLE_ORE, "Deepslate Example Ore");

        // tools
//        addItem(ItemInit.SWORD, "Sword");
//        addItem(ItemInit.PICKAXE, "Pickaxe");

        //armour
//        addItem(ItemInit.HELMET, "Helmet");
//        addItem(ItemInit.CHESTPLATE, "Chestplate");
//        addItem(ItemInit.LEGGINGS, "Leggings");
//        addItem(ItemInit.BOOTS, "Boots");

        // others
        add(CreativeModeTabInit.MAGIC_MIRROR_TAB_TITLE, "Magic Mirror");
    }
}
