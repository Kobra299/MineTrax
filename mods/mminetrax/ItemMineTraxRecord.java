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

public class ItemMineTraxRecord extends ItemRecord
{
  private static final Map recordMap = new HashMap();
  public final String recordFileName;
  public final String songAuthor;
  public final String songTitle;

  protected ItemMineTraxRecord(String recordFileName, String songAuthor, String songTitle)
  {
    super(recordFileName);
    this.recordFileName = recordFileName;
    this.maxStackSize = 1;
    this.songAuthor = songAuthor;
    this.songTitle = songTitle;
    setCreativeTab(CreativeTabs.tabMisc);
    recordMap.put(recordFileName, this);
  }

  @SideOnly(Side.CLIENT)
  public void func_77624_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
  {
    par3List.add(func_150927_i());
  }

  @SideOnly(Side.CLIENT)
  public String func_150927_i()
  {
    return StatCollector.translateToLocal(this.songAuthor + " - " + this.songTitle);
  }

  public void func_94581_a(IIconRegister iconRegister)
  {
    this.itemIcon = iconRegister.registerIcon("mminetrax:disc");
  }

  @SideOnly(Side.CLIENT)
  public EnumRarity func_77613_e(ItemStack par1ItemStack)
  {
    return EnumRarity.rare;
  }

  @SideOnly(Side.CLIENT)
  public static ItemRecord func_150926_b(String par0Str)
  {
    return (ItemRecord)recordMap.get(par0Str);
  }
  
  @Override
  public ResourceLocation getRecordResource(String name)
  {
  return new ResourceLocation("mminetrax:" + name);
  }
}