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

    public String getSalutation(){
        return(this.salutation);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName(){
        return(this.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName(){
        return(this.lastName);
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress(){
        return(this.emailAddress);
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getPhoneNumber(){
        return(phoneNumber);
    }


    public String getName(int format){
        if (format == 2){
            if(salutation == null) {
                return(firstName + " " + lastName);
            }else{
                return (salutation + ". " + lastName);
            }
        }else if (format == 3) {
            return(lastName + ", " + firstName);
        }else {
            return(firstName + " " + lastName);
        }
    }

    public String getFormattedPhoneNumber(){
            String temp = Long.toString(phoneNumber);
            return("(" + temp.substring(0,3) + ") " + temp.substring(3, 6) + "-" + temp.substring(6, 10));
        }

    public MailingAddress getMailingAddress() {
        return(mailingAddress);
    }

    public void setMailingAddress(MailingAddress mailingAddress){
        this.mailingAddress = mailingAddress;
    }

    public String validateSalutation(String salutation){
        if(salutation.length() > 0){
            return(salutation);
        }else{
            return(null);
        }
    }

    public long validatePhoneNumber(long phoneNumber){
        if(Long.toString(phoneNumber).length() < 0) {
            return (0L);
        }else{
            for(int i = 0; i < Long.toString(phoneNumber).length(); i++) {
                if (Long.toString(phoneNumber).charAt(i) < 48 || Long.toString(phoneNumber).charAt(i) > 57) {
                    return (0L);
                }
            }
        }
        return(phoneNumber);
    }

    public String validateEmailAddress(String emailAddress) {
        if(emailAddress.length() < 7 || emailAddress.length() > 254){
            return(null);
        }
        String[] p1 = emailAddress.split("@");
        if(p1.length != 2){
            return (null);
        }
        String[] p2 = p1[1].split(".");
        if(p2.length != 2 || p2[1].length() != 3) {
            return(null);
        }
        return(emailAddress);
    }
}