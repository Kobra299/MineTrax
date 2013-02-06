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
    public Configuration albumConfigFile;

    @PreInit
    public void preInit(FMLPreInitializationEvent event) throws IOException {

        configFile = new Configuration(new File("config/MineTrax.cfg"));
        configFile.load();
        loadConfig(configFile);

        albumConfigFile = new Configuration(new File("config/MineTrax_album.cfg"));
        albumConfigFile.load();
        loadConfig(albumConfigFile);
    }

    @Init
    public void load(FMLInitializationEvent event) throws IOException {
        proxyCommon.registerEverything();
        mineTraxAlbumMaker.doStuffs(albumConfigFile);
        MineTraxItems.init();
        MineTraxBlocks.init();
    }

    public void loadConfig(Configuration configFile) {
        //IDs Stuffs
        DataProxyMineTrax.discStartID = Integer.parseInt(configFile.get("General", "DiscStartID", 15000).value);
        //AlbumStuffs
        DataProxyMineTrax.currentAlbum = configFile.get("General", "CurrentAlbum", "albumex").value;
        configFile.save();
    }
}
