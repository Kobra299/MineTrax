/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import java.io.File;
import java.io.IOException;
import net.minecraftforge.common.Configuration;

@Mod(modid = "mMineTrax", name = "MineTrax", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MineTrax {

    @SidedProxy(clientSide = "minetrax.ClientProxyMineTrax", serverSide = "minetrax.CommonProxyMineTrax") //Those proxies... *rages*
    public static CommonProxyMineTrax proxyCommon = new CommonProxyMineTrax();
    public static MineTraxAlbumMaker mineTraxAlbumMaker = new MineTraxAlbumMaker();
    public Configuration configFile;

    @PreInit
    public void preInit(FMLPreInitializationEvent event) throws IOException {
        parseMainConfig();
        proxyCommon.registerEverything();


    }

    @Init
    public void init(FMLInitializationEvent event) throws IOException {

        mineTraxAlbumMaker.doStuffs(); //TOPOSSIBLYDO: Should we move this into preInit?
        MineTraxItems.init();
        MineTraxBlocks.init();
    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event) throws IOException {
        //TODO: Things
    }

//Don't touch this now please. - I REPEAT, NO TOUCHIE, EXCEPT FOR ADDING NEW ITEMS/BLOCKS!!!
    public void parseMainConfig() {
        configFile = new Configuration(new File("config/MineTrax.cfg"));
        configFile.load();

        //IDs Stuffs
        DataProxyMineTrax.discStartID = Integer.parseInt(configFile.get("General", "DiscStartID", 15000).value);
        DataProxyMineTrax.advancedJukeboxID = Integer.parseInt(configFile.get("Blocks", "AdvancedJukeboxID", 2500).value);


        configFile.save();
    }
    //End of no touchie
}
