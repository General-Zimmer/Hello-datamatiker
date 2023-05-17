package opgaver.exercise4;

public class Program {
    public static void main(String[] args) {
        Name name1 = new Name("Simon", "Zimmermann");
        Name name2 = new Name("Margrethe", "Mosbæk", "Dybdahl");


        System.out.println(name1.getFullName());
        System.out.println(name2.getFullName());
        System.out.println();

        System.out.println(name1.getUsername());
        System.out.println(name2.getUsername());
        System.out.println();

        System.out.println(name1.getInits());
        System.out.println(name2.getInits());
        System.out.println();

        System.out.println(name1.getCryptoInits());
        System.out.println(name2.getCryptoInits());
    }
}
