/*    */ package mods.mminetrax;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.client.renderer.texture.IconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.EnumRarity;
/*    */ import net.minecraft.item.ItemRecord;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemMineTraxRecord extends ItemRecord
/*    */ {
/* 24 */   private static final Map recordMap = new HashMap();
/*    */   public final String recordFileName;
/*    */   public final String songAuthor;
/*    */   public final String songTitle;
/*    */ 
/*    */   protected ItemMineTraxRecord(int par1, String recordFileName, String songAuthor, String songTitle)
/*    */   {
/* 33 */     super(par1, recordFileName);
/* 34 */     this.recordFileName = recordFileName;
/* 35 */     this.maxStackSize = 1;
/* 36 */     this.songAuthor = songAuthor;
/* 37 */     this.songTitle = songTitle;
/* 38 */     setCreativeTab(CreativeTabs.tabMisc);
/* 39 */     recordMap.put(recordFileName, this);
/*    */   }
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_77624_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
/*    */   {
/* 46 */     par3List.add(func_90043_g());
/*    */   }
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String func_90043_g()
/*    */   {
/* 55 */     return this.songAuthor + " - " + this.songTitle;
/*    */   }
/*    */ 
/*    */   public void func_94581_a(IconRegister iconRegister)
/*    */   {
/* 60 */     this.itemIcon = iconRegister.registerIcon("mminetrax:disc");
/*    */   }
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public EnumRarity func_77613_e(ItemStack par1ItemStack)
/*    */   {
/* 70 */     return EnumRarity.rare;
/*    */   }
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public static ItemRecord getRecord(String par0Str)
/*    */   {
/* 78 */     return (ItemRecord)recordMap.get(par0Str);
/*    */   }
/*    */ }