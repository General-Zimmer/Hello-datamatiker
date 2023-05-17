package opgaver.exercise4;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;



    public Name(String firstName, String middleName, String Lastname) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = Lastname;
    }

    public Name(String firstName, String Lastname) {
        this(firstName, null, Lastname);
    }


    public String getFullName() {
        if (middleName != null)
            return firstName + " " + middleName + " " + lastName;
        return firstName + " " + lastName;

    }

    public String getUsername() {
        String middlepart = "";
        if (middleName != null)
            middlepart = Integer.toString(middleName.length());

        return firstName.substring(0, 2).toUpperCase() + middlepart + lastName.substring(0, 2).toLowerCase();
    }

    public String getInits() {
        String middlepart = "";
        if (middleName != null)
            middlepart = middleName.substring(0, 1);

        return firstName.charAt(0) + middlepart + lastName.charAt(0);
    }

    public String getCryptoInits() {
        String inits = getInits();
        StringBuilder result = new StringBuilder();
        for (char cha : inits.toCharArray()) {

            //todo Should also work with any int lower than 27
            if ("y".equalsIgnoreCase(String.valueOf(cha))) {
                result.append("A");
            }
            else if ("z".equalsIgnoreCase(String.valueOf(cha)))
                result.append("B");
            else {
                cha += 2;
                result.append(cha);
            }



        }
        return result.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
