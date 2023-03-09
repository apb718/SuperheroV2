//https://www.mcjty.eu/docs/1.12/mod
//github.com/apb718/Superhero_Mod/
//IntelliJ IDEA
//Minecraft Extensions

package edu.miamiohcrafters.shv2;

import edu.miamiohcrafters.shv2.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Superhero.MODID, name = Superhero.NAME, version = Superhero.VERSION)
public class Superhero
{
    public static final String MODID = "shv2";
    public static final String NAME = "Superhero Mod";
    public static final String VERSION = "1.0";

    @Mod.Instance
    public static Superhero instance;

    @SidedProxy(clientSide = "edu.miamiohcrafters.shv2.proxy.ClientProxy", serverSide = "edu.miamiohcrafters.shv2.proxy.ServerProxy")
    public static CommonProxy proxy;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {

        logger = e.getModLog();
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

}
