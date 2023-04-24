package opgaver.first3.exercise1;

public class App {
    public static void main(String[] args) {

        Dog doggy = new Dog(1, "doggy");

        Person human = new Person("human", "112", "12345678");

        doggy.setOwner(human);
        human.setDog(doggy);

        System.out.println("dog\n" + doggy);
        System.out.println("human\n" + human);

    }
}
