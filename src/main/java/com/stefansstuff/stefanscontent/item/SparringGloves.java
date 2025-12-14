package com.stefansstuff.stefanscontent.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

// If you're using Curios/Accessories, import their API interfaces
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class SparringGloves extends Item implements ICurioItem {

    public SparringGloves() {
        super(new Item.Properties().stacksTo(1).durability(0));
    }
}
