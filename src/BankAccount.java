public class BankAccount {

    private double balance;
    private AccountOwner accountOwner;
    private long accountNumber;
    private static long counter = 0;

    public BankAccount(AccountOwner accountOwner, double balance){
        this.accountOwner = accountOwner;
        this.balance = balance;
        this.accountNumber = generateAccountNumber();
    }

    public AccountOwner getAccountOwner(){
        return(accountOwner);
    }

    public String getMaskedAccountNumber(){
        String temp = Long.toString(accountNumber);
        temp = temp.substring(Math.max(0,temp.length()-4), temp.length());
        return "****" + String.format("%04d", Integer.parseInt(temp));
    }

    public long getAccountNumber(){
        return(accountNumber);
    }

    public String getFormattedBalance(){
        return("$" + String.format("%,.2f", balance));
    }

    public int deposit(double amount){
        if(amount <= 0){
            return(2);
        }else{
            balance += amount;
            return(1);
        }
    }

    public int withdraw(double amount){
        if(amount <= 0){
            return(2);
        }else if (amount > balance){
            return(3);
        }else{
            balance -= amount;
            return(1);
        }
    }

    public int transfer(long account, double amount){

        if(amount <= 0){
            return(2);
        }else if(amount > balance){
            return(3);
        }else if (ATM.lookup(account) == null){
            return(4);
        }else{
            balance -= amount;
            ATM.lookup(account).balance += amount;
            return(1);
        }
    }


    private long generateAccountNumber() {
        return(counter++);
    }

}
