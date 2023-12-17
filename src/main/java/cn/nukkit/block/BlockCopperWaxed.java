package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;

/**
 * @author LoboMetalurgico
 * @since 11/06/2021
 */


public class BlockCopperWaxed extends BlockCopper {


    public BlockCopperWaxed() {
        // Does nothing
    }

    @Override
    public String getName() {
        return "Waxed Block of Copper";
    }

    @Override
    public int getId() {
        return WAXED_COPPER;
    }


    @Override
    public boolean isWaxed() {
        return true;
    }
}
