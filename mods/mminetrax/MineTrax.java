package mods.mminetrax;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.RegistryNamespaced;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

@Mod(modid="mMineTrax", name="MineTrax", version="1.1.4")
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
  public static final RegistryNamespaced itemRegistry = GameData.getItemRegistry();
  static List<Item> items = new ArrayList<Item>();
  
  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent event) throws IOException {
    Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    config.load();
    DataProxyMineTrax.discStartID = config.get("General", "DiscStartID", 15000).getInt(15000);
    this.numberOfDiscs = config.get("General", "NumberOfDiscs", 10).getInt();

    this.arrayDisc = new int[this.numberOfDiscs];
    int i = -1;
    for (int curDisc = 0; curDisc < this.arrayDisc.length; curDisc++) {
      i++;
      this.arrayDisc[curDisc] = curDisc;
      int discID = this.arrayDisc[curDisc] + DataProxyMineTrax.discStartID;
      String curDiscStr = Integer.toString(curDisc);
      this.songAuthor = config.get(curDiscStr, "SongAuthor", "None").getString();
      this.songTitle = config.get(curDiscStr, "SongTitle", "None").getString();
      this.songFilename = config.get(curDiscStr, "SongFilename", "None").getString(); 
      newDisc = new ItemMineTraxRecord(this.songFilename, this.songAuthor, this.songTitle).setUnlocalizedName("MusicDisc" + curDisc).setMaxStackSize(1).setFull3D().setTextureName("mminetrax:disc");
      itemRegistry.addObject(discID, "record"+curDisc, newDisc);
      LanguageRegistry.addName(newDisc, "Music Disc");
      items.add(newDisc);
    }
    MusicBox.init();
    GameRegistry.addRecipe(new ItemStack(MusicBox.Box), new Object[] {"###", "#I#", "###", '#', Items.iron_ingot, 'I', Items.flint});

    config.save();
  }

  @Mod.EventHandler
  public void postInit(FMLPostInitializationEvent event) throws IOException {
  }
  public static CreativeTabs tabmusicdisc = new CreativeTabs("tabmusicdisc") {
      @Override
      @SideOnly(Side.CLIENT)
      public Item getTabIconItem() {
          return Items.record_13;
      }
  };

  public void parseMainConfig()
  {
  }
}