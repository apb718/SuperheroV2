package net.mucrafters.superhero.item;


import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mucrafters.superhero.SuperheroMod;
import net.mucrafters.superhero.item.custom.ThanosGauntletItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SuperheroMod.MOD_ID);

    public static final RegistryObject<Item> PLATINUM = ITEMS.register("platinum",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUPERHERO_TAB))) ;


    // Adds the thanos gauntlet to the game
    // Added by Michael
    public static final RegistryObject<Item> THANOS_GAUNTLET = ITEMS.register("thanos_gauntlet",
            () -> new ThanosGauntletItem(new Item.Properties().tab(ModCreativeModeTab.SUPERHERO_TAB).stacksTo(1)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}