MineTrax
========

A custom music discs mod for Minecraft.

Custom music discs are defined in a config file and are automatically added to the game.

Do not redistribute this mod freely, only redristribute it with copyclank's, find him on irc, permission.


/config/MineTrax_album.cfg:
This is an example of what could be your FIRST song:

    0 {
        S:SongAuthor=C418
        S:SongFilename=hal3
        I:SongGFXID=1
        S:SongTitle=Haggstrom
    }

In the "general" part of the album config (/config/MineTrax_album.cfg), you can add or remove discs w/ numberOfDiscs=
Let's say you have set the music disc 0, 1 and 2, you will want to modify numberOfDiscs to 3 (0 being the first, 1 the second, 2 the third)

    Remember:
        -LET THE GAME RUN ONCE TO CREATE THE ALBUM AND THE MOD'S CONFIG FILE
        -PUT SONGS IN OGG FORMAT IN \resources\mod\streaming !!
        -Discs will load even if they are set to nothing!
        -Discs are from 0 to (numberOfDisc - 1)
        -If, for example, you set numberOfDisc to 3, discs from 3 and up won't load! (Like said before, The first disc is 0!)
        -Everything supports spaces in the names!
        
-Meow
