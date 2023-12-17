package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.value.WoodType;
import cn.nukkit.item.ItemTool;
import org.jetbrains.annotations.NotNull;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class BlockPlanks extends BlockSolidMeta {
    public static final int OAK = 0;
    public static final int SPRUCE = 1;
    public static final int BIRCH = 2;
    public static final int JUNGLE = 3;
    public static final int ACACIA = 4;
    public static final int DARK_OAK = 5;


    public static final BlockProperties PROPERTIES = new BlockProperties(WoodType.PROPERTY);


    public BlockPlanks() {
        this(0);
    }

    public BlockPlanks(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return PLANKS;
    }


    @NotNull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
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
    public int getBurnChance() {
        return 5;
    }

    @Override
    public int getBurnAbility() {
        return 20;
    }

    @Override
    public String getName() {
        return getWoodType().getEnglishName()+" Wood Planks";
    }


    public WoodType getWoodType() {
        return getPropertyValue(WoodType.PROPERTY);
    }


    public void setWoodType(WoodType type) {
        setPropertyValue(WoodType.PROPERTY, type);
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_AXE;
    }

}
