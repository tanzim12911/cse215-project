public class Client {
    private String name;
    private int phoneNum;
    private String pin;
    private double balance;
    
    public Client(String name, int phoneNum, String pin, double balance) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.pin = pin;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Client [name=" + name + ", phoneNum=" + phoneNum + ", pin=" + pin + ", balance=" + balance + "]";
    }
}
