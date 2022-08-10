package io.github.mutuba.fireworks.type;

import org.bukkit.entity.Firework;

public class Special extends Base {
    public Special() {
        super();
        bool = false;
    }

    public Special(Firework firework) {
        super(firework);
    }
}
