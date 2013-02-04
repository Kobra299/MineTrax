/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import java.io.File;
import java.io.IOException;
import net.minecraftforge.common.Configuration;

public final class MineTraxAlbumMaker {

    public int numberOfDiscs;
    int arrayDisc[];

    public MineTraxAlbumMaker() {
    }

    public void DoStuffs() throws IOException {

        makeAlbum();
    }
    
    public void makeAlbum() throws IOException {
//TODO: SongAuthor, SongTitle, SongFilename, lots of stuffs! (?)
        Configuration config = new Configuration(new File("albums/" + DataProxyMineTrax.currentAlbum + ".cfg"));


        config.load();

        numberOfDiscs = Integer.parseInt(config.get("General", "NumberOfDiscs", 10).value);

        arrayDisc = new int[numberOfDiscs];
        for (int curDisc = 0; curDisc < arrayDisc.length; curDisc++) {
            arrayDisc[curDisc] = curDisc;
            System.out.println("Element " + curDisc + ": " + arrayDisc[curDisc]);

        }


        config.save();
    }
}
