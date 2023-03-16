package net.mucrafters.superhero.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTab {
    public static final CreativeModeTab SUPERHERO_TAB = new CreativeModeTab("superherotab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.PLATINUM.get() );
        }
    };
}
