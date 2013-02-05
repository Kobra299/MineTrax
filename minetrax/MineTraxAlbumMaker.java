/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.io.File;
import java.io.IOException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

public final class MineTraxAlbumMaker
{

    public int numberOfDiscs;
    int arrayDisc[];
    public static Item newDisc;
    public String songAuthor;
    public String songTitle;
    public String songFilename;
    public int songGFXID;

    /**
     * Loads the albums
     * Notes:
     *    This method will forever be named doStuffs in memory of DarkSnake's
     *    old conventions that were riddled through this mod.
     * @param config
     * @throws IOException
     */
    public void doStuffs(Configuration config) throws IOException
    {
        numberOfDiscs = Integer.parseInt(config.get("General", "NumberOfDiscs", 10).value);

        arrayDisc = new int[numberOfDiscs];
        for (int curDisc = 0; curDisc < arrayDisc.length; curDisc++)
        {
            arrayDisc[curDisc] = curDisc;
            int discID = arrayDisc[curDisc] + DataProxyMineTrax.discStartID;
            String curDiscStr = Integer.toString(curDisc);
            songAuthor = config.get(curDiscStr, "SongAuthor", "None").value;
            songTitle = config.get(curDiscStr, "SongTitle", "None").value;
            songFilename = config.get(curDiscStr, "SongFilename", "None").value;
            songGFXID = Integer.parseInt(config.get(curDiscStr, "SongGFXID", 1).value);

            newDisc = new ItemMineTraxRecord(discID, songFilename, songAuthor, songTitle).setIconIndex(1).setItemName("MusicDisc" + curDisc);
            GameRegistry.registerItem(newDisc, "MusicDisc" + curDiscStr);
            LanguageRegistry.addName(newDisc, "Music Disc");
        }
        
        config.save();
    }
}