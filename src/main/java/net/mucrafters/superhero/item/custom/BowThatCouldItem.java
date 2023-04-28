package net.mucrafters.superhero.item.custom;


import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mucrafters.superhero.SuperheroMod;

import javax.swing.*;

// Problems
// No arrow sprite on pull back / wrong sprite?
// No way to change arrow speed and damage as that's linked to the arrow?

public class BowThatCouldItem extends BowItem {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SuperheroMod.MOD_ID);

    public BowThatCouldItem(Properties p_40660_) {
        super(p_40660_);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
