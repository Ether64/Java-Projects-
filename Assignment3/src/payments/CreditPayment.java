package payments;

// Subclass of Payment specific for credit payments. Class CreditPayment in package payments contains:


import expenses.Expense;

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




    // A constructor method receiving all the arguments required to create each payment, including the expense object.
public CreditPayment(Expense expense, String card,String paymentRefNumber, String Name,  String Number, String paymentDate, double paymentAmount) {
   super(expense, paymentRefNumber, Name, Number, paymentDate,  paymentAmount);
    this.card = card;
}


// A print method printing the values of all variables. You may add additional printing methods as needed
    public void printMethod() {
        System.out.println("\nExpense Reference Number: " + expense.getExpenseRefNumber());
        System.out.println("Payment Reference Number: " + paymentRefNumber);
        System.out.println("CreditCard: "+card);
        System.out.println("Card Name: " + Name);
        System.out.println("Card Number: " + Number);
        System.out.println("Payment Date: " + paymentDate);;
        System.out.println("Payment Amount: " + paymentAmount);
    }

}
