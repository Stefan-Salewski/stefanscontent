package com.stefansstuff.stefanscontent.item;

import com.stefansstuff.stefanscontent.StefansContent;
import com.stefansstuff.stefanscontent.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StefansContent.MODID);

    public static final Supplier<CreativeModeTab> STEFANS_CONTENT_TAB = CREATIVE_MODE_TAB.register("stefans_content",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SPARRINGGLOVES.get()))
                    .title(Component.translatable("creativetab.stefanscontent.stefans_content"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SPARRINGGLOVES);
                        output.accept(ModItems.CLOAKOFAGILITY);
                        output.accept(ModItems.SHARKTOOTHNECKLACE);
                        output.accept(ModItems.MAGECAPE);
                        output.accept(ModItems.FIRECAPE);
                        //output.accept(ModItems.LIGHTNINGCAPE);
                        output.accept(ModItems.FROSTCAPE);
                        //output.accept(ModItems.SOULCAPE);
                        output.accept(ModItems.ARCANECAPE);
                        output.accept(ModItems.HEALINGCAPE);
                    }))
                    .build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TAB.register(bus);
    }
}
