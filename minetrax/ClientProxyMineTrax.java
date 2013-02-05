/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxyMineTrax extends CommonProxyMineTrax {

    public static void registerRenderThings() {
    }

    public static void registerSoundEvents() {
        MinecraftForge.EVENT_BUS.register(new SoundEvent());
        MinecraftForgeClient.preloadTexture("MineTrax/gfx/discs.png");
    }
}
