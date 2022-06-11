package payments;

// Subclass of Payment specific for debit payments. Class DebitPayment in package payments contains:


import expenses.Expense;

public class DebitPayment extends Payment {

    private static String bank;
    // A private String data field named bank storing the bank name.
//private String bank;

// Methods that set and return the values for each variable.

    public static String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }
    public String getNumber() {
        return Number;
    }
    public void setNumber(String number) {
        this.Number = number;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public String getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
    public double getPaymentAmount() {
        return paymentAmount;
    }
    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    public void setPaymentRefNumber(String paymentRefNumber) {
        super.setPaymentRefNumber(paymentRefNumber);
    }
    public String getPaymentRefNumber() {
        return super.getPaymentRefNumber();
    }

    // A constructor method receiving all the arguments required to create each payment, including the expense object.
public DebitPayment( Expense expense, String bank, String paymentRefNumber, String Name, String Number, String paymentDate, double paymentAmount){
    super(expense, paymentRefNumber, Name, Number, paymentDate, paymentAmount);
    this.bank = bank;
}

// A print method printing the values of all variables. You may add additional printing methods as needed.
public String printMethod() {
    System.out.println("\nExpense Reference Number: " + expense.getExpenseRefNumber());
    System.out.println("Payment Reference Number: " + paymentRefNumber);
    System.out.println("BankName: "+bank);
    System.out.println("Card Name: " + Name);
    System.out.println("Card Number: " + Number);
    System.out.println("Payment Date: " + paymentDate);;
    System.out.println("Payment Amount: " + paymentAmount);
    return null;
}
}


