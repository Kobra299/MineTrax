/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class BlockAdvancedJukebox extends BlockContainer {
//Clank's (wonderful) W.I.P. Advanced Jukebox block! :o

    protected BlockAdvancedJukebox(int par1, int par2) {
        super(par1, par2, Material.rock);
        this.setBlockName("Advanced Jukebox");
        this.disableStats();
        this.setRequiresSelfNotify();
        this.setCreativeTab(CreativeTabs.tabDecorations);
        MinecraftForgeClient.preloadTexture("/minetrax/gfx/blocks.png");

    }

    @Override
    public String getTextureFile() {
        return "/minetrax/gfx/blocks.png";
    }
    /* In blocks.png: Image with Index 0 = Bottom, 1 = Top, etc...
     * 0=Bottom
     * 1=Top
     * 2=East
     * 3=West
     * 4=North
     * 5=South
     */
    @Override
    public int getBlockTextureFromSideAndMetadata(int i, int j) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 0;
            case 3:
                return 0;
            case 4:
                return 0;
            case 5:
                return 0;
            default:
                return 0;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World var1) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Return an item rarity from EnumRarity
     */
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack) {
        return EnumRarity.epic;
    }
}