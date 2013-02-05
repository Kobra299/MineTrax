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

public class ItemMineTraxRecord extends ItemRecord {

    /**
     * List of all record items and their names.
     */
    private static final Map records = new HashMap();
    /**
     * The name of the record.
     */
    public final String recordFileName;
    public final String SongAuthor;
    public final String SongTitle;

    protected ItemMineTraxRecord(int par1, String recordFileName, String SongAuthor, String SongTitle) {
        super(par1, recordFileName);
        this.recordFileName = recordFileName;
        this.maxStackSize = 1;
        this.SongAuthor = SongAuthor;
        this.SongTitle = SongTitle;
        this.setCreativeTab(CreativeTabs.tabMisc);
        records.put(recordFileName, this);
        
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        par3List.add(this.getRecordTitle());
    }

    @SideOnly(Side.CLIENT)
    /**
     * Return the title for this record.
     */
    @Override
    public String getRecordTitle() {
        return this.SongAuthor + " - " + this.SongTitle;
    }

    @Override
    public String getTextureFile() {
        return "/minetrax/gfx/discs.png";
    }
    @SideOnly(Side.CLIENT)
    /**
     * Return an item rarity from EnumRarity
     */
    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {
        return EnumRarity.rare;
    }

    @SideOnly(Side.CLIENT)
    /**
     * Return the record item corresponding to the given name.
     */
    public static ItemRecord getRecord(String par0Str) {
        return (ItemRecord) records.get(par0Str);
    }
}
