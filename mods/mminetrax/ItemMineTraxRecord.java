package mods.mminetrax;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class ItemMineTraxRecord extends ItemRecord {
	private static final Map recordMap = new HashMap();
	public final String recordFileName;
	public final String songAuthor;
	public final String songTitle;

	protected ItemMineTraxRecord(String recordFileName, String songAuthor, String songTitle) {
		super(recordFileName);
		this.recordFileName = recordFileName;
		this.maxStackSize = 1;
		this.songAuthor = songAuthor;
		this.songTitle = songTitle;
		setCreativeTab(MineTrax.tabmusicdisc);
		recordMap.put(recordFileName, this);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(getRecordNameLocal());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public String getRecordNameLocal() {
		return StatCollector.translateToLocal(this.songAuthor + " - " + this.songTitle);
	}

	public void func_94581_a(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("mminetrax:disc");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.rare;
	}

	@Override
	public ResourceLocation getRecordResource(String name) {
		return new ResourceLocation("mminetrax:" + name);
	}
}