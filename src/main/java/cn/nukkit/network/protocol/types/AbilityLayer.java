package cn.nukkit.network.protocol.types;

import cn.nukkit.api.PowerNukkitXOnly;
import cn.nukkit.api.Since;
import lombok.Data;

import java.util.EnumSet;
import java.util.Set;


@Data
public class AbilityLayer {
    private Type layerType;
    private final Set<PlayerAbility> abilitiesSet = EnumSet.noneOf(PlayerAbility.class);
    private final Set<PlayerAbility> abilityValues = EnumSet.noneOf(PlayerAbility.class);
    private float flySpeed;
    private float walkSpeed;

    public enum Type {
        CACHE,
        BASE,
        SPECTATOR,
        COMMANDS,
        EDITOR
    }
}
