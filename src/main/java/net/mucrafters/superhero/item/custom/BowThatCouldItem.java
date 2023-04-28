package net.mucrafters.superhero.item.custom;


import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import
        net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mucrafters.superhero.SuperheroMod;
import net.mucrafters.superhero.item.ModCreativeModeTab;
import net.mucrafters.superhero.item.ModItems;

import javax.swing.*;

import static net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED;

// Problems
// No arrow sprite on pull back / wrong sprite?
// No way to change arrow speed and damage as that's linked to the arrow?

public class BowThatCouldItem extends BowItem {

    public static final int DEFAULT_RANGE = Integer.MAX_VALUE;

    private static float bonusDamage = 2.0f;
    private static float speed = 0.5f;

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SuperheroMod.MOD_ID);

    public BowThatCouldItem(Properties properties) {
        super(properties);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }



    public void releaseUsing(ItemStack p_40667_, Level p_40668_, LivingEntity p_40669_, int p_40670_) {
        if (p_40669_ instanceof Player player) {
            boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, p_40667_) > 0;
            ItemStack itemstack = player.getProjectile(p_40667_);

            int i = this.getUseDuration(p_40667_) - p_40670_;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(p_40667_, p_40668_, player, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getPowerForTime(i);
                if (!((double)f < 0.1D)) {
                    boolean flag1 = player.getAbilities().instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, p_40667_, player));
                    if (!p_40668_.isClientSide) {
                        ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                        AbstractArrow abstractarrow = arrowitem.createArrow(p_40668_, itemstack, player);
                        abstractarrow = customArrow(abstractarrow);
                        abstractarrow.setNoGravity(true);
                        //abstractarrow.setNoPhysics(true);
                        //abstractarrow.move
                        //abstractarrow.setDeltaMovement(100,0,0);
                        //abstractarrow.fallDistance;
                        //abstractarrow.setTicksFrozen(5000);
                        abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, f * speed, 1.0F); // Controls Speed
                        // Problem: The friction of the arrow brings the arrow down to a halt
                        if (f == 1.0F) {
                            abstractarrow.setCritArrow(true);
                        }

                        //abstractarrow.lerpMotion(0.5,0,0); // Z == right
                        abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + (double)bonusDamage * 1.5D + 1.5D); // Sets increased damage, 2 ==


                        int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, p_40667_);
                        if (k > 0) {
                            abstractarrow.setKnockback(k);
                        }

                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, p_40667_) > 0) {
                            abstractarrow.setSecondsOnFire(100);
                        }

                        p_40667_.hurtAndBreak(1, player, (p_40665_) -> {
                            p_40665_.broadcastBreakEvent(player.getUsedItemHand());
                        });
                        if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW))) {
                            abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        p_40668_.addFreshEntity(abstractarrow);
                    }

                    p_40668_.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (p_40668_.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            player.getInventory().removeItem(itemstack);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public static float getPowerForTime(int p_40662_) {
        float f = (float)p_40662_ / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public int getDefaultProjectileRange() {
        return Integer.MAX_VALUE;
    }

//    if(enchants.containsKey(TCombatEnchants.SNIPE.get())){
//        double damage = abstractArrowEntity.getBaseDamage();
//        Vector3d vector3d1 = shooter.getUpVector(1.0F);
//        Quaternion quaternion = new Quaternion(new Vector3f(vector3d1), 0, true);
//        Vector3d vector3d = shooter.getViewVector(1.0F);
//        Vector3f vector3f = new Vector3f(vector3d);
//        vector3f.transform(quaternion);
//        Vector3d originalVector = abstractArrowEntity.getDeltaMovement();
//        double length = originalVector.length() * 10;
//        abstractArrowEntity.setDeltaMovement(vector3f.x()*length, vector3f.y()*length, vector3f.z()*length);
//        abstractArrowEntity.hurtMarked = true;
//        abstractArrowEntity.setBaseDamage(damage);
//    }
}
