package spell;

import main.Enemy;
import main.Game;

public class PoisonMist extends Spell implements DamageOverTime{
	private int duration;
	private int tickDmg;
	
	public PoisonMist(int dmg, int duration, int tickDmg) {
		super(dmg);
		this.duration = duration;
		this.tickDmg = tickDmg;
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
	
	@Override
	public void applyDamageOverTime(Enemy e) {
		// TODO Auto-generated method stub
		e.takeDmg(tickDmg);
		this.duration--;
	}
	@Override
	public void castSpell(Enemy e, Game game) {
		// TODO Auto-generated method stub
		e.takeDmg(getDmg());
		System.out.println("Poison has been applied for 4 turns");
		e.setDot(this);
	}
	
	
}
