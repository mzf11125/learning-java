package spell;

import main.Enemy;

public interface DamageOverTime {
	void applyDamageOverTime(Enemy e);
	
	int getDuration();
}
