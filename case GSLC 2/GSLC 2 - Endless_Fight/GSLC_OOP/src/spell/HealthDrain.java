package spell;

import main.Enemy;
import main.Game;

public class HealthDrain extends Spell{

	public HealthDrain(int dmg) {
		super(dmg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void castSpell(Enemy e, Game game) {
		// TODO Auto-generated method stub
		e.takeDmg(getDmg());
		game.heal(getDmg() * 3);
	}

}
