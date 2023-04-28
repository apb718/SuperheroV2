package net.mucrafters.superhero;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mucrafters.superhero.item.ModItems;
import net.mucrafters.superhero.block.ModBlocks;
import net.mucrafters.superhero.util.ModItemProperties;
import net.mucrafters.superhero.world.feature.ModConfiguredFeatures;
import net.mucrafters.superhero.world.feature.ModPlacedFeatures;
import net.mucrafters.superhero.world.entity.ModEntities;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(SuperheroMod.MOD_ID)
public class SuperheroMod {
    public static final String MOD_ID = "superheromod";
    private static final Logger LOGGER = LogUtils.getLogger();


    public SuperheroMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntities.ENTITY_TYPES.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }




    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ModItemProperties.addCustomItemProperties();
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {

    }


}
