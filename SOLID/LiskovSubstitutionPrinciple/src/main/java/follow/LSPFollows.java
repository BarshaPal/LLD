package follow;

class Bird
{
    public void eat()
    {
        System.out.println("Bird is eating");
    }

}

class FlyingBird extends Bird
{
    public void fly()
    {
        System.out.println("Bird is flying");
    }
}

class Sparrow extends FlyingBird
{
    public void fly()
    {
        System.out.println("Sparrow is flying");
    }
}




class Ostrich extends Bird
        {
            public void eat()
            {
                System.out.println("Ostrich is eating");
            }
}



public class LSPFollows {
    public static void main(String[] args) {
        Bird ostrich = new Ostrich();
        FlyingBird sparrow = new Sparrow();
        ostrich.eat();
        sparrow.eat();
        sparrow.fly();

    }
}