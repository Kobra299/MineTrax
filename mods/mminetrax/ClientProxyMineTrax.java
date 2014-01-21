 package mods.mminetrax;
 
 import net.minecraftforge.client.event.sound.SoundEvent;
 import net.minecraftforge.common.MinecraftForge;
 import net.minecraftforge.event.EventBus;
 
 public class ClientProxyMineTrax extends CommonProxyMineTrax
 {
   public void registerEverything()
   {
     registerSoundEvents();
     registerRenderStuffs();
   }
 
   public void registerSoundEvents()
   {
     MinecraftForge.EVENT_BUS.register(new SoundEvent());
   }
}