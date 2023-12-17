package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.ItemTool;
import cn.nukkit.item.MinecraftItemID;

import javax.annotation.Nullable;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author MagicDroidX (Nukkit Project)
 */
@PowerNukkitDifference(since = "FUTURE", info = "Extends BlockOre instead of BlockSolid only in PowerNukkit")
public class BlockOreCoal extends BlockOre {

    public BlockOreCoal() {
        // Does nothing
    }

    @Override
    public int getId() {
        return COAL_ORE;
    }

    @Override
    public String getName() {
        return "Coal Ore";
    }

    @Override

    public int getToolTier() {
        return ItemTool.TIER_WOODEN;
    }


    @Nullable
    @Override
    protected MinecraftItemID getRawMaterial() {
        return MinecraftItemID.COAL;
    }

    @Override
    public int getDropExp() {
        return ThreadLocalRandom.current().nextInt(3);
    }

}
