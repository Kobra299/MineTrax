package mods.mminetrax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.GameData;

@Mod(modid = "mminetrax", name = "MineTrax", version = "1.12.2", acceptedMinecraftVersions = "1.12.2")
public class MineTrax {
	int[] arrayDisc;
	public int numberOfDiscs;
	public String songAuthor;
	public String songTitle;
	public String songFilename;
	public Configuration configFile;
	public static List<Item> items = new ArrayList<Item>();
	public static MusicBox box;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) throws IOException {
		box = new MusicBox();
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		this.numberOfDiscs = config.get("General", "NumberOfDiscs", 10).getInt();
		this.arrayDisc = new int[this.numberOfDiscs];
		int i = -1;
		for (int curDisc = 0; curDisc < this.arrayDisc.length; curDisc++) {
			i++;
			this.arrayDisc[curDisc] = curDisc;
			String curDiscStr = Integer.toString(curDisc);
			this.songAuthor = config.get(curDiscStr, "SongAuthor", "none").getString();
			this.songTitle = config.get(curDiscStr, "SongTitle", "none").getString();
			this.songFilename = config.get(curDiscStr, "SongFilename", "none").getString();
			items.add(new ItemMineTraxRecord(curDiscStr, songAuthor, songTitle, new Sound(new ResourceLocation("mminetrax:records."+this.songFilename))));
		}
		config.save();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) throws IOException {
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static CreativeTabs tabmusicdisc = new CreativeTabs("tabmusicdisc") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.RECORD_13);
		}
	};
}