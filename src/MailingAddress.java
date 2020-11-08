public class MailingAddress {

    private String primaryStreet;
    private String secondaryStreet;
    private String city;
    private String state;
    private String postalCode;

    public MailingAddress(String primaryStreet, String secondaryStreet, String city, String state, String postalCode){

        this.primaryStreet = primaryStreet;
        this.secondaryStreet = secondaryStreet;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;

    }


    public void setPrimaryStreet(String primaryStreet) {
        this.primaryStreet = primaryStreet;
    }

    public void setSecondaryStreet(String secondaryStreet) {
        this.secondaryStreet = secondaryStreet;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFormattedAddress(){
        if(secondaryStreet == null){
            return (primaryStreet + "\n" + city + ", " + state + postalCode);
        }else {
            return (primaryStreet + "\n" + secondaryStreet + "\n" + city + ", " + state + " " + postalCode);
        }
    }




}




