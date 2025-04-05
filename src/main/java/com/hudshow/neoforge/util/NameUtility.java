package com.hudshow.neoforge.util;

import com.hudshow.neoforge.MagicMirror;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class NameUtility {

    public static String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(MagicMirror.MOD_ID + ":", "");
    }

    public static String getBlockName(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block).toString().replace(MagicMirror.MOD_ID + ":", "");
    }
}
