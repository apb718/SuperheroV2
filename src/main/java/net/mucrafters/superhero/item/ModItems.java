package net.mucrafters.superhero.item;


import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mucrafters.superhero.SuperheroMod;

import net.mucrafters.superhero.base.ModArmorMat;
import net.mucrafters.superhero.item.custom.ArrowThatCouldItem;
import net.mucrafters.superhero.item.custom.ThanosGauntletItem;




public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SuperheroMod.MOD_ID);


    // Adds the thanos gauntlet to the game
    // Added by Michael
    public static final RegistryObject<Item> THANOS_GAUNTLET = ITEMS.register("thanos_gauntlet",
            () -> new ThanosGauntletItem(new Item.Properties().tab(ModCreativeModeTab.SUPERHERO_TAB).stacksTo(1)));

    // Adds Arrow that could to the game
    // Added by Michael
    public static final RegistryObject<Item> ARROW_THAT_COULD = ITEMS.register("arrow_that_could",
            () -> new ArrowThatCouldItem(new Item.Properties().tab(ModCreativeModeTab.SUPERHERO_TAB)));
    static final RegistryObject<Item> UNOBTAINIUM_INGOT = ITEMS.register("unobtainium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUPERHERO_TAB)));
    static final RegistryObject<Item> UNOBTAINIUM_NUGGET = ITEMS.register("unobtainium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SUPERHERO_TAB)));






    //method to just make it easier when calling properties
    private static Item.Properties props() {
        return new Item.Properties().tab(ModCreativeModeTab.SUPERHERO_TAB);
    }
    //All clothes registered

    //registering armor
    public static final RegistryObject<ArmorItem> UNOBTAINIUM_HELMET = ITEMS.register("unobtainium_helmet",
            () -> new ArmorItem(ArmorTiers.UNOBTAINIUM,EquipmentSlot.HEAD, props()));
    public static final RegistryObject<ArmorItem> UNOBTAINIUM_CHEST = ITEMS.register("unobtainium_chest",
            () -> new ArmorItem(ArmorTiers.UNOBTAINIUM,EquipmentSlot.CHEST, props()));
    public static final RegistryObject<ArmorItem> UNOBTAINIUM_PANTS = ITEMS.register("unobtainium_pants",
            () -> new ArmorItem(ArmorTiers.UNOBTAINIUM,EquipmentSlot.LEGS, props()));
    public static final RegistryObject<ArmorItem> UNOBTAINIUM_BOOTS = ITEMS.register("unobtainium_boots",
            () -> new ArmorItem(ArmorTiers.UNOBTAINIUM,EquipmentSlot.FEET, props()));


    public static final RegistryObject<BowItem> UNOBTAINIUM_BOWW = ITEMS.register("unobtainium_boww",
            () -> new BowItem(props().durability(500)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    //Creating materials and enchantments for armor
    public static class ArmorTiers {
        public static final ArmorMaterial UNOBTAINIUM = new ModArmorMat(
                "unobtainium", 100, new int[] {20, 20, 50, 10}, 300, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f, () -> Ingredient.EMPTY
        );
    }

}
