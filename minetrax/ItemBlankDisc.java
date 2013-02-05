/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBlankDisc extends Item {

    protected ItemBlankDisc(int id) {
        super(id);
        this.setCreativeTab(CreativeTabs.tabMisc);
        this.iconIndex = 0;

    }

    @Override
    public String getTextureFile() {
        return "/minetrax/gfx/discs.png";
    }
}
