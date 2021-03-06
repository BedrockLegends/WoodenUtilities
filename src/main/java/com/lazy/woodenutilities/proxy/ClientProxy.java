package com.lazy.woodenutilities.proxy;

import com.lazy.woodenutilities.client.screen.*;
import com.lazy.woodenutilities.content.ModBlocks;
import com.lazy.woodenutilities.content.ModContainers;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void addListener(IEventBus bus) {
        super.addListener(bus);
        bus.addListener(this::setupClient);
    }


    public void setupClient(FMLClientSetupEvent e) {
        this.screenRegistry();
        this.setBlockTransparency();
    }

    private void screenRegistry(){
        ScreenManager.registerFactory(ModContainers.WOODEN_HOPPER_CONTAINER, WoodenHopperScreen::new);
        ScreenManager.registerFactory(ModContainers.WOOD_CUTTER_CONTAINER, WoodCutterScreen::new);
        ScreenManager.registerFactory(ModContainers.WOODEN_FURNACE_CONTAINER, WoodenFurnaceScreen::new);
        ScreenManager.registerFactory(ModContainers.WOODEN_SOLAR_PANEL_CONTAINER, WoodenSolarPanelScreen::new);
        ScreenManager.registerFactory(ModContainers.WOODEN_BACKPACK_CONTAINER, WoodenBackpackScreen::new);
    }

    private void setBlockTransparency(){
        RenderTypeLookup.setRenderLayer(ModBlocks.WOOD_CUTTER.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WOODEN_LAMP.get(), RenderType.getTranslucent());
    }
}
