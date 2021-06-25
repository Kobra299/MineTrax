package mods.mminetrax;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventsHandler {
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(MineTrax.items.toArray(new Item[] {}));
		event.getRegistry().register(MineTrax.box);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		for(Item item : MineTrax.items) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation("mminetrax:disc", "inventory"));
		}
		ModelLoader.setCustomModelResourceLocation(MineTrax.box, 0, new ModelResourceLocation("mminetrax:box", "inventory"));
	}
}