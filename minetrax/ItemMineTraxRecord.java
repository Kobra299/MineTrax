/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;

public class ItemMineTraxRecord extends ItemRecord
{

    /**
     * List of all record items and their names.
     */
    private static final Map<String, ItemMineTraxRecord> recordMap = new HashMap<String, ItemMineTraxRecord>();
    
    /**
     * The name of the record.
     */
    public final String recordFileName;
    public final String songAuthor;
    public final String songTitle;

    protected ItemMineTraxRecord(int par1, String recordFileName, String songAuthor, String songTitle)
    {
        super(par1, recordFileName);
        this.recordFileName = recordFileName;
        this.maxStackSize = 1;
        this.songAuthor = songAuthor;
        this.songTitle = songTitle;
        this.setCreativeTab(CreativeTabs.tabMisc);
        recordMap.put(recordFileName, this);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add(this.getRecordTitle());
    }

    /**
     * Return the title for this record.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public String getRecordTitle()
    {
        return this.songAuthor + " - " + this.songTitle;
    }

    @Override
    public String getTextureFile()
    {
        return "/minetrax/gfx/discs.png";
    }

    /**
     * Return an item rarity from EnumRarity
     */
    @SideOnly(Side.CLIENT)
    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.rare;
    }

    /**
     * Return the record item corresponding to the given name.
     */
    @SideOnly(Side.CLIENT)
    public static ItemRecord getRecord(String par0Str)
    {
        return (ItemRecord) recordMap.get(par0Str);
    }
}
