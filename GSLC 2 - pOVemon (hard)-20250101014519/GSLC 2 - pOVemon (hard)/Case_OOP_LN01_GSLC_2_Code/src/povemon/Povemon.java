package povemon;

import interfaces.AdditionalPovemonInfo;
import interfaces.Burnable;
import interfaces.Poisonable;
import interfaces.Utility;
import main.Main;
import person.Entity;

public abstract class Povemon extends Entity implements AdditionalPovemonInfo, Utility{
	private Integer currHp;
	private Integer hp;
	private Integer defense;
	private Integer speed;
	private Integer attack;
	private String type;
	private String weakness;
	private Boolean isAlive;
	private Integer price;
	
	private boolean isBurned;
    private boolean isPoisoned;
	
	public Povemon(String name, Integer hp, Integer attack, Integer defense, Integer speed, String type, Integer price) {
		super(name);
		this.hp = hp;
		this.defense = defense;
		this.speed = speed;
		this.attack = attack;
		this.currHp = hp;
		this.type = type;
		this.isAlive = true;
		this.price = price;
		this.isBurned = false;
		this.isPoisoned = false;
	}

	public Integer getCurrHp() {
		return currHp;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setCurrHp(Integer currHp) {
		this.currHp = currHp;
	}

	public Integer getHp() {
		return hp;
	}
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	
	public String getType() {
		return type;
	}

	public Boolean getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDefense(Integer defense) {
		this.defense = defense;
	}
	public Integer getDefense() {
		return defense;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer agility) {
		this.speed = agility;
	}
	public Integer getAttack() {
		return attack;
	}
	public boolean isBurned() {
		return isBurned;
	}

	public void setBurned(boolean isBurned) {
		this.isBurned = isBurned;
	}

	public boolean isPoisoned() {
		return isPoisoned;
	}

	public void setPoisoned(boolean isPoisoned) {
		this.isPoisoned = isPoisoned;
	}

	public void setAttack(Integer attack) {
		this.attack = attack;
	}
	
	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}
	
	private void checkAlive() {
        if (this.currHp <= 0) {
            this.currHp = 0;
            this.isAlive = false;
            System.out.println(" " + this.getName() + " has fainted!");
            Main.pressEnter();
        }
    }

    public void damaged(int attackDamage) {
        int damageTaken = Math.max(attackDamage - this.defense, 0);
        this.currHp = Math.max(this.currHp - damageTaken, 0);
        System.out.printf(" %s took %d damage!\n", this.getName(), damageTaken);
        checkAlive();
    }

    public void damaged(String status, int statusDamage) {
        this.currHp = Math.max(this.currHp - statusDamage, 0);
        System.out.printf(" %s is %s and took extra %d damage!\n", this.getName(), status, statusDamage);
        checkAlive();
    }

    public void takeStatusEffectDamage() {
        if (isBurned) {
            this.damaged("burned", 5 * 2);
        }
        if (isPoisoned) {
            this.damaged("poisoned", 5);
        }
    }

    public void performTurn() {
        if (!this.isAlive) return;
        takeStatusEffectDamage();
    }

    public void attack(Povemon target) {
        if (!this.isAlive) return;

        int damage = calculateDamage(target);
        target.damaged(damage);

        if (this.type.equals(GRASS) && target instanceof Poisonable) {
            Poisonable poisonableTarget = (Poisonable) target;
            if (Math.random() < 0.3) { 
                poisonableTarget.poisoned(true);
            }
        } 
        else if (this.type.equals(FIRE) && target instanceof Burnable) {
            Burnable burnableTarget = (Burnable) target;
            if (Math.random() < 0.5) {
                burnableTarget.burned(true);
            }
        }
    }

    private int calculateDamage(Povemon target) {
	    int damage = this.attack;

	    if (target.getType().equals(this.weakness)) {
	    	damage /= 2;
	    } 
	    else if (target.getWeakness().equals(this.type)) {
	    	damage *= 2; 
	    }

	    return damage;
    }

    public static Povemon createPovemon(String name) {
        int index = -1;
        for (int i = 0; i < AdditionalPovemonInfo.povemonNameList.length; i++) {
            if (AdditionalPovemonInfo.povemonNameList[i].equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }

        if (index == -1) return null;

        String type = AdditionalPovemonInfo.povemonTypeList[index];
        Integer hp = AdditionalPovemonInfo.povemonStatList[index][0];
        Integer attack = AdditionalPovemonInfo.povemonStatList[index][1];
        Integer defense = AdditionalPovemonInfo.povemonStatList[index][2];
        Integer speed = AdditionalPovemonInfo.povemonStatList[index][3];
        Integer price = AdditionalPovemonInfo.povemonPriceList[index];

        switch (type) {
            case FIRE: 
            	return new FireType(name, hp, attack, defense, speed, type, price);
            case WATER: 
            	return new WaterType(name, hp, attack, defense, speed, type, price);
            case GRASS: 
            	return new GrassType(name, hp, attack, defense, speed, type, price);
            default: 
            	return null;
        }
    }
}