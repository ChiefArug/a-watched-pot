package design.aeonic.watchedpot;

import design.aeonic.watchedpot.platform.NeoForgeConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(WatchedPot.MOD_ID)
@Mod.EventBusSubscriber(modid = WatchedPot.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NeoForgeWatchedPot {

    public NeoForgeWatchedPot(IEventBus modBus, ModLoadingContext ctx) {
        WatchedPot.init();
        modBus.addListener((FMLClientSetupEvent event) -> WatchedPot.clientInit(event::enqueueWork));
        ctx.registerConfig(ModConfig.Type.SERVER, NeoForgeConfig.SERVER_SPEC);
    }

}
