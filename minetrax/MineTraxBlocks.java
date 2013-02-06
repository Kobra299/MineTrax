/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MineTraxBlocks {
// Add Blocks here

    //public static Block AdvancedJukebox;
    public static void init() {
        // Add anything else here, language registry, game registry etc.

        DataProxyMineTrax.AdvancedJukebox = new BlockAdvancedJukebox(DataProxyMineTrax.advancedJukeboxID, 0).setBlockName("advancedJukebox").setHardness(3F).setResistance(4F);
        GameRegistry.registerBlock(DataProxyMineTrax.AdvancedJukebox, "advancedJukebox");
        LanguageRegistry.addName(DataProxyMineTrax.AdvancedJukebox, "Advanced Jukebox");
    }
}