package opgaver;

public class L01OpgaveE14 {
    public static void main(String[] args) {

        double start = 1000;
        double rente = 0.05;


        double newyear;
        double oldyear = start*(rente+1);

        System.out.println("Year 1: " + oldyear);

        for (int i = 0; i < 4; i++) {
            newyear = oldyear*(1+rente);
            System.out.println("Year "+ (i+2) +": "+newyear);
            oldyear = newyear;
        }
    }
}
