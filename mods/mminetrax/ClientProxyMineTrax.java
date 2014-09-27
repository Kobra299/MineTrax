package mods.mminetrax;

import cpw.mods.fml.common.eventhandler.EventBus;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxyMineTrax extends CommonProxyMineTrax
{
  public void registerEverything()
  {
    registerSoundEvents();
    registerRenderStuffs();
  }

  public void registerSoundEvents()
  {
	  MinecraftForge.EVENT_BUS.register(new SoundEvent(null));
  }
}