package version4;

public class Name {
    private String firstname;
    private String middlename;
    private String lastname;

    public Name() {
        this.firstname = "N/A";
        this.middlename = "";
        this.lastname = "N/A";
    }

    public Name(String firstname, String lastname) {
        this.firstname = firstname;
        this.middlename = "";
        this.lastname = lastname;
    }

    public Name(String firstname, String middlename, String lastname) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public static void setLastname(Name name, String lastname) {
        name.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        if (middlename == null || middlename.isEmpty()) {
            return firstname + " " + lastname;
        }
        return firstname + " " + middlename + " " + lastname;
    }
}