/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.io.File;
import java.io.IOException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

public final class MineTraxAlbumMaker {

    public int numberOfDiscs;
    int arrayDisc[];

    public MineTraxAlbumMaker() {
    }

    public void DoStuffs() throws IOException {

        makeAlbum();
    }
    public static Item newDisc;
    public String SongAuthor;
    public String SongTitle;
    public String SongFilename;
    public int SongGFXID;
    public String int2strCurDisc;

    public void makeAlbum() throws IOException {
//TODO: SongAuthor, SongTitle, SongFilename, lots of stuffs! (?)
        Configuration config = new Configuration(new File("albums/" + DataProxyMineTrax.currentAlbum + ".cfg"));


        config.load();

        numberOfDiscs = Integer.parseInt(config.get("General", "NumberOfDiscs", 10).value);

        arrayDisc = new int[numberOfDiscs];
        for (int curDisc = 0; curDisc < arrayDisc.length; curDisc++) {
            arrayDisc[curDisc] = curDisc;
            int discID = arrayDisc[curDisc] + DataProxyMineTrax.discStartID;
            int2strCurDisc = Integer.toString(curDisc);
            SongAuthor = config.get(int2strCurDisc, "SongAuthor", "None").value;
            SongTitle = config.get(int2strCurDisc, "SongTitle", "None").value;
            SongFilename = config.get(int2strCurDisc, "SongFilename", "None").value;
            SongGFXID = Integer.parseInt(config.get(int2strCurDisc, "SongGFXID", 1).value);



            newDisc = new ItemMineTraxRecord(discID, SongFilename, SongAuthor, SongTitle).setIconIndex(1).setItemName("MusicDisc" + int2strCurDisc);

            GameRegistry.registerItem(newDisc, "MusicDisc" + int2strCurDisc);
            LanguageRegistry.addName(newDisc, "Music Disc");


//            System.out.println("Element " + curDisc + ": " + arrayDisc[curDisc]);

        }


        config.save();
    }
}
