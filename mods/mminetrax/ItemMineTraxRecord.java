package mods.mminetrax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMineTraxRecord extends ItemRecord {
	public String songTitle;
	protected ItemMineTraxRecord(String songTitle, SoundEvent soundIn) {
		super(songTitle, soundIn);
		this.setUnlocalizedName(songTitle);
		this.setRegistryName(songTitle);
		this.setCreativeTab(MineTrax.tabmusicdisc);
		this.songTitle = songTitle;
	}

    @SideOnly(Side.CLIENT)
    public String getRecordNameLocal()
    {
        return this.songTitle;
    }
}