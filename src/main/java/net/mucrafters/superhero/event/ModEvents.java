package net.mucrafters.superhero.event;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.mucrafters.superhero.SuperheroMod;
import net.mucrafters.superhero.item.ModItems;
import net.mucrafters.superhero.item.custom.BowThatCouldItem;

@Mod.EventBusSubscriber(modid = SuperheroMod.MOD_ID)
public class ModEvents {

    private static MobEffectInstance helmetEffect = new MobEffectInstance(MobEffects.NIGHT_VISION, Integer.MAX_VALUE);
    private static MobEffectInstance chestplateEffect = new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE);
    private static MobEffectInstance leggingsEffect = new MobEffectInstance(MobEffects.JUMP, Integer.MAX_VALUE);
    private static MobEffectInstance bootsEffect = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, Integer.MAX_VALUE);


    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        unobtainiumHelmetTick(event.player);
        unobtainiumChestplateTick(event.player);
        unobtainiumLeggingsTick(event.player);
        unobtainiumBootsTick(event.player);
    }

    private static void unobtainiumHelmetTick(Player player) {
        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.UNOBTAINIUM_HELMET.get()) {
            player.addEffect(helmetEffect);
        } else if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() != ModItems.UNOBTAINIUM_HELMET.get()) {
            player.removeEffect(helmetEffect.getEffect());
        }
    }

    private static void unobtainiumChestplateTick(Player player) {
        if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.UNOBTAINIUM_CHEST.get()) {
            player.addEffect(chestplateEffect);
        } else if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() != ModItems.UNOBTAINIUM_CHEST.get()) {
            player.removeEffect(chestplateEffect.getEffect());
        }
    }

    private static void unobtainiumLeggingsTick(Player player) {
        if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.UNOBTAINIUM_PANTS.get()) {
            player.addEffect(leggingsEffect);
        } else if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() != ModItems.UNOBTAINIUM_PANTS.get()) {
            player.removeEffect(leggingsEffect.getEffect());
        }
    }

    private static void unobtainiumBootsTick(Player player) {
        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.UNOBTAINIUM_BOOTS.get()) {
            player.addEffect(bootsEffect);
        } else if (player.getItemBySlot(EquipmentSlot.FEET).getItem() != ModItems.UNOBTAINIUM_BOOTS.get()) {
            player.removeEffect(bootsEffect.getEffect());
        }
    }

}
