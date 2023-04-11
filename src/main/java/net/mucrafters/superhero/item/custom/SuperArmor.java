package net.mucrafters.superhero.item.custom;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.entity.*;



import net.minecraftforge.eventbus.api.IGenericEvent;
import net.mucrafters.superhero.base.ModArmorMat;
import net.mucrafters.superhero.item.ModItems;
import net.mucrafters.superhero.world.damagesource.SPDamageSource;
import org.lwjgl.system.linux.XGenericEvent;

public class SuperArmor extends ArmorItem {
    public SuperArmor(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
        super(p_40386_, p_40387_, p_40388_);
    }

    //Creating materials and enchanments for armor
    public static class ArmorTiers {
        public static final ArmorMaterial Shat = new ModArmorMat(
                "super", 500, new int[] {20, 20, 50, 10}, 300, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f, () -> Ingredient.EMPTY
        );
        public static final ArmorMaterial Schest = new ModArmorMat(
                "super", 500, new int[] {20, 20, 50, 10}, 300, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f, () -> Ingredient.EMPTY
        );
        public static final ArmorMaterial Spants = new ModArmorMat(
                "super", 500, new int[] {20, 20, 50, 10}, 300, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f, () -> Ingredient.EMPTY
        );
        public static final ArmorMaterial Sboots = new ModArmorMat(
                "super", 500, new int[] {20, 20, 50, 10}, 300, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f, () -> Ingredient.EMPTY

        );

    }
//    public float speed() {
//
//
//        return player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(100);
//    }
}
