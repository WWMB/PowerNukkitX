package cn.nukkit.item;


public class ItemExplorerPotterySherd extends ItemPotterySherd {
    public ItemExplorerPotterySherd() {
        this(0, 1);
    }

    public ItemExplorerPotterySherd(Integer meta) {
        this(meta, 1);
    }
    public ItemExplorerPotterySherd(Integer meta, int count) {
        super(EXPLORER_POTTERY_SHERD, meta, count, "Explorer Pottery Sherd");
    }
}
