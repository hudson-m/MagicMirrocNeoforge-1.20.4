package com.hudshow.neoforge.data.lootable;

import com.google.common.collect.Sets;
import com.hudshow.neoforge.MagicMirror;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ModLootTables extends LootTableProvider {
    public ModLootTables(PackOutput p_254123_) {
        super(p_254123_, Set.of(), List.of(new SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)));
    }

    @Override
    public void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationContext) {
       var modLootTablesId = BuiltInLootTables.all()
               .stream()
               .filter(id -> id.getNamespace().equals(MagicMirror.MOD_ID))
               .collect(Collectors.toSet());

       for (var id : Sets.difference(modLootTablesId, map.keySet())) {
           validationContext.reportProblem("Missing mod loot table: " + id);
       }

       map.forEach((id, lootTable) -> lootTable.validate(validationContext));
    }
}
