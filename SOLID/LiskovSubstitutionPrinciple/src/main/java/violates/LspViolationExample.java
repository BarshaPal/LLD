package violates;

// Superclass
class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich can't fly");
    }
}

public class LspViolationExample {
    public static void main(String[] args) {
        Bird bird = new Ostrich();

        // ❌ This will throw runtime exception - LSP violated
        bird.fly();
    }
}
