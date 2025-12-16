package com.stefansstuff.stefanscontent.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.wispforest.accessories.api.AccessoryItem;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.spell_power.api.SpellSchools;

import java.util.UUID;

public class MageCape extends AccessoryItem {

    public MageCape() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        System.out.println("test");
        builder.addStackable(SpellSchools.GENERIC.getAttributeEntry(), new AttributeModifier(ResourceLocation.fromNamespaceAndPath("stefanscontent", "cape_bonus"), 1, AttributeModifier.Operation.ADD_VALUE));
    }
}
