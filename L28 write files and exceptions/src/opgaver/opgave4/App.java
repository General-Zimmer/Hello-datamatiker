package opgaver.opgave4;

import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\krist\\Documents\\GitHub\\Hello-world\\L28 write files and exceptions\\src\\opgaver\\opgave4\\gibNumbers";

        try (PrintWriter write = new PrintWriter(filePath)) {

            Scanner scan = new Scanner(System.in);
            for (int i = scan.nextInt(); i != -1; i = scan.nextInt()) {
                write.print(i + " ");
            }
            write.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
