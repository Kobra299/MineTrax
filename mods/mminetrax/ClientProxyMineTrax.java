/*    */ package mods.mminetrax;
/*    */ 
/*    */ import net.minecraftforge.client.event.sound.SoundEvent;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.event.EventBus;
/*    */ 
/*    */ public class ClientProxyMineTrax extends CommonProxyMineTrax
/*    */ {
/*    */   public void registerEverything()
/*    */   {
/* 18 */     registerSoundEvents();
/* 19 */     registerRenderStuffs();
/* 20 */     registerCustomDrops();
/*    */   }
/*    */ 
/*    */   public void registerSoundEvents()
/*    */   {
/* 29 */     MinecraftForge.EVENT_BUS.register(new SoundEvent());
/*    */   }
/*    */ 
/*    */   public void registerCustomDrops()
/*    */   {
/* 38 */     MinecraftForge.EVENT_BUS.register(new CreeperDiscDrops());
/*    */   }
/*    */ }

/* Location:           D:\Documents and Settings\Administrator\Desktop\MineTrax1.2.2-1.5.2.jar
 * Qualified Name:     mods.mminetrax.ClientProxyMineTrax
 * JD-Core Version:    0.6.2
 */