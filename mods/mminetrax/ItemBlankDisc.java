/*    */ package mods.mminetrax;
/*    */ 
/*    */ import net.minecraft.client.renderer.texture.IconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemBlankDisc extends Item
/*    */ {
/*    */   protected ItemBlankDisc(int id)
/*    */   {
/* 12 */     super(id);
/* 13 */     setCreativeTab(CreativeTabs.tabMisc);
/* 14 */     this.maxStackSize = 64;
/*    */   }
/*    */ 
/*    */   public boolean func_77636_d(ItemStack par1ItemStack)
/*    */   {
/* 20 */     return true;
/*    */   }
/*    */ 
/*    */   public void func_94581_a(IconRegister iconRegister)
/*    */   {
/* 25 */     this.itemIcon = iconRegister.registerIcon("mminetrax:disc");
/*    */   }
/*    */ }

/* Location:           D:\Documents and Settings\Administrator\Desktop\MineTrax1.2.2-1.5.2.jar
 * Qualified Name:     mods.mminetrax.ItemBlankDisc
 * JD-Core Version:    0.6.2
 */