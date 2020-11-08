public class MailingAddress {

    private String primaryStreet;
    private String secondaryStreet;
    private String city;
    private String state;
    private String postalCode;

    private final String[] statesName = {"Alaska", "Alabama", "Arkansas", "Arizona", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Iowa", "Idaho", "Illinois", "Indiana", "Kansas", "Kentucky", "Louisiana", "Massachusetts", "Maryland", "Maine", "Michigan", "Minnesota", "Missouri", "Mississippi", "Montana", "North Carolina", "North Dakota", "Nebraska", "New Hampshire", "New Jersey", "New Mexico", "Nevada", "New York", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Virginia", "Virgin Islands", "Vermont", "Washington", "Wisconsin", "West Virginia", "Wyoming"};
    private final String[] statesAbbreviation = { "AK", "AL", "AR",  "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VI", "VT", "WA", "WI", "WV", "WY"};


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

    public String getPrimaryStreet(){
        return(this.primaryStreet);
    }

    public void setSecondaryStreet(String secondaryStreet) {
        this.secondaryStreet = secondaryStreet;
    }

    public String getSecondaryStreet(){
        return(this.secondaryStreet);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity(){
        return(this.city);
    }

    public void setState(String state) {
        String temp = state.substring(0,1);
        state.substring(state.indexOf(" "), state.indexOf(" ") + 1);

        this.state = state;
    }

    public String getState(){
        return(this.state);
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode(){
        return(this.postalCode);
    }


    public String getFormattedAddress() {
        if(validateStreet(this.primaryStreet) == null || validateCity(this.city) == null || validateState(this.state) == null || validatePostalCode(this.postalCode) == null) {
            return("N/A");
        }else{
            if (secondaryStreet == null) {
                return (primaryStreet + "\n" + city + ", " + state + postalCode);
            }else{
                return (primaryStreet + "\n" + secondaryStreet + "\n" + city + ", " + state + " " + postalCode);
            }
        }
    }


    public String validateStreet(String primaryStreet){
       if(primaryStreet.length() > 0){
           return(primaryStreet);
       }else{
           return(null);
       }
    }

    public String validateCity(String city){
        if(city.length() > 0){
            return(city);
        }else{
            return(null);
        }
    }

    public String validateState(String state){
        if(state.length() > 0){
            for(int i=0; statesAbbreviation.length > i; i++){
                if(state.equals(statesAbbreviation[i]) || state.equals(statesName[i])){
                    this.state = statesAbbreviation[i];
                    return(statesAbbreviation[i]);
                }
            }
        }
            return(null);
        }

    public String validatePostalCode(String postalCode){
            if(postalCode == null || postalCode.equals("")) {
                return (null);
            }else{
                for(int i = 0; i < postalCode.length(); i++) {
                    if (postalCode.charAt(i) < 48 || postalCode.charAt(i) > 57) {
                        return (null);
                    }
                }
            }
            return(postalCode);
        }




    }




