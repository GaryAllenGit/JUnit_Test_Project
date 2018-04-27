class Account {

    private double balance;

    public Account(){
        balance = 0;
    }

    public Account(double initBalance){
        balance = initBalance;
    }

    public double getBalance(){
        return balance;
    }

    public void credit(double amount){
        balance += amount;
    }

    public void debit(double amount) throws Overdrawn{
        if (balance - amount < 0)
            throw new Overdrawn();
        else
            balance -= amount;
    }
}