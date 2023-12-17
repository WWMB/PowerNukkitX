package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;

/**
 * @author LoboMetalurgico
 * @since 11/06/2021
 */


public class BlockCopperExposedWaxed extends BlockCopperExposed {


    public BlockCopperExposedWaxed( ) {
        // Does nothing
    }

    @Override
    public String getName() {
        return "Waxed Exposed Copper";
    }

    @Override
    public int getId() {
        return WAXED_EXPOSED_COPPER;
    }


    @Override
    public boolean isWaxed() {
        return true;
    }
}
