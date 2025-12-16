package com.stefansstuff.stefanscontent.item;

import com.stefansstuff.stefanscontent.StefansContent;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StefansContent.MODID);

    public static final DeferredItem<Item> SPARRINGGLOVES = ITEMS.register("sparringgloves", () -> new SparringGloves());
    public static final DeferredItem<Item> CLOAKOFAGILITY = ITEMS.register("cloakofagility", () -> new CloakOfAgility());
    public static final DeferredItem<Item> SHARKTOOTHNECKLACE = ITEMS.register("sharktoothnecklace", () -> new SharkToothNecklace());
    public static final DeferredItem<Item> MAGECAPE = ITEMS.register("magecape", () -> new MageCape());
    public static final DeferredItem<Item> ARCANECAPE = ITEMS.register("arcanecape", () -> new ArcaneCape());
    public static final DeferredItem<Item> FIRECAPE = ITEMS.register("firecape", () -> new FireCape());
    public static final DeferredItem<Item> FROSTCAPE = ITEMS.register("frostcape", () -> new FrostCape());
    public static final DeferredItem<Item> HEALINGCAPE = ITEMS.register("healingcape", () -> new HealingCape());
    public static final DeferredItem<Item> LIGHTNINGCAPE = ITEMS.register("lightningcape", () -> new LightningCape());
    public static final DeferredItem<Item> SOULCAPE = ITEMS.register("soulcape", () -> new SoulCape());





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
