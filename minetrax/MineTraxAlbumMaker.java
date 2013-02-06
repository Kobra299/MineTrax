/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.io.File;
import java.io.IOException;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public final class MineTraxAlbumMaker {

    int arrayDisc[];
    public int numberOfDiscs;
    public static Item newDisc;
    public String songAuthor;
    public String songTitle;
    public String songFilename;
    public int songGFXID;
    public Configuration albumConfigFile;

    /**
     * Loads the albums Notes: This method will forever be named doStuffs in
     * memory of DarkSnake's innovative conventions that were implemented
     * through this mod.
     *
     * @throws IOException
     */
    @ForgeSubscribe
    public void doStuffs() throws IOException {
        albumConfigFile = new Configuration(new File("config/MineTrax_album.cfg"));
        albumConfigFile.load();

        numberOfDiscs = Integer.parseInt(albumConfigFile.get("General", "NumberOfDiscs", 10).value);

        arrayDisc = new int[numberOfDiscs];
        for (int curDisc = 0; curDisc < arrayDisc.length; curDisc++) {
            arrayDisc[curDisc] = curDisc;
            int discID = arrayDisc[curDisc] + DataProxyMineTrax.discStartID;
            String curDiscStr = Integer.toString(curDisc);
            songAuthor = albumConfigFile.get(curDiscStr, "SongAuthor", "None").value;
            songTitle = albumConfigFile.get(curDiscStr, "SongTitle", "None").value;
            songFilename = albumConfigFile.get(curDiscStr, "SongFilename", "None").value;
            songGFXID = Integer.parseInt(albumConfigFile.get(curDiscStr, "SongGFXID", 1).value);

            newDisc = new ItemMineTraxRecord(discID, songFilename, songAuthor, songTitle).setIconIndex(1).setItemName("MusicDisc" + curDisc).setMaxStackSize(64).setFull3D();


            chestGenStuffs.registerChestGenHooks(newDisc, 0, 2, 5);
            GameRegistry.registerItem(newDisc, "MusicDisc" + curDiscStr);
            LanguageRegistry.addName(newDisc, "Music Disc");
        }

        albumConfigFile.save();
    }
}