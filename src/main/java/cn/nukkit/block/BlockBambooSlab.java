package cn.nukkit.block;

import cn.nukkit.item.ItemTool;


public class BlockBambooSlab extends BlockSlab {
    public BlockBambooSlab() {
        this(0);
    }

    public BlockBambooSlab(int meta) {
        super(meta, BAMBOO_DOUBLE_SLAB);
    }

    public int getId() {
        return BAMBOO_SLAB;
    }

    @Override
    public String getSlabName() {
        return "Bamboo";
    }

    @Override
    public boolean isSameType(BlockSlab slab) {
        return slab.getId() == getId();
    }

    @Override
    public double getHardness() {
        return 2;
    }

    @Override
    public double getResistance() {
        return 15;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_AXE;
    }
}