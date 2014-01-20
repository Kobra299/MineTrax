/*    */ package mods.mminetrax;
/*    */ 
/*    */ import cpw.mods.fml.common.registry.GameRegistry;
/*    */ import cpw.mods.fml.common.registry.LanguageRegistry;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class MineTraxItems
/*    */ {
/*    */   public static void init()
/*    */   {
/* 15 */     createItems();
/*    */   }
/*    */ 
/*    */   public static void createItems() {
/* 19 */     DataProxyMineTrax.blankDiscID = DataProxyMineTrax.discStartID - 1;
/* 20 */     DataProxyMineTrax.blankDisc = new ItemBlankDisc(DataProxyMineTrax.blankDiscID).setTextureName("BlankDisc");
/* 21 */     GameRegistry.addRecipe(new ItemStack(DataProxyMineTrax.blankDisc, 8), new Object[] { "O", "I", "O", Character.valueOf('O'), new ItemStack(Block.obsidian), Character.valueOf('I'), new ItemStack(Item.ingotIron) });
/* 22 */     GameRegistry.addRecipe(new ItemStack(DataProxyMineTrax.blankDisc, 8), new Object[] { "OIO", Character.valueOf('O'), new ItemStack(Block.obsidian), Character.valueOf('I'), new ItemStack(Item.ingotIron) });
/*    */ 
/* 24 */     chestGenStuffs.registerChestGenHooks(DataProxyMineTrax.blankDisc, 0, 2, 5);
/* 25 */     GameRegistry.registerItem(DataProxyMineTrax.blankDisc, "BlankDisc");
/* 26 */     LanguageRegistry.addName(DataProxyMineTrax.blankDisc, "Blank Disc");
/*    */   }
/*    */ }

/* Location:           D:\Documents and Settings\Administrator\Desktop\MineTrax1.2.2-1.5.2.jar
 * Qualified Name:     mods.mminetrax.MineTraxItems
 * JD-Core Version:    0.6.2
 */