package net.mucrafters.superhero.world.entity;


import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mucrafters.superhero.SuperheroMod;
import net.mucrafters.superhero.world.entity.customProjectiles.ArrowThatCould;

// This will serve as a ModInit
public class ModEntities {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, SuperheroMod.MOD_ID); // Tutorials say ENTITIES, not ENTITY_TYPES

    public static final RegistryObject<EntityType<ArrowThatCould>> ARROW_THAT_COULD = ENTITY_TYPES.register("arrow_that_could",
            () -> EntityType.Builder.of((EntityType.EntityFactory<ArrowThatCould>) ArrowThatCould::new, MobCategory.MISC).sized(0.5F, 0.5F).build("arrow_that_could"));
}
