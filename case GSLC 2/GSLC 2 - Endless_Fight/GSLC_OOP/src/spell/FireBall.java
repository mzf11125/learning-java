package spell;

import main.Enemy;
import main.Game;

public class FireBall extends Spell implements DamageOverTime{

	private int duration;
	private int tickDmg;
	

	public FireBall(int dmg, int duration, int tickDmg) {
		super(dmg);
		this.duration = duration;
		this.tickDmg = tickDmg;
	}

	@Override
	public void castSpell(Enemy e, Game game) {
		// TODO Auto-generated method stub
		e.takeDmg(getDmg());
		System.out.println("Burn has been applied for 2 turns");
		e.setDot(this);
	}

	@Override
	public void applyDamageOverTime(Enemy e) {
		// TODO Auto-generated method stub
		e.takeDmg(tickDmg);
		this.duration--;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getTickDmg() {
		return tickDmg;
	}

	public void setTickDmg(int tickDmg) {
		this.tickDmg = tickDmg;
	}
}
