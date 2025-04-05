package com.hudshow.neoforge;

import com.hudshow.neoforge.core.init.CreativeModeTabInit;
import com.hudshow.neoforge.core.init.ItemInit;
import com.hudshow.neoforge.data.DataGenerators;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Show tree generation next.
@Mod(MagicMirror.MOD_ID)
public class MagicMirror {
    public static final String MOD_ID = "magicmirror";
    public static Logger logger = LoggerFactory.getLogger(MagicMirror.class);

    public MagicMirror(IEventBus bus) {
        // register
        ItemInit.ITEMS.register(bus);
        //BlockInit.BLOCKS.register(bus);
        CreativeModeTabInit.CREATIVE_MODE_TABS.register(bus);

        // listeners
        bus.addListener(DataGenerators::gatherData);

        bus.addListener(FMLClientSetupEvent.class, (fmlClientSetupEvent -> {
            fmlClientSetupEvent.enqueueWork(() -> {
                ModList.get().getModContainerById(MOD_ID).ifPresent(modContainer -> {
                    logger.info("Loaded {}, using version {}", modContainer.getModInfo().getDisplayName(), modContainer.getModInfo().getVersion());
                });
            });
        }));
    }
}
