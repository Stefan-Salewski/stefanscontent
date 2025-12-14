package com.stefansstuff.stefanscontent.item;

import com.stefansstuff.stefanscontent.StefansContent;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StefansContent.MODID);

    public static final DeferredItem<Item> SPARRINGGLOVES = ITEMS.register("sparringgloves", () -> new SparringGloves());
    public static final DeferredItem<Item> CLOAKOFAGILITY = ITEMS.register("cloakofagility", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
