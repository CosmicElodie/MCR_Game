package GameLogic.Commands.OnLiveReceptors.OnCreature;

import GameLogic.Receptors.Creature;
import GameLogic.Commands.OnLiveReceptors.OnLiveReceptors;
import GameLogic.Commands.CommandName;

public abstract class OnCreature extends OnLiveReceptors {
    public OnCreature(CommandName name) {
        super(name);
    }

    public void setCreatures(Creature[] creatures) {
        setReceptors(creatures);
    }

    public Creature[] getCreatures() {
        if(receptors != null) {
            return (Creature[])receptors;
        }
        return null;
    }
}