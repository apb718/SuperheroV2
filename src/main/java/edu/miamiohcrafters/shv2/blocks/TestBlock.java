package edu.miamiohcrafters.shv2.blocks;

import edu.miamiohcrafters.shv2.Superhero;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TestBlock extends Block {
    public TestBlock() {
        super(Material.ROCK);
        setUnlocalizedName(Superhero.MODID + ".testblock");     // Used for localization (en_US.lang)
        setRegistryName("testblock");        // The unique name (within your mod) that identifies this block
    }
}
