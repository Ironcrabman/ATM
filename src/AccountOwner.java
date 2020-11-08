public class AccountOwner {

    private String salutation;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private long phoneNumber;
    private MailingAddress mailingAddress;


    public AccountOwner(String salutation, String firstName, String lastName, String emailAddress, long phoneNumber, MailingAddress mailingAddress) {

        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.mailingAddress = mailingAddress;

    }


    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName(int format){
        if (format == 2){
            return(salutation + ". " + lastName);
        }else if (format == 3) {
            return(lastName + ", " + firstName);
        }else {
            return(firstName + " " + lastName);
        }
    }

    public String getEmailAddress(){
        return(emailAddress);
    }

    public String getFormattedPhoneNumber(){
            String temp = Long.toString(phoneNumber);
            return("(" + temp.substring(0,3) + ") " + temp.substring(3, 6) + "-" + temp.substring(6, 10));
        }

    public MailingAddress getMailingAddress() {
        return(mailingAddress);

    }




}