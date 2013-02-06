/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MineTraxItems {
    // Add Items here

    public static void init() {
        // Add anything else here, language registry, game registry etc.
        createItems();
    }

    public static void createItems() { //Why not doing it in .init? Because I prefer it that way. -DarkSnake
        DataProxyMineTrax.blankDiscID = DataProxyMineTrax.discStartID - 1; //"What if they set the start ID to 0?" - C'mon... people can't be that stupid... I think?
        DataProxyMineTrax.blankDisc = new ItemBlankDisc(DataProxyMineTrax.blankDiscID).setItemName("BlankDisc");
        GameRegistry.addRecipe(new ItemStack(DataProxyMineTrax.blankDisc, 8), "O", "I", "O", 'O', new ItemStack(Block.obsidian), 'I', new ItemStack(Item.ingotIron));
        GameRegistry.addRecipe(new ItemStack(DataProxyMineTrax.blankDisc, 8), "OIO", 'O', new ItemStack(Block.obsidian), 'I', new ItemStack(Item.ingotIron));

        chestGenStuffs.registerChestGenHooks(DataProxyMineTrax.blankDisc, 0, 2, 5); //Chances of getting in a natural chest: Rarity 5 (Vanilla Music Discs are Rarity 5) Amount: Minimum 0 - Maximum 2
        GameRegistry.registerItem(DataProxyMineTrax.blankDisc, "BlankDisc");
        LanguageRegistry.addName(DataProxyMineTrax.blankDisc, "Blank Disc");

    }
}
