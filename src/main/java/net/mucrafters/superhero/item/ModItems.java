package net.mucrafters.superhero.item;


import com.sun.net.httpserver.Filter;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.VanillaIngredientSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mucrafters.superhero.SuperheroMod;
//import net.mucrafters.superhero.base.ModArmorMat;
import net.mucrafters.superhero.item.custom.ArrowThatCouldItem;
import net.mucrafters.superhero.item.custom.ThanosGauntletItem;
//import net.mucrafters.superhero.item.custom.SuperArmor;



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
            () -> new ArrowThatCouldItem(new Item.Properties().tab(ModCreativeModeTab.SUPERHERO_TAB)));
    static final RegistryObject<Item> UNOBTAINIUM_NUGGET = ITEMS.register("unobtainium_nugget",
            () -> new ArrowThatCouldItem(new Item.Properties().tab(ModCreativeModeTab.SUPERHERO_TAB)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }



    // creating armor

    //method to just make it easier when calling properties
    private static Item.Properties props() {
        return new Item.Properties().tab(ModCreativeModeTab.SUPERHERO_TAB);
    }
    //All clothes registered
//    public static final RegistryObject<ArmorItem> SUPER_HELMET = ITEMS.register("super_helmet",
//            () -> new ArmorItem(SuperArmor.ArmorTiers.Shat,EquipmentSlot.HEAD, props()));
//    public static final RegistryObject<ArmorItem> SUPER_CHEST = ITEMS.register("super_chest",
//            () -> new ArmorItem(SuperArmor.ArmorTiers.Schest,EquipmentSlot.CHEST, props()));
//    public static final RegistryObject<ArmorItem> SUPER_PANTS = ITEMS.register("super_pants",
//            () -> new ArmorItem(SuperArmor.ArmorTiers.Spants,EquipmentSlot.LEGS, props()));
//    public static final RegistryObject<ArmorItem> SUPER_BOOTS = ITEMS.register("super_boots",
//            () -> new ArmorItem(SuperArmor.ArmorTiers.Sboots,EquipmentSlot.FEET, props()));

//    //Creating materials and enchanments for armor
//    public static class ArmorTiers {
//        public static final ArmorMaterial Shat = new ModArmorMat(
//                "super", 500, new int[] {20, 20, 50, 10}, 300, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f, () -> Ingredient.EMPTY
//        );
//        public static final ArmorMaterial Schest = new ModArmorMat(
//                "super", 500, new int[] {20, 20, 50, 10}, 300, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f, () -> Ingredient.EMPTY
//        );
//        public static final ArmorMaterial Spants = new ModArmorMat(
//                "super", 500, new int[] {20, 20, 50, 10}, 300, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f, () -> Ingredient.EMPTY
//        );
//        public static final ArmorMaterial Sboots = new ModArmorMat(
//                "super", 500, new int[] {20, 20, 50, 10}, 300, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f, () -> Ingredient.EMPTY
//
//        );
//
//    }
}
