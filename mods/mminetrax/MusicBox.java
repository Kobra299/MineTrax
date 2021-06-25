package mods.mminetrax;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MusicBox extends Item {

	public MusicBox() {
		this.setMaxStackSize(1);
		this.setUnlocalizedName("musicbox");
		this.setRegistryName("musicbox");
		this.setCreativeTab(MineTrax.tabmusicdisc);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		Random ran = new Random();
		int x = ran.nextInt(MineTrax.items.size());
		playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem,
				new ItemStack(MineTrax.items.get(x), 1, 0));
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
}