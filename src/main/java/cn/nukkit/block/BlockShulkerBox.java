package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.utils.DyeColor;
import org.jetbrains.annotations.NotNull;

/**
 * @author PetteriM1
 */
@PowerNukkitDifference(since = "1.4.0.0-PN", info = "Implements BlockEntityHolder only in PowerNukkit")
public class BlockShulkerBox extends BlockUndyedShulkerBox {


    public static final BlockProperties PROPERTIES = CommonBlockProperties.COLOR_BLOCK_PROPERTIES;

    public BlockShulkerBox() {
        // Does nothing
    }

    public BlockShulkerBox(int meta) {
        if (meta != 0) {
            getMutableState().setDataStorageFromInt(meta, true);
        }
    }


    @NotNull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    @Override
    public int getId() {
        return SHULKER_BOX;
    }

    @Override
    public String getName() {
        return this.getDyeColor().getName() + " Shulker Box";
    }

    public DyeColor getDyeColor() {
        return DyeColor.getByWoolData(this.getDamage());
    }
}
