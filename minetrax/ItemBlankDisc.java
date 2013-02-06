/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBlankDisc extends Item {

    protected ItemBlankDisc(int id) {
        super(id);
        this.setCreativeTab(CreativeTabs.tabMisc);
        this.iconIndex = 0;
        this.maxStackSize = 64;

    }

    @Override
    public String getTextureFile() {
        return "/minetrax/gfx/discs.png";
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) { //Because why not? :p (Enchantment glow effect)
        return true;
    }
}
