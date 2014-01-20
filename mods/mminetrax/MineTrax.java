/*    */ package mods.mminetrax;
/*    */ 
/*    */ import cpw.mods.fml.common.Mod;
/*    */ import cpw.mods.fml.common.Mod.Init;
/*    */ import cpw.mods.fml.common.Mod.PostInit;
/*    */ import cpw.mods.fml.common.Mod.PreInit;
/*    */ import cpw.mods.fml.common.SidedProxy;
/*    */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*    */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*    */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*    */ import cpw.mods.fml.common.network.NetworkMod;
/*    */ import cpw.mods.fml.common.registry.GameRegistry;
/*    */ import cpw.mods.fml.common.registry.LanguageRegistry;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.common.Configuration;
/*    */ import net.minecraftforge.common.Property;
/*    */ 
/*    */ @Mod(modid="mMineTrax", name="MineTrax", version="1.1.4")
/*    */ @NetworkMod(clientSideRequired=true, serverSideRequired=false)
/*    */ public class MineTrax
/*    */ {
/*    */   int[] arrayDisc;
/*    */   public int numberOfDiscs;
/*    */   public static Item newDisc;
/*    */   public String songAuthor;
/*    */   public String songTitle;
/*    */   public String songFilename;
/*    */ 
/*    */   @SidedProxy(clientSide="mods.mminetrax.ClientProxyMineTrax", serverSide="mods.mminetrax.CommonProxyMineTrax")
/* 34 */   public static CommonProxyMineTrax proxyCommon = new CommonProxyMineTrax();
/*    */   public Configuration configFile;
/*    */ 
/*    */   @Mod.PreInit
/*    */   public void preInit(FMLPreInitializationEvent event)
/*    */     throws IOException
/*    */   {
/* 39 */     Configuration config = new Configuration(event.getSuggestedConfigurationFile());
/* 40 */     config.load();
/* 41 */     DataProxyMineTrax.discStartID = config.get("General", "DiscStartID", 15000).getInt(15000);
/* 42 */     this.numberOfDiscs = config.get("General", "NumberOfDiscs", 10).getInt();
/*    */ 
/* 44 */     this.arrayDisc = new int[this.numberOfDiscs];
/* 45 */     for (int curDisc = 0; curDisc < this.arrayDisc.length; curDisc++) {
/* 46 */       this.arrayDisc[curDisc] = curDisc;
/* 47 */       int discID = this.arrayDisc[curDisc] + DataProxyMineTrax.discStartID;
/* 48 */       String curDiscStr = Integer.toString(curDisc);
/* 49 */       this.songAuthor = config.get(curDiscStr, "SongAuthor", "None").getString();
/* 50 */       this.songTitle = config.get(curDiscStr, "SongTitle", "None").getString();
/* 51 */       this.songFilename = config.get(curDiscStr, "SongFilename", "None").getString();
/*    */ 
/* 53 */       newDisc = new ItemMineTraxRecord(discID, this.songFilename, this.songAuthor, this.songTitle).setUnlocalizedName("MusicDisc" + curDisc).setMaxStackSize(1).setFull3D();
/*    */ 
/* 56 */       chestGenStuffs.registerChestGenHooks(newDisc, 0, 2, 5);
/* 57 */       GameRegistry.registerItem(newDisc, "MusicDisc" + curDiscStr);
/* 58 */       LanguageRegistry.addName(newDisc, "Music Disc");
/*    */     }
/*    */ 
/* 61 */     config.save();
/*    */   }
/*    */ 
/*    */   @Mod.Init
/*    */   public void init(FMLInitializationEvent event) throws IOException
/*    */   {
/* 67 */     MineTraxItems.init();
/* 68 */     MineTraxBlocks.init();
/*    */   }
/*    */ 
/*    */   @Mod.PostInit
/*    */   public void postInit(FMLPostInitializationEvent event)
/*    */     throws IOException
/*    */   {
/*    */   }
/*    */ 
/*    */   public void parseMainConfig()
/*    */   {
/*    */   }
/*    */ }

/* Location:           D:\Documents and Settings\Administrator\Desktop\MineTrax1.2.2-1.5.2.jar
 * Qualified Name:     mods.mminetrax.MineTrax
 * JD-Core Version:    0.6.2
 */