package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitXOnly;
import cn.nukkit.api.Since;


public class ItemAnglerPotterySherd extends ItemPotterySherd {
    public ItemAnglerPotterySherd() {
        this(0, 1);
    }

    public ItemAnglerPotterySherd(Integer meta) {
        this(meta, 1);
    }
    public ItemAnglerPotterySherd(Integer meta, int count) {
        super(ANGLER_POTTERY_SHERD, meta, count, "Angler Pottery Sherd");
    }
}
