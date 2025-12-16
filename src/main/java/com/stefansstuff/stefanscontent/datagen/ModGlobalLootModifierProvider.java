package com.stefansstuff.stefanscontent.datagen;

import com.stefansstuff.stefanscontent.StefansContent;
import com.stefansstuff.stefanscontent.item.ModItems;
import com.stefansstuff.stefanscontent.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, StefansContent.MODID);
    }

    @Override
    protected void start() {
        this.add("sharktoothnecklace_from_shipwreck_supply",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_supply")).build(),
                        LootItemRandomChanceCondition.randomChance(0.55f).build(),
                }, ModItems.SHARKTOOTHNECKLACE.get()));
        this.add("sharktoothnecklace_from_shipwreck_map",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_map")).build(),
                        LootItemRandomChanceCondition.randomChance(0.15f).build(),
                }, ModItems.SHARKTOOTHNECKLACE.get()));
        this.add("sharktoothnecklace_from_shipwreck_treasure",
                new AddItemModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(0.85f).build(),
                }, ModItems.SHARKTOOTHNECKLACE.get()));
    }
}
/* LIST OF ALL CHEST NAMES
ALL START WITH chests/
trial_chambers/corridor
trial_chambers/entrance
trial_chambers/intersection
trial_chambers/intersection_barrel
trial_chambers/reward
trial_chambers/reward_common
trial_chambers/reward_ominous
trial_chambers/reward_ominous_common
trial_chambers/reward_ominous_rare
trial_chambers/reward_ominous_unique
trial_chambers/reward_rare
trial_chambers/reward_unique
trial_chambers/supply

village/village_armorer
village/village_butcher
village/village_cartographer
village/village_desert_house
village/village_fisher
village/village_mason
village/village_plains_house
village/village_savanna_house
village/village_shepherd
village/village_snowy_house
village/village_taiga_house
village/village_tannery
village/village_temple
village/village_toolsmith
village/village_weaponsmith

village/village_armorer
village/village_butcher
village/village_cartographer
village/village_desert_house
village/village_fisher
village/village_mason
village/village_plains_house
village/village_savanna_house
village/village_shepherd
village/village_snowy_house
village/village_taiga_house
village/village_tannery
village/village_temple
village/village_toolsmith
village/village_weaponsmith

abandoned_mineshaft
ancient_city
ancient_city_ice_box
bastion_bridge
bastion_hoglin_stable
bastion_other
bastion_treasure
buried_treasure
desert_pyramid
end_city_treasure
igloo_chest
jungle_temple
jungle_temple_dispenser
nether_bridge
pillager_outpost
ruined_portal
shipwreck_map
shipwreck_supply
shipwreck_treasure
simple_dungeon
spawn_bonus_chest
stronghold_corridor
stronghold_crossing
stronghold_library
underwater_ruin_big
underwater_ruin_small
 */