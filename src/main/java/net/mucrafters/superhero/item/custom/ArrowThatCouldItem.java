package net.mucrafters.superhero.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mucrafters.superhero.SuperheroMod;
import net.mucrafters.superhero.world.entity.ModEntities;
import net.mucrafters.superhero.world.entity.customProjectiles.ArrowThatCould;

// 2 Problems:
// 1. Bows don't recongnize the item being an arrow
// 2. The arrow has no texture
public class ArrowThatCouldItem extends ArrowItem {
    public ArrowThatCouldItem(Properties properties) {
        super(properties);
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new ArrowThatCould(ModEntities.ARROW_THAT_COULD.get(), pShooter, pLevel);
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == ArrowThatCouldItem.class;
    }

}
