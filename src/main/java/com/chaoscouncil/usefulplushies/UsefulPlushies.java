package com.chaoscouncil.usefulplushies;

import net.minecraft.world.level.block.SoundType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
//import com.chaoscouncil.usefulplushies.PlushBlock;

import static com.chaoscouncil.usefulplushies.PlushItem.ITEMS;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(UsefulPlushies.MODID)
public class UsefulPlushies {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "usefulplushies";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public UsefulPlushies(IEventBus modEventBus, ModContainer modContainer) {

        ITEMS.register(modEventBus);
    // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        //BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered

        // Register the Deferred Register to the mod event bus so tabs get registered
        //CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (UsefulPlushies) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        //modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("I swear these beanie babies are a good investment!");
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    //    if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
    //        event.accept(EXAMPLE_BLOCK_ITEM);
    //    }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
