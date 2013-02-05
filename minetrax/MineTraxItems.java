/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MineTraxItems {
    // Add Items here

    public static void init() {
        // Add anything else here, language registry, game registry etc.
        createItems();

        /* 
         * BTW, I've deleted the Class for LangRegistryStuffs, since we didn't use it, and we're already doing that stuff either here for normal items, or in the album maker for the custom discs.
         * -DarkSnake
         */
    }

    public static void createItems() { //Why not doing it in .init? Because I prefer it that way. -DarkSnake
        DataProxyMineTrax.blankDiscID = DataProxyMineTrax.discStartID - 1; //"What if they set the start ID to 0?" - C'mon... people can't be that stupid... I think?
        DataProxyMineTrax.blankDisc = new ItemBlankDisc(DataProxyMineTrax.blankDiscID).setItemName("BlankDisc");
        GameRegistry.registerItem(DataProxyMineTrax.blankDisc, "BlankDisc");
        LanguageRegistry.addName(DataProxyMineTrax.blankDisc, "Blank Disc");
    }
}
