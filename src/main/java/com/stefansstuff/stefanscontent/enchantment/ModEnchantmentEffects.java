package com.stefansstuff.stefanscontent.enchantment;

import com.stefansstuff.stefanscontent.enchantment.custom.KeenEyeHandler_UNUSED;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEnchantmentEffects {
    public static final DeferredRegister<DataComponentType<?>> ENCHANTMENT_COMPONENT_TYPES = DeferredRegister.create(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, "stefanscontent");

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<KeenEyeHandler_UNUSED>> KEEN_EYE =
            ENCHANTMENT_COMPONENT_TYPES.register("keen_eye",
                    () -> DataComponentType.<KeenEyeHandler_UNUSED>builder()
                            .persistent(KeenEyeHandler_UNUSED.CODEC.codec())
                            .build());

    public static void register(IEventBus bus) {
        ENCHANTMENT_COMPONENT_TYPES.register(bus);
    }
}
