package com.stefansstuff.stefanscontent.enchantment;

import com.mojang.serialization.MapCodec;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record KeenEyeHandler() implements EnchantmentEntityEffect {

    public static final MapCodec<KeenEyeHandler> CODEC = MapCodec.unit(KeenEyeHandler::new);

    @Override
    public void apply(ServerLevel level, int enchantLevel, EnchantedItemInUse enchantedItem, Entity entity, Vec3 pos) {
        if (entity instanceof LivingEntity living) {
            if (living.getMainHandItem() == enchantedItem.itemStack()) {
                double bonus = 0.05 * enchantLevel;
                living.getAttribute(ALObjects.Attributes.CRIT_CHANCE).addTransientModifier(
                        new AttributeModifier(
                                ResourceLocation.fromNamespaceAndPath("stefanscontent", "keen_eye_bonus"),
                                bonus,
                                AttributeModifier.Operation.ADD_VALUE));
            }
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
