package opgaver.opgave1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\krist\\Documents\\GitHub\\Hello-world\\L28 write files and exceptions\\src\\opgaver\\opgave1\\numbahs";
        File file = new File(filePath);
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextInt())
                System.out.println(scan.nextInt());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
