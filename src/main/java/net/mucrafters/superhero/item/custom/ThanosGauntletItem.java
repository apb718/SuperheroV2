package net.mucrafters.superhero.item.custom;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.mucrafters.superhero.world.damagesource.SPDamageSource;

public class ThanosGauntletItem extends Item {
    public static final double SNAP_RANGE = 20.0D;
    public static final double SNAP_RANGE_SQ = 80.0D;
    private final float ATTACK_DAMAGE = Float.MAX_VALUE;
    public ThanosGauntletItem(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            //BlockPos blockPos = player.getOnPos();
            // Harm the player based on a "coin flip" chance
            harmPlayerSnap(player, isPlayerHarmed());

            // Kill all mobs surrounding the player in 20 block radius
            snap(player);

            // Set a Cool down
            player.getCooldowns().addCooldown(this, 120);

            // Play a snap sound effect?
        }

        return super.use(level, player, hand);
    }

    private int getRandomNumber() {
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
    private boolean isPlayerHarmed() {
        if(getRandomNumber() > 4) {
            return true;
        } else {
            return false;
        }
    }
    private void harmPlayerSnap(Player player, boolean isHarmed) {
        if (isHarmed) {
            float health = player.getHealth();
            if(health > 1.0) {
                float healthDmg = player.getHealth() - 1.0f;
                player.hurt(SPDamageSource.THANOS_SNAP, healthDmg); // Had to create a new damage source
            }
        }
    }

    private List<Mob> mobsInRange(Player player) {
        AABB aabb = player.getBoundingBox().inflate(SNAP_RANGE, SNAP_RANGE/2.0D, SNAP_RANGE);
        List<Mob> list = player.getLevel().getEntitiesOfClass(Mob.class, aabb);
        return list;
    }

    private void applyKillMobs(Player player, List<Mob> list) {
        if(!list.isEmpty()) {
            for(LivingEntity livingEntity : list) {
                double d0 = player.distanceToSqr(livingEntity);
                if(livingEntity != player) {
                    livingEntity.kill();
                }
            }
        }
    }

    private void snap(Player player) {
        List<Mob> mobs = mobsInRange(player);
        applyKillMobs(player, mobs);
    }
}
