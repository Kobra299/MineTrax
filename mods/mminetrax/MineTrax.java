 package mods.mminetrax;
 
 import cpw.mods.fml.common.Mod;
 import cpw.mods.fml.common.Mod.Init;
 import cpw.mods.fml.common.Mod.PostInit;
 import cpw.mods.fml.common.Mod.PreInit;
 import cpw.mods.fml.common.SidedProxy;
 import cpw.mods.fml.common.event.FMLInitializationEvent;
 import cpw.mods.fml.common.event.FMLPostInitializationEvent;
 import cpw.mods.fml.common.event.FMLPreInitializationEvent;
 import cpw.mods.fml.common.network.NetworkMod;
 import cpw.mods.fml.common.registry.GameRegistry;
 import cpw.mods.fml.common.registry.LanguageRegistry;
 import java.io.IOException;
 import net.minecraft.item.Item;
 import net.minecraftforge.common.Configuration;
 import net.minecraftforge.common.Property;
 
 @Mod(modid="mMineTrax", name="MineTrax", version="1.1.4")
 @NetworkMod(clientSideRequired=true, serverSideRequired=false)
 public class MineTrax
 {
   int[] arrayDisc;
   public int numberOfDiscs;
   public static Item newDisc;
   public String songAuthor;
   public String songTitle;
   public String songFilename;
 
   @SidedProxy(clientSide="mods.mminetrax.ClientProxyMineTrax", serverSide="mods.mminetrax.CommonProxyMineTrax")
   public static CommonProxyMineTrax proxyCommon = new CommonProxyMineTrax();
   public Configuration configFile;
 
   @Mod.PreInit
   public void preInit(FMLPreInitializationEvent event)
     throws IOException
   {
     Configuration config = new Configuration(event.getSuggestedConfigurationFile());
     config.load();
     DataProxyMineTrax.discStartID = config.get("General", "DiscStartID", 15000).getInt(15000);
     this.numberOfDiscs = config.get("General", "NumberOfDiscs", 10).getInt();
 
     this.arrayDisc = new int[this.numberOfDiscs];
     for (int curDisc = 0; curDisc < this.arrayDisc.length; curDisc++) {
       this.arrayDisc[curDisc] = curDisc;
       int discID = this.arrayDisc[curDisc] + DataProxyMineTrax.discStartID;
       String curDiscStr = Integer.toString(curDisc);
       this.songAuthor = config.get(curDiscStr, "SongAuthor", "None").getString();
       this.songTitle = config.get(curDiscStr, "SongTitle", "None").getString();
       this.songFilename = config.get(curDiscStr, "SongFilename", "None").getString();
 
       newDisc = new ItemMineTraxRecord(discID, this.songFilename, this.songAuthor, this.songTitle).setUnlocalizedName("MusicDisc" + curDisc).setMaxStackSize(1).setFull3D().setTextureName("disc");
 
       GameRegistry.registerItem(newDisc, "MusicDisc" + curDiscStr);
       LanguageRegistry.addName(newDisc, "Music Disc");
     }
 
     config.save();
   }
 
   @Mod.PostInit
   public void postInit(FMLPostInitializationEvent event)
     throws IOException
   {
   }
 
   public void parseMainConfig()
   {
   }
 }