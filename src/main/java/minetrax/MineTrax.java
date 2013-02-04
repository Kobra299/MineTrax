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

    @SidedProxy(clientSide = "minetrax.ClientProxyMineTrax", serverSide = "minetrax.CommonProxyMineTrax")
    public static ClientProxyMineTrax proxyClient = new ClientProxyMineTrax();
    public static CommonProxyMineTrax proxyCommon = new CommonProxyMineTrax();
    public static MineTraxAlbumMaker MineTraxAlbumMaker = new MineTraxAlbumMaker();

    @PreInit
    public void PreInit(FMLPreInitializationEvent event) throws IOException {
        ClientProxyMineTrax.registerSoundEvents();
        Config();
        MineTraxAlbumMaker.DoStuffs();
    }

    @Init
    public void load(FMLInitializationEvent event) {
        CommonProxyMineTrax.registerRenderThings();
    }

    @PostInit
    public void PostInitialization(FMLPostInitializationEvent event) {
    }

    public void Config() {
        Configuration config = new Configuration(new File("config/MineTrax.cfg"));

        config.load();
        //Items
        //TODO: Get rid of this... it was just for testing if the mod was working right when it was just started.
      
        DataProxyMineTrax.currentAlbum = config.get("General", "CurrentAlbum", "albumex").value;
        config.save();

    }
}
