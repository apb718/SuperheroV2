package net.mucrafters.superhero.client.renderer.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.mucrafters.superhero.SuperheroMod;
import net.mucrafters.superhero.world.entity.customProjectiles.ArrowThatCould;

public class ArrowThatCouldRenderer extends ArrowRenderer<ArrowThatCould> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(SuperheroMod.MOD_ID, "textures/entity/arrow_that_could.png");

    public ArrowThatCouldRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(ArrowThatCould entity) {
        return TEXTURE;
    }
}
