package mods.mminetrax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = "mminetrax", name = "MineTrax", version = "1.12.2", acceptedMinecraftVersions = "1.12.2")
public class MineTrax {
	int[] arrayDisc;
	public int numberOfDiscs;
	public String songTitle;
	public String songFilename;
	public static List<Item> items;
	public static MusicBox box;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) throws IOException {
		items = new ArrayList<Item>();
		box = new MusicBox();
		String json = Resources.toString(this.getClass().getResource("/assets/mminetrax/sounds.json"), Charsets.UTF_8);
		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(json, JsonObject.class);
		for(Entry<String, JsonElement> el : obj.entrySet()) {
			songTitle = el.getKey().split("\\.")[1];
			songFilename = el.getValue().getAsJsonObject().get("sounds").getAsJsonArray().get(0).getAsJsonObject().get("name").getAsString();
			items.add(new ItemMineTraxRecord(songTitle, new Sound(new ResourceLocation("mminetrax", el.getKey()))));
		}
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