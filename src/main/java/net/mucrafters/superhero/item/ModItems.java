package net.mucrafters.superhero.item;


import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mucrafters.superhero.SuperheroMod;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SuperheroMod.MOD_ID);

    public static final RegistryObject<Item> PLATINUM = ITEMS.register("platinum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUPERHERO_TAB))) ;
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
