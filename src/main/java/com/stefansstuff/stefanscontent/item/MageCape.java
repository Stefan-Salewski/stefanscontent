package com.stefansstuff.stefanscontent.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.spell_power.api.SpellSchool;
import net.spell_power.api.SpellSchools;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

// If you're using Curios/Accessories, import their API interfaces


public class MageCape extends Item implements ICurioItem {

    public MageCape() {
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
}

