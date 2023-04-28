package net.mucrafters.superhero.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.ClientSideMerchant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.mucrafters.superhero.item.ModCreativeModeTab;
import net.mucrafters.superhero.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.mucrafters.superhero.item.custom.BowThatCouldItem;


public class ModItemProperties {


    public static void addCustomItemProperties() {

        makeBow(ModItems.UNOBTAINIUM_BOW.get());

    }

    private static void makeBow(Item item) {

        ItemProperties.register(item, new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
            if (p_174637_ == null) {
                return 0.0F;
            } else {
                return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(item, new ResourceLocation("pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
            return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F;
        });


      increaseDamage(item, 20);

    }

    public static void increaseDamage(Item item, int damage) {
        ItemStack l = new ItemStack(item);
        //item = new BowThatCouldItem(new Item.Properties().tab(ModCreativeModeTab.SUPERHERO_TAB));
        l.setDamageValue(damage);


    }

    public static void slowSpeed(BowItem item, float speed) {
        //ItemStack l = new ItemStack(item);
        //item.customArrow(AbstractArrow).setBaseDamage(20.0);


    }


    }

