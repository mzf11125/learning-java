package spell;

import java.util.Random;

import main.Enemy;
import main.Game;

public class ThunderBolt extends Spell{

	Random rand = new Random();
	
	public ThunderBolt(int dmg) {
		super(dmg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void castSpell(Enemy e, Game game) {
		// TODO Auto-generated method stub
		int dmgDealt = (int) ((double) (rand.nextDouble() * 1.5 + 0.5) * getDmg());
		e.takeDmg(dmgDealt);
	}

}
