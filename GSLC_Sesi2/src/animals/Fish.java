package animals;

import abilities.Swimmable;
import abilities.Soundable;

public class Fish extends Animal implements Swimmable, Soundable {
    public Fish(String name) {
        super(name);
    }
    
    @Override
    public String makeSound() {
        return "Blub blub!";
    }
    
    @Override
    public String getType() {
        return "Fish";
    }
    
    @Override
    public String swim() {
        return "Swimming in the water!";
    }
}