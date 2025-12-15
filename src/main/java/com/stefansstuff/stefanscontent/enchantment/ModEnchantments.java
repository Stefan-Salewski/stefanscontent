package com.stefansstuff.stefanscontent.enchantment;

import com.stefansstuff.stefanscontent.StefansContent;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> KEEN_EYE = ResourceKey.create(
            Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(StefansContent.MODID, "keen_eye")
    );

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        register(context, KEEN_EYE,Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                5,
                2,
                Enchantment.dynamicCost(5,7),
                Enchantment.dynamicCost(25,7),
                2,
                EquipmentSlotGroup.MAINHAND
        )
                //HolderSet.empty(),
                //DataComponentMap.builder().set().build()
        ));

    }

    public static void register(BootstrapContext<Enchantment> registry,
                                ResourceKey<Enchantment> key,
                                Enchantment.Builder builder) {
        registry.register(key, builder.build(key.location()));
    }
}
