package GameLogic.Receptors;

import GameLogic.Commands.ConcreteCommand;
import GameLogic.Commands.OnLiveReceptors.OnLiveReceptors;
import GameLogic.Board.Position;
import GameLogic.Commands.Macro;

/**
 * Modelizes a trap in the game
 */
public class Trap extends Receptor {
    private Macro effect;           // the effect the trap has on the first creature that lands on it
    private Position position;      // the position at which the trap is

    /**
     * Creates the trap with the given name and effect
     * @param name the name of the trap
     * @param effect teh effect the trap has
     */
    public Trap(String name, Macro effect) {
        super("Trap " + name);
        this.effect = effect;
    }

    public Macro getEffect() {
        return effect;
    }

    /**
     * Triggers the trap on the given victim
     */
    public void trigger(Creature creature) {
        setVictim(creature);
        effect.execute();
        if (position != null)
            position.leave();
        position = null;
    }

    /**
     * Sets the position of the trap which places it on the game board
     * @param position the position of the trap on the board
     */
    public void setPosition(Position position) {
        if (position != null)
            position.setOccupant(this);
        this.position = position;
    }

    @Override
    public void playTurn(int turn) {}

    public Position getPosition() {
        return position;
    }

    private void setVictim(Creature creature) {
        for (ConcreteCommand c :
                effect.getCommands()) {
            ((OnLiveReceptors)c).setReceptors(new LiveReceptor[]{creature});
        }
    }
}
