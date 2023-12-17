package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitXOnly;
import cn.nukkit.api.Since;


public class ItemMournerPotterySherd extends ItemPotterySherd {
    public ItemMournerPotterySherd() {
        this(0, 1);
    }

    public ItemMournerPotterySherd(Integer meta) {
        this(meta, 1);
    }
    public ItemMournerPotterySherd(Integer meta, int count) {
        super(MOURNER_POTTERY_SHERD, meta, count, "Mourner Pottery Sherd");
    }
}
