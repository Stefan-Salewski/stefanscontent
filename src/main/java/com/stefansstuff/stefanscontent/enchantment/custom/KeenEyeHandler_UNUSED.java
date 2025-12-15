package com.stefansstuff.stefanscontent.enchantment.custom;

import com.mojang.serialization.MapCodec;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record KeenEyeHandler_UNUSED() implements EnchantmentEntityEffect {

    public static final MapCodec<KeenEyeHandler_UNUSED> CODEC = MapCodec.unit(KeenEyeHandler_UNUSED::new);

    @Override
    public void apply(ServerLevel level, int enchantLevel, EnchantedItemInUse enchantedItem, Entity entity, Vec3 pos) {
        if (!(entity instanceof LivingEntity living)) return;

        // Only apply if the enchanted item is actually in the main hand
        if (living.getMainHandItem().equals(enchantedItem.itemStack())) {
            double bonus = 0.05 * enchantLevel;

            AttributeModifier modifier = new AttributeModifier(
                    ResourceLocation.fromNamespaceAndPath("stefanscontent", "keen_eye_bonus"),
                    bonus,
                    AttributeModifier.Operation.ADD_VALUE
            );

            AttributeInstance critChance = living.getAttribute(ALObjects.Attributes.CRIT_CHANCE);
            if (critChance != null) {
                critChance.removeModifier(modifier.id());
                critChance.addTransientModifier(modifier);
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
