package mods.mminetrax;

import java.util.Random;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MusicBox extends Item {
	    public static Item Box;
	    
	    public static void init() {
	    	Box = new MusicBox().setUnlocalizedName("MusicBox").setTextureName("mminetrax:box").setCreativeTab(MineTrax.tabmusicdisc);
	        GameRegistry.registerItem(Box, Box.getUnlocalizedName());
	        LanguageRegistry.addName(Box, "Music Box");
	    }
	    
	    @Override
	    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
	    	this.maxStackSize = 1;
	    	world.playSoundAtEntity(entityplayer, "random.bow", 0.5F, 0.4F/(itemRand.nextFloat()*0.4F+0.8F));
	    	Random ran = new Random();
	    	int x = ran.nextInt(MineTrax.items.size()-1);
	    	entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, new ItemStack(MineTrax.items.get(x), 1, 0));
			return itemstack;
	    }
}