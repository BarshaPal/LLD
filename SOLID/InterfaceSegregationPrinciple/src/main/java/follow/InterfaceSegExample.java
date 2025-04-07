package follow;

// Define the Bird interface
interface Bird {
    void eat();
}

// Optional Flyable interface for birds that can fly
interface Flyable {
    void fly();
}

// Concrete bird: Sparrow
class Sparrow implements Bird, Flyable {
    public void eat() {
        System.out.println("Sparrow eats");
    }

    public void fly() {
        System.out.println("Sparrow flies");
    }
}

// Concrete bird: Ostrich (doesn’t fly)
class Ostrich implements Bird {
    public void eat() {
        System.out.println("Ostrich eats");
    }
}

// Concrete bird: Eagle
class Eagle implements Bird, Flyable {
    public void eat() {
        System.out.println("Eagle eats");
    }

    public void fly() {
        System.out.println("Eagle soars high");
    }
}

// Bird Processor that uses polymorphism
class BirdProcessor {
    public void processBird(Bird bird) {
        bird.eat();

        if (bird instanceof Flyable) {
            ((Flyable) bird).fly();
        }
    }
}

// Test everything
public class InterfaceSegExample {
    public static void main(String[] args) {
        BirdProcessor processor = new BirdProcessor();

        Bird sparrow = new Sparrow();
        Bird ostrich = new Ostrich();
        Bird eagle = new Eagle();

        processor.processBird(sparrow);
        processor.processBird(ostrich);
        processor.processBird(eagle);
    }
}
