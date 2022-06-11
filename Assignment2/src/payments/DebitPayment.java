package payments;

// Subclass of Payment specific for debit payments. Class DebitPayment in package payments contains:


import expenses.Expense;

public class DebitPayment extends Payment {

    // A private String data field named bank storing the bank name.
private String bank;

// Methods that set and return the values for each variable.

    public String getBank() {
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

    @Override
    public void printPa() {

    }


    public String getPaymentRefNumber() {
        return super.getPaymentRefNumber();
    }

    public String getExpenseRefNumber() {return super.getExpenseRefNumber();}

    // A constructor method receiving all the arguments required to create each payment, including the expense object.
public DebitPayment(Expense expense, String bank, String Name, String Number, String paymentDate, double paymentAmount, String paymentRefNumber, String eNumber){
    super(Name, Number, paymentDate, paymentAmount, paymentRefNumber, eNumber);
    this.bank = bank;
    this.Name = Name;
    this.Number = Number;
    this.paymentAmount = expense.getPaymentAmount();
    this.paymentDate = expense.getPaymentDate();
    this.paymentRefNumber = paymentRefNumber;
}
// A print method printing the values of all variables. You may add additional printing methods as needed.

    public String printMethod() {
         return "Expense Reference Number: " + getExpenseRefNumber() + "\nPayment  Reference Number: " + getPaymentRefNumber() + "\nBankName: " + getBank() + "\nCard Name: " + getName() + "\nCard Number: " + getNumber() + "\nPayment Date: " + getPaymentDate()
                + "\nPayment Amount: " + getPaymentAmount()
                + "\n";

    }
}
