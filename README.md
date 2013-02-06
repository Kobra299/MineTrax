MineTrax
========

A custom music discs mod for Minecraft.

Custom music discs are defined in a config file and are automatically added to the game.

PUT SONGS IN OGG FORMAT IN \resources\mod\streaming !!
LET THE GAME RUN ONCE TO CREATE THE ALBUM AND THE MOD'S CONFIG FILE

/config/MineTrax_album.cfg:
    S:SongAuthor=C418
    S:SongFilename=hal3
    I:SongGFXID=1
    S:SongTitle=Haggstrom

In the "general" part of the config, you can add or remove discs w/ numberOfDiscs=

Remember:
-Discs will load even if they are set to nothing!
-Discs are from 0 to (numberOfDisc - 1)
-If, for example, you set numberOfDisc to 3, discs from 3 and up won't load! (Like said before, The first disc is 0!)
-Everything supports spaces in the names!

-Moo
