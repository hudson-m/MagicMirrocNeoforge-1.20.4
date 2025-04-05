package com.hudshow.neoforge.data.lootable;

import com.hudshow.neoforge.MagicMirror;
import com.hudshow.neoforge.core.init.BlockInit;
import com.hudshow.neoforge.core.init.ItemInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        // normal ores
        //add(BlockInit.EXAMPLE_ORE.get(), createOreDrop(BlockInit.EXAMPLE_ORE.get(), ItemInit.RAW_EXAMPLE.get()));

        // deepslate ores
        //add(BlockInit.DEEPSLATE_EXAMPLE_ORE.get(), createOreDrop(BlockInit.DEEPSLATE_EXAMPLE_ORE.get(), ItemInit.RAW_EXAMPLE.get()));

        //dropSelf(BlockInit.EXAMPLE_BLOCK.get());
    }

//    @Override
//    public @NotNull Iterable<Block> getKnownBlocks() {
//        return BuiltInRegistries.BLOCK.stream()
//                .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
//                        .filter(key -> key.getNamespace().equals(MagicMirror.MOD_ID))
//                        .isPresent())
//                .collect(Collectors.toSet());
//    }
}
