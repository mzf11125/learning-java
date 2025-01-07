package spell;

import main.Enemy;
import main.Game;

public abstract class Spell {

	private String name;
	private int dmg;
	
	public Spell(int dmg) {
		this.name = this.getClass().getSimpleName();
        this.dmg = dmg;
    }

    public String getName() {
        return name;
    }

    public int getDmg() {
        return dmg;
    }

    // Abstract method to cast the spell
    public abstract void castSpell(Enemy e, Game game);

}
