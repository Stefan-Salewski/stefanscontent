package com.stefansstuff.stefanscontent.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.spell_power.api.SpellPowerMechanics;
import net.spell_power.api.SpellSchools;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import javax.annotation.Nullable;
import java.util.List;

// If you're using Curios/Accessories, import their API interfaces


public class JeweledGauntlet extends Item implements ICurioItem {

    public JeweledGauntlet() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(
            SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        ImmutableMultimap.Builder<Holder<Attribute>, AttributeModifier> builder = ImmutableMultimap.builder();

        builder.put(SpellSchools.GENERIC.getAttributeEntry(),
                new AttributeModifier(
                        id, // use the slotContext-provided id
                        1,
                        AttributeModifier.Operation.ADD_VALUE));

        return builder.build();
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        var entity = slotContext.entity();
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
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        var entity = slotContext.entity();
        ResourceLocation key = ResourceLocation.fromNamespaceAndPath("stefanscontent", "jg_crit_chance");

        var critAttr = entity.getAttribute(SpellPowerMechanics.CRITICAL_CHANCE.attributeEntry);
        if (critAttr != null) {
            critAttr.removeModifier(key); // clean up when unequipped
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, java.util.List<net.minecraft.network.chat.Component> tooltip, net.minecraft.world.item.TooltipFlag flag) {
        //super.appendHoverText(stack, level, tooltip, flag);
        var player = Minecraft.getInstance().player;
        double spellpower = player.getAttributeValue(SpellSchools.FIRE.getAttributeEntry()) + player.getAttributeValue(SpellSchools.FROST.getAttributeEntry()) +
                player.getAttributeValue(SpellSchools.ARCANE.getAttributeEntry()) + player.getAttributeValue(SpellSchools.LIGHTNING.getAttributeEntry()) +
                player.getAttributeValue(SpellSchools.HEALING.getAttributeEntry()) + player.getAttributeValue(SpellSchools.SOUL.getAttributeEntry());
        double crit_chance = spellpower/70;
        tooltip.add(Component.translatable("tooltip.stefanscontent.jeweled_gauntlet.crit", String.format("%.1f", crit_chance * 100)).withStyle(ChatFormatting.BLUE));
    }
}

