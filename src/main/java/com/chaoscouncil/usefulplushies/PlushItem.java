package com.chaoscouncil.usefulplushies;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class PlushItem {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, UsefulPlushies.MODID);

    public static final DeferredHolder<Item, Item> TEST = ITEMS.register("test", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }
}
