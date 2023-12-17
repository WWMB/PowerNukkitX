package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.IntBlockProperty;
import cn.nukkit.event.block.BlockGrowEvent;
import cn.nukkit.item.Item;
import cn.nukkit.level.Level;
import cn.nukkit.level.particle.BoneMealParticle;
import cn.nukkit.math.BlockFace;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public abstract class BlockCrops extends BlockFlowable {


    public static final IntBlockProperty GROWTH = new IntBlockProperty("growth", false, 7);


    public static final BlockProperties PROPERTIES = new BlockProperties(GROWTH);


    public static final int MINIMUM_LIGHT_LEVEL = 9;

    protected BlockCrops(int meta) {
        super(meta);
    }


    @NotNull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }


    public int getMinimumLightLevel() {
        return MINIMUM_LIGHT_LEVEL;
    }


    public int getMaxGrowth() {
        return GROWTH.getMaxValue();
    }


    public int getGrowth() {
        return getIntValue(GROWTH);
    }


    public void setGrowth(int growth) {
        setIntValue(GROWTH, growth);
    }


    public boolean isFullyGrown() {
        return getGrowth() >= getMaxGrowth();
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }


    @Override
    public boolean place(@NotNull Item item, @NotNull Block block, @NotNull Block target, @NotNull BlockFace face, double fx, double fy, double fz, Player player) {
        if (block.down().getId() == FARMLAND) {
            this.getLevel().setBlock(block, this, true, true);
            return true;
        }
        return false;
    }

    @Override
    public boolean onActivate(@NotNull Item item, Player player) {
        //Bone meal
        if (item.isFertilizer()) {
            int max = getMaxGrowth();
            int growth = getGrowth();
            if (growth < max) {
                BlockCrops block = (BlockCrops) this.clone();
                growth += ThreadLocalRandom.current().nextInt(3) + 2;
                block.setGrowth(Math.min(growth, max));
                BlockGrowEvent ev = new BlockGrowEvent(this, block);
                Server.getInstance().getPluginManager().callEvent(ev);

                if (ev.isCancelled()) {
                    return false;
                }

                this.getLevel().setBlock(this, ev.getNewState(), false, true);
                this.level.addParticle(new BoneMealParticle(this));

                if (player != null && !player.isCreative()) {
                    item.count--;
                }
            }

            return true;
        }

        return false;
    }

    @Override
    public int onUpdate(int type) {
        if (type == Level.BLOCK_UPDATE_NORMAL) {
            if (this.down().getId() != FARMLAND) {
                this.getLevel().useBreakOn(this);
                return Level.BLOCK_UPDATE_NORMAL;
            }
        } else if (type == Level.BLOCK_UPDATE_RANDOM) {
            if (ThreadLocalRandom.current().nextInt(2) == 1 && getLevel().getFullLight(this) >= getMinimumLightLevel()) {
                int growth = getGrowth();
                if (growth < getMaxGrowth()) {
                    BlockCrops block = (BlockCrops) this.clone();
                    block.setGrowth(growth + 1);
                    BlockGrowEvent ev = new BlockGrowEvent(this, block);
                    Server.getInstance().getPluginManager().callEvent(ev);

                    if (!ev.isCancelled()) {
                        this.getLevel().setBlock(this, ev.getNewState(), false, true);
                    } else {
                        return Level.BLOCK_UPDATE_RANDOM;
                    }
                }
            } else {
                return Level.BLOCK_UPDATE_RANDOM;
            }
        }

        return 0;
    }

    @Override
    public boolean isFertilizable() {
        return true;
    }

}
