package animals;
import abilities.Soundable;

public class Lion extends Animal implements Soundable {
    public Lion(String name) {
        super(name);
    }
    
    @Override
    public String makeSound() {
        return "Roar!";
    }
    
    @Override
    public String getType() {
        return "Lion";
    }
}
