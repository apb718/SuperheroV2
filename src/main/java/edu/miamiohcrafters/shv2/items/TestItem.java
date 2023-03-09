package edu.miamiohcrafters.shv2.items;

import edu.miamiohcrafters.shv2.Superhero;
import net.minecraft.item.Item;

public class TestItem extends Item {

    public TestItem() {
        setRegistryName("testitem");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(Superhero.MODID + ".testitem");     // Used for localization (en_US.lang)
    }
}
