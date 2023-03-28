package net.mucrafters.superhero.world.damagesource;

import net.minecraft.world.damagesource.DamageSource;

public class SPDamageSource extends DamageSource {
    public static final DamageSource THANOS_SNAP = new DamageSource("thanos_snap").bypassArmor().bypassMagic().bypassEnchantments();

    public SPDamageSource(String p_19333_) {
        super(p_19333_);
    }
}
