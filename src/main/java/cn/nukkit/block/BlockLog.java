package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemTool;
import cn.nukkit.math.BlockFace;
import org.jetbrains.annotations.NotNull;

import static cn.nukkit.blockproperty.CommonBlockProperties.PILLAR_AXIS;


public abstract class BlockLog extends BlockSolidMeta implements IBlockWood {


    protected static final BlockProperties PILLAR_PROPERTIES = new BlockProperties(CommonBlockProperties.PILLAR_AXIS);


    protected BlockLog(int meta) {
        super(meta);
    }


    @NotNull
    @Override
    public abstract BlockProperties getProperties();


    public abstract BlockState getStrippedState();


    public BlockFace.Axis getPillarAxis() {
        return getPropertyValue(PILLAR_AXIS);
    }


    public void setPillarAxis(BlockFace.Axis axis) {
        setPropertyValue(PILLAR_AXIS, axis);
    }

    @Override
    public boolean place(@NotNull Item item, @NotNull Block block, @NotNull Block target, @NotNull BlockFace face, double fx, double fy, double fz, Player player) {
        setPillarAxis(face.getAxis());
        getLevel().setBlock(block, this, true, true);
        return true;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }

    @Override
    public boolean onActivate(@NotNull Item item, Player player) {
        if (item.isAxe()) {
            Block strippedBlock = getStrippedState().getBlock(this);
            item.useOn(this);
            this.level.setBlock(this, strippedBlock, true, true);
            return true;
        }
        return false;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_AXE;
    }
}
