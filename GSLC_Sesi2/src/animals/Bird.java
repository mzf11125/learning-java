package animals;

import abilities.Flyable;
import abilities.Soundable;

public class Bird extends Animal implements Flyable, Soundable {
    public Bird(String name) {
        super(name);
    }
    
    @Override
    public String makeSound() {
        return "Chirp chirp!";
    }
    
    @Override
    public String getType() {
        return "Bird";
    }
    
    @Override
    public String fly() {
        return "Flying high in the sky!";
    }
}