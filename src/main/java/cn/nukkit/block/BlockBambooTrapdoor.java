package cn.nukkit.block;


public class BlockBambooTrapdoor extends BlockTrapdoor {
    public BlockBambooTrapdoor() {
        this(0);
    }

    public BlockBambooTrapdoor(int meta) {
        super(meta);
    }

    public int getId() {
        return BAMBOO_TRAPDOOR;
    }

    public String getName() {
        return "Bamboo Trapdoor";
    }
}