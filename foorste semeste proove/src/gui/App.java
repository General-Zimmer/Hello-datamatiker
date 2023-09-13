package gui;

import controller.Controller;
import model.Bane;
import model.Kategori;
import model.Spiller;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {

        initStorage();

        String filePath = "C:\\Users\\krist\\Documents\\GitHub\\Hello-datamatiker\\foorste semeste proove\\src\\ektra\\alleBookings";

        Controller.alleBookings(filePath);


        Gui.launch(Gui.class);

    }

    public static void initStorage() {
        Kategori luksus = Controller.createKategori("Luksus", 100, 200);
        Kategori mellem = Controller.createKategori("Mellem", 50, 100);
        Kategori begynder = Controller.createKategori("Begynder", 25, 50);


        LocalTime førsteTid = LocalTime.of(9, 0, 0);
        LocalTime sidsteTid = LocalTime.of(17, 0, 0);


        Bane et = Controller.createBane(luksus, 1, true, førsteTid, sidsteTid);
        Bane to = Controller.createBane(luksus, 2, true, førsteTid, sidsteTid);
        Bane tre = Controller.createBane(mellem, 3, true, førsteTid, sidsteTid);
        Bane fier = Controller.createBane(mellem, 4, false, førsteTid, sidsteTid);
        Bane fem = Controller.createBane(begynder, 5, false, førsteTid, sidsteTid);
        Bane seks = Controller.createBane(begynder, 6, false, førsteTid, sidsteTid);


        Spiller andreas = Controller.createSpiller("Andreas", "DMU");
        Spiller Petra = Controller.createSpiller("Petra", "DMU");
        Spiller Henrik = Controller.createSpiller("Henrik", "ITA");
        Spiller Ulla = Controller.createSpiller("Ulla", "ITA");

        Controller.createBooking(andreas,
                LocalDate.of(2023, 6, 20),
                LocalTime.of(10, 0 , 0),
                true, tre);
        Controller.createBooking(andreas,
                LocalDate.of(2023, 6, 22),
                LocalTime.of(10, 0 , 0),
                false, to);
        Controller.createBooking(Henrik,
                LocalDate.of(2023, 6, 23),
                LocalTime.of(11, 0 , 0),
                false, tre);
        Controller.createBooking(Ulla,
                LocalDate.of(2023, 6, 23),
                LocalTime.of(16, 0 , 0),
                false, tre);
        Controller.createBooking(andreas,
                LocalDate.of(2023, 6, 23),
                LocalTime.of(17, 0 , 0),
                true, fem);
    }
}
