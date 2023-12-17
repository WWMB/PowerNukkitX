package cn.nukkit.block;


public class BlockBambooPressurePlate extends BlockPressurePlateWood {
    public BlockBambooPressurePlate(int meta) {
        super(meta);
    }

    public BlockBambooPressurePlate() {
        this(0);
    }

    public int getId() {
        return BAMBOO_PRESSURE_PLATE;
    }

    public String getName() {
        return "Bamboo Pressure Plate";
    }
}