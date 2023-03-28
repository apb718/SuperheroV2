package net.mucrafters.superhero.world.entity.customProjectiles;

import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.mucrafters.superhero.item.ModItems;

public class ArrowThatCould extends AbstractArrow {
    public ArrowThatCould(EntityType<ArrowThatCould> entityType, Level world) {
        super(entityType, world);
    }

    public ArrowThatCould(EntityType<ArrowThatCould> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);
    }

    public ArrowThatCould(EntityType<ArrowThatCould> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(ModItems.ARROW_THAT_COULD.get());
    }


    @Override
    protected void onHitEntity(EntityHitResult p_36757_) {
        super.onHitEntity(p_36757_);

        Entity entity1 = this.getOwner();

        LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(this.level);
        lightningbolt.moveTo(Vec3.atBottomCenterOf(p_36757_.getEntity().blockPosition()));
        lightningbolt.setCause(entity1 instanceof ServerPlayer ? (ServerPlayer)entity1 : null);
        this.level.addFreshEntity(lightningbolt);


    }

    @Override
    protected void onHitBlock(BlockHitResult p_36755_) {
        super.onHitBlock(p_36755_);
        this.level.gameEvent(GameEvent.LIGHTNING_STRIKE, p_36755_.getBlockPos(), GameEvent.Context.of(this, this.level.getBlockState(p_36755_.getBlockPos())));

        Entity entity1 = this.getOwner();

        LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(this.level);
        lightningbolt.moveTo(Vec3.atBottomCenterOf(p_36755_.getBlockPos()));
        lightningbolt.setCause(entity1 instanceof ServerPlayer ? (ServerPlayer)entity1 : null);
        this.level.addFreshEntity(lightningbolt);
    }

    @Override
    protected void tickDespawn() {
        if (this.inGroundTime > 60){
            this.discard();
        }
    }

    // in ExplosiveArrowEntity.java
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
