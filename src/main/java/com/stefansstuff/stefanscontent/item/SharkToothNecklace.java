package com.stefansstuff.stefanscontent.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
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

public class SharkToothNecklace extends AccessoryItem {

    public SharkToothNecklace() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.addStackable(ALObjects.Attributes.ARMOR_PIERCE, new AttributeModifier(ResourceLocation.fromNamespaceAndPath("stefanscontent", "shark_tooth_necklace_bonus"), 5, AttributeModifier.Operation.ADD_VALUE));
    }
}
