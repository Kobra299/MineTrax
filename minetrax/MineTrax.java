/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import java.io.File;
import java.io.IOException;
import net.minecraftforge.common.Configuration;

@Mod(modid = "mMineTrax", name = "MineTrax", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MineTrax {

    @SidedProxy(clientSide = "minetrax.ClientProxyMineTrax", serverSide = "minetrax.CommonProxyMineTrax") //Those proxies... *rages*
    public static CommonProxyMineTrax proxyCommon;
    public static MineTraxAlbumMaker mineTraxAlbumMaker = new MineTraxAlbumMaker();
    public Configuration configFile;

    @PreInit
    public void preInit(FMLPreInitializationEvent event) throws IOException
    {
        ClientProxyMineTrax.registerSoundEvents();
        parseConfig(event);
    }

    @Init
    public void init(FMLInitializationEvent event) throws IOException
    {
        CommonProxyMineTrax.registerRenderThings();
        mineTraxAlbumMaker.doStuffs(configFile); //TODO: Rename to init as well?
        MineTraxItems.init();
        MineTraxBlocks.init();
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) throws IOException
    {
        //TODO: Things
    }

    public void parseConfig(FMLInitializationEvent event)
    {
        configFile = new Configuration(event.getSugestedConfig());
        configFile.load();
        //IDs Stuffs
        DataProxyMineTrax.discStartID = Integer.parseInt(configFile.get("Item", "Disc Start ID", 15001).value);
        DataProxyMineTrax.blankDiscID = Integer.parseInt(configFile.get("Item", "Blank Disc ID", 15000).value);
        //AlbumStuffs
        DataProxyMineTrax.currentAlbum = configFile.get("General", "CurrentAlbum", "albumex").value;
        configFile.save();
    }
}
