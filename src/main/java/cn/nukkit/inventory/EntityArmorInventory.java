package cn.nukkit.inventory;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.Entity;
import cn.nukkit.item.Item;
import cn.nukkit.network.protocol.InventoryContentPacket;
import cn.nukkit.network.protocol.InventorySlotPacket;
import cn.nukkit.network.protocol.MobArmorEquipmentPacket;

import java.util.HashSet;
import java.util.Set;


public class EntityArmorInventory extends BaseInventory {

    private final Entity entity;


    /**
     * @param entity an Entity which implements {@link InventoryHolder}.
     * @throws ClassCastException if the entity does not implements {@link InventoryHolder}
     */


    public EntityArmorInventory(Entity entity) {
        super((InventoryHolder) entity, InventoryType.ENTITY_ARMOR);
        this.entity = entity;
    }


    public Entity getEntity() {
        return entity;
    }

    @Override
    public InventoryHolder getHolder() {
        return this.holder;
    }

    @Override
    public String getName() {
        return "Entity Armor";
    }

    @Override
    public int getSize() {
        return 4;
    }


    public Item getHelmet(){
        return this.getItem(SLOT_HEAD);
    }


    public Item getChestplate(){
        return this.getItem(SLOT_CHEST);
    }


    public Item getLeggings(){
        return this.getItem(SLOT_LEGS);
    }


    public Item getBoots(){
        return this.getItem(SLOT_FEET);
    }


    @PowerNukkitDifference(info = "now this method will return an Boolean",since = "1.6.0.0-PNX")
    public boolean setHelmet(Item item) {
        return this.setItem(SLOT_HEAD, item);
    }


    @PowerNukkitDifference(info = "now this method will return an Boolean",since = "1.6.0.0-PNX")
    public boolean setChestplate(Item item) {
        return this.setItem(SLOT_CHEST, item);
    }


    @PowerNukkitDifference(info = "now this method will return an Boolean",since = "1.6.0.0-PNX")
    public boolean setLeggings(Item item) {
        return this.setItem(SLOT_LEGS, item);
    }


    @PowerNukkitDifference(info = "now this method will return an Boolean",since = "1.6.0.0-PNX")
    public boolean setBoots(Item item) {
        return  this.setItem(SLOT_FEET, item);
    }

    @Override
    public void sendSlot(int index, Player... players) {
        for (Player player : players) {
            this.sendSlot(index, player);
        }
    }

    @Override
    public void sendSlot(int index, Player player) {
        MobArmorEquipmentPacket mobArmorEquipmentPacket = new MobArmorEquipmentPacket();
        mobArmorEquipmentPacket.eid = this.entity.getId();
        mobArmorEquipmentPacket.slots = new Item[]{this.getHelmet(), this.getChestplate(), this.getLeggings(), this.getBoots()};

        if (player == this.holder) {
            InventorySlotPacket inventorySlotPacket = new InventorySlotPacket();
            inventorySlotPacket.inventoryId = player.getWindowId(this);
            inventorySlotPacket.slot = index;
            inventorySlotPacket.item = this.getItem(index);
            player.dataPacket(inventorySlotPacket);
        } else {
            player.dataPacket(mobArmorEquipmentPacket);
        }
    }

    @Override
    public void sendContents(Player... players) {
        for (Player player : players) {
            this.sendContents(player);
        }
    }

    @Override
    public void sendContents(Player player) {
        MobArmorEquipmentPacket mobArmorEquipmentPacket = new MobArmorEquipmentPacket();
        mobArmorEquipmentPacket.eid = this.entity.getId();
        mobArmorEquipmentPacket.slots = new Item[]{this.getHelmet(), this.getChestplate(), this.getLeggings(), this.getBoots()};

        if (player == this.holder) {
            InventoryContentPacket inventoryContentPacket = new InventoryContentPacket();
            inventoryContentPacket.inventoryId = player.getWindowId(this);
            inventoryContentPacket.slots = new Item[]{this.getHelmet(), this.getChestplate(), this.getLeggings(), this.getBoots()};
            player.dataPacket(inventoryContentPacket);
        } else {
            player.dataPacket(mobArmorEquipmentPacket);
        }
    }

    @Override
    public void onOpen(Player who) {
        this.viewers.add(who);
    }

    @Override
    public void onClose(Player who) {
        this.viewers.remove(who);
    }

    @Override
    public Set<Player> getViewers() {
        Set<Player> viewers = new HashSet<>(this.viewers);
        viewers.addAll(entity.getViewers().values());
        return viewers;
    }
}
