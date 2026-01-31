package net.goldtreeservers.worldguardextraflags.flags.helpers;

import com.sk89q.worldguard.protection.flags.FlagContext;
import com.sk89q.worldguard.protection.flags.InvalidFlagFormat;
import com.sk89q.worldguard.protection.flags.StateFlag;

public class BooleanStateFlag extends StateFlag {

    public BooleanStateFlag(String name, boolean defaultState) {
        super(name, defaultState);
    }

    @Override
    public State parseInput(FlagContext context) throws InvalidFlagFormat {
        String input = context.getUserInput();

        if (input.equalsIgnoreCase("true")) {
            return State.ALLOW;
        } else if (input.equalsIgnoreCase("false")) {
            return State.DENY;
        }

        return super.parseInput(context);
    }

    @Override
    public State unmarshal(Object object) {
        if (object instanceof Boolean) {
            return (Boolean) object ? State.ALLOW : State.DENY;
        }

        if (object instanceof String) {
            String str = (String) object;
            if (str.equalsIgnoreCase("true")) {
                return State.ALLOW;
            } else if (str.equalsIgnoreCase("false")) {
                return State.DENY;
            }
        }

        return super.unmarshal(object);
    }
}
