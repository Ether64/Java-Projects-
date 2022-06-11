package payments;

// Subclass of Payment specific for credit payments. Class CreditPayment in package payments contains:


import expenses.*;

public class CreditPayment extends Payment{

    //A private String data field named card storing the credit card name.
private String card;


//Methods that set and return the values for each variable.

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
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


    public String getPaymentRefNumber() {
        return super.getPaymentRefNumber();
    }


    public void setPaymentRefNumber(String paymentRefNumber) {
        super.setPaymentRefNumber(paymentRefNumber);
    }

    public String getExpenseRefNumber() {return super.getExpenseRefNumber();}



    @Override
    public void printPa() {

    }

    // A constructor method receiving all the arguments required to create each payment, including the expense object.
public CreditPayment(Expense expense, String card, String Name,  String Number, String paymentDate, double paymentAmount, String paymentRefNumber, String eNumber) {
   super(Name, Number, paymentDate, paymentAmount, paymentRefNumber, eNumber);
    this.card = card;
    this.Name = Name;
    this.Number = Number;
    this.paymentDate = paymentDate;
    this.paymentAmount = expense.getPaymentAmount();
    this.paymentDate = expense.getPaymentDate();
    this.paymentRefNumber = paymentRefNumber;
}
// A print method printing the values of all variables. You may add additional printing methods as needed.

    public String printMethod() {
        return  "Expense Reference Number: " + getExpenseRefNumber() + "\nPayment  Reference Number: " + getPaymentRefNumber() +"\nCreditCard: " + card + "\nCard Name: " + Name + "\nCard Number: " + Number + "\nPayment Date: " + paymentDate
                + "\nPayment Amount: " + paymentAmount
                + "\n";
    }
}
