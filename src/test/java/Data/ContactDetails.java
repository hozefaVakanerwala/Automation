package Data;


public class ContactDetails {

    private String forename;
    private String surname;
    private String email;
    private String telephone;
    private String message;

    public ContactDetails() {
        forename = "Nischita";
        surname = "Deepak";
        email = "nischita@gmail.com";
        telephone = "0481312789";
        message = "Please contact me";
    }


    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}