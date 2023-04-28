package net.mucrafters.superhero.client;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.mucrafters.superhero.SuperheroMod;
import net.mucrafters.superhero.client.renderer.entity.ArrowThatCouldRenderer;
import net.mucrafters.superhero.util.ModItemProperties;
import net.mucrafters.superhero.world.entity.ModEntities;
import net.mucrafters.superhero.world.entity.customProjectiles.ArrowThatCould;

@Mod.EventBusSubscriber(modid = SuperheroMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void doSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntities.ARROW_THAT_COULD.get(), ArrowThatCouldRenderer::new);
    }
}
