package opgaver.architecture.gui;

import opgaver.architecture.controller.Controller;
import javafx.application.Application;
import opgaver.architecture.model.Company;
import opgaver.architecture.model.Employee;

public class ArchitectureApp {

    public static void main(String[] args) {
        initStorage();
        Application.launch(ArchitectureGui.class);
    }

    public static void initStorage() {
        Company ibm = Controller.createCompany("IBM", 37);
        Company amd = Controller.createCompany("AMD", 40);
        Company sled = Controller.createCompany("SLED", 45);
        Controller.createCompany("Vector", 32);

        Employee bob = Controller.createEmployee("Bob Dole", 210, 8103);
        Controller.addEmployeeToCompany(bob, ibm);

        Employee alice = Controller.createEmployee("Alice Schmidt", 250, 1356);
        Controller.addEmployeeToCompany(alice, ibm);

        Employee george = Controller.createEmployee("George Down", 150, 7432);
        Controller.addEmployeeToCompany(george, amd);

        Employee rita = Controller.createEmployee("Rita Uphill", 300, 111);
        Controller.addEmployeeToCompany(rita, sled);

        Controller.createEmployee("John Doe", 100, 875);
    }
}
