package com.hudshow.neoforge.data.world;

import com.hudshow.neoforge.MagicMirror;
import com.hudshow.neoforge.worldgen.ModBiomesModifiers;
import com.hudshow.neoforge.worldgen.ModConfiguredFeatures;
import com.hudshow.neoforge.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries,
                new RegistrySetBuilder()
                                .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap)
                                //.add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
                                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomesModifiers::bootstrap),
                Set.of(MagicMirror.MOD_ID));
    }
}
