/* Read LICENSE.TXT for this mod's LICENSE! */
package minetrax;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxyMineTrax extends CommonProxyMineTrax {

    /**
     * *
     * Does everything here, cleaner Main class.
     */
    @Override
    public void registerEverything() {
        registerSoundEvents();
        registerRenderStuffs();
        registerCustomDrops();
    }

    /**
     * *
     * Register the sound events
     */
    @Override
    public void registerSoundEvents() {
        MinecraftForge.EVENT_BUS.register(new SoundEvent());

    }

    /**
     * *
     * Register the CustomDrops for vanilla mobs
     */
    public void registerCustomDrops() {
        MinecraftForge.EVENT_BUS.register(new CreeperDiscDrops());
    }

    /**
     * *
     * Register the rendering
     */
    @Override
    public void registerRenderStuffs() {
        MinecraftForgeClient.preloadTexture("MineTrax/gfx/discs.png");
        MinecraftForgeClient.preloadTexture("MineTrax/gfx/blocks.png");
    }
}
