package com.stefansstuff.stefanscontent;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StefansContent.MODID);

    //public static final Supplier<CreativeModeTab> STEFANS_CONTENT_TAB = CREATIVE_MODE_TAB.register("Stefans Content Tab", () -> CreativeModeTab.builder().icon() -> new ItemStack(Modite))

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TAB.register(bus);
    }
}
