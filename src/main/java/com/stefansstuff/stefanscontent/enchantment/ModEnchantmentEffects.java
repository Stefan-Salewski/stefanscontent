package com.stefansstuff.stefanscontent.enchantment;

import com.mojang.serialization.MapCodec;
import com.stefansstuff.stefanscontent.StefansContent;
import com.stefansstuff.stefanscontent.enchantment.KeenEyeHandler;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENCHANTMENTS = DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, StefansContent.MODID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> KEEN_EYE = ENCHANTMENTS.register("keen_eye", () -> KeenEyeHandler.CODEC);

    public static void register(IEventBus bus) {
        ENCHANTMENTS.register(bus);
    }
}
