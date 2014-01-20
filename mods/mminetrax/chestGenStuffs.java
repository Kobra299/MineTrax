/*    */ package mods.mminetrax;
/*    */ 
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.WeightedRandomChestContent;
/*    */ import net.minecraftforge.common.ChestGenHooks;
/*    */ 
/*    */ public class chestGenStuffs
/*    */ {
/*    */   public static void registerChestGenHooks(Item Item, int min, int max, int rarity)
/*    */   {
/* 12 */     ChestGenHooks.getInfo("bonusChest").addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
/* 13 */     ChestGenHooks.getInfo("dungeonChest").addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
/* 14 */     ChestGenHooks.getInfo("mineshaftCorridor").addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
/* 15 */     ChestGenHooks.getInfo("pyramidDesertyChest").addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
/* 16 */     ChestGenHooks.getInfo("pyramidJungleChest").addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
/*    */ 
/* 19 */     ChestGenHooks.getInfo("strongholdCorridor").addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
/* 20 */     ChestGenHooks.getInfo("strongholdCrossing").addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
/* 21 */     ChestGenHooks.getInfo("strongholdLibrary").addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
/* 22 */     ChestGenHooks.getInfo("villageBlacksmith").addItem(new WeightedRandomChestContent(new ItemStack(Item), min, max, rarity));
/*    */   }
/*    */ }

/* Location:           D:\Documents and Settings\Administrator\Desktop\MineTrax1.2.2-1.5.2.jar
 * Qualified Name:     mods.mminetrax.chestGenStuffs
 * JD-Core Version:    0.6.2
 */