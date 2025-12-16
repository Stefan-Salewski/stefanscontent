package com.stefansstuff.stefanscontent.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.wispforest.accessories.api.AccessoryItem;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.spell_power.api.SpellPowerMechanics;
import net.spell_power.api.SpellSchools;

import java.util.List;
import java.util.UUID;

public class JeweledGauntlet extends AccessoryItem {

    public JeweledGauntlet() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        builder.addStackable(SpellSchools.GENERIC.getAttributeEntry(), new AttributeModifier(ResourceLocation.fromNamespaceAndPath("stefanscontent", "cape_bonus"), 2, AttributeModifier.Operation.ADD_VALUE));
    }


@Override
    public void tick(ItemStack stack, SlotReference reference) {
        var entity = reference.entity();
        double spellpower = entity.getAttributeValue(SpellSchools.FIRE.getAttributeEntry()) + entity.getAttributeValue(SpellSchools.FROST.getAttributeEntry()) +
                entity.getAttributeValue(SpellSchools.ARCANE.getAttributeEntry()) + entity.getAttributeValue(SpellSchools.LIGHTNING.getAttributeEntry()) +
                entity.getAttributeValue(SpellSchools.HEALING.getAttributeEntry()) + entity.getAttributeValue(SpellSchools.SOUL.getAttributeEntry());
        double crit_chance = spellpower/70; //18/70 is ~25% crit chance

        ResourceLocation key = ResourceLocation.fromNamespaceAndPath("stefanscontent", "jg_crit_chance");

        var critAttr = entity.getAttribute(SpellPowerMechanics.CRITICAL_CHANCE.attributeEntry);
        if (critAttr != null) {
            critAttr.removeModifier(key); // remove old modifier by ResourceLocation
            critAttr.addTransientModifier(new AttributeModifier(
                    key,
                    crit_chance,
                    AttributeModifier.Operation.ADD_MULTIPLIED_BASE
            ));
        }


        //System.out.println("[DEBUG] JeweledGauntlet: SpellPower=" + spellpower + " CritFraction=" + crit_chance);
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference reference) {
        var entity = reference.entity();
        ResourceLocation key = ResourceLocation.fromNamespaceAndPath("stefanscontent", "jg_crit_chance");

        var critAttr = entity.getAttribute(SpellPowerMechanics.CRITICAL_CHANCE.attributeEntry);
        if (critAttr != null) {
            critAttr.removeModifier(key); // clean up when unequipped
        }
    }

    @Override
    public void getExtraTooltip(ItemStack stack, List<Component> tooltips, Item.TooltipContext tooltipContext, TooltipFlag tooltipType){
        var entity = Minecraft.getInstance().player;

        double spellpower = entity.getAttributeValue(SpellSchools.FIRE.getAttributeEntry()) + entity.getAttributeValue(SpellSchools.FROST.getAttributeEntry()) +
                entity.getAttributeValue(SpellSchools.ARCANE.getAttributeEntry()) + entity.getAttributeValue(SpellSchools.LIGHTNING.getAttributeEntry()) +
                entity.getAttributeValue(SpellSchools.HEALING.getAttributeEntry()) + entity.getAttributeValue(SpellSchools.SOUL.getAttributeEntry());
        double critChance = spellpower / 70.0;

        tooltips.add(Component.translatable(
                "tooltip.stefanscontent.jeweled_gauntlet.crit",
                String.format("%.1f", critChance * 100)
        ).withStyle(ChatFormatting.BLUE));
    }
}

