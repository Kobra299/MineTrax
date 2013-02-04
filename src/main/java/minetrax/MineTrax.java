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
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;

@Mod(modid = "mMineTrax", name = "MineTrax", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MineTrax {

    @SidedProxy(clientSide = "minetrax.ClientProxyMineTrax", serverSide = "minetrax.CommonProxyMineTrax")
    public static ClientProxyMineTrax proxyClient = new ClientProxyMineTrax();
    public static CommonProxyMineTrax proxyCommon = new CommonProxyMineTrax();
    public static MineTraxAlbumMaker MineTraxAlbumMaker = new MineTraxAlbumMaker();

    @PreInit
    public void PreInit(FMLPreInitializationEvent event) throws IOException {
        ClientProxyMineTrax.registerSoundEvents();
        MinecraftForgeClient.preloadTexture("/MineTrax/gfx/discs.png");
        Config();
        
    }

    @Init
    public void load(FMLInitializationEvent event) throws IOException {
        CommonProxyMineTrax.registerRenderThings();
        MineTraxAlbumMaker.DoStuffs();
    }

    @PostInit
    public void PostInitialization(FMLPostInitializationEvent event) {
    }

    public void Config() {
        Configuration config = new Configuration(new File("config/MineTrax.cfg"));

        config.load();
        //IDs Stuffs        
        DataProxyMineTrax.discStartID = Integer.parseInt(config.get("General", "DiscStartID", 14000).value);
        //AlbumStuffs  
        DataProxyMineTrax.currentAlbum = config.get("General", "CurrentAlbum", "albumex").value;
        config.save();

    }
}
