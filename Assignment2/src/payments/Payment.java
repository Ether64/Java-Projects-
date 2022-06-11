package payments;
// Abstract class Payment in package payments. Superclass storing common payment information.It implements the Print interface and contains:


import expenses.*;

public abstract class Payment implements Print {


    // A protected String data field named Name storing the name of the payment account.
protected String Name;

// A protected String data field named Number storing the number of the payment account.
protected String Number;

// A protected String data field paymentDate, e.g.“Jan 20 2021”.
protected String paymentDate;

// A protected double(or Double) data field named paymentAmount,e.g. 10.00
protected double paymentAmount;

// A protected String data field paymentRefNumber, e.g. “123456”, etc. (Do not use your real reference information. The number may be composed of year, month, day, and any additional number, e.g. “20210101-9”)
protected String paymentRefNumber;

protected String expenseRefNumber;


// A protected Expense data field named expense,storing a reference to the expense object where the corresponding expense information is stored.
protected Expense expense;





// Methods that set and return the values for each variable.

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
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
        return paymentRefNumber;
    }

    public void setPaymentRefNumber(String paymentRefNumber) {
        this.paymentRefNumber = paymentRefNumber;
    }

    public String getExpenseRefNumber() {return expenseRefNumber;}

    // A constructor method receiving all the arguments required to create each payment, including a reference to the corresponding expense object.
public Payment(String Name, String Number, String paymentDate, double paymentAmount, String paymentRefNumber, String eNumber) {
    //expense = expense.getExpenseRefNumber();
    this.Name = Name;
    this.Number = Number;
    this.paymentDate = paymentDate;
    this.paymentAmount = paymentAmount;
    this.paymentRefNumber= paymentRefNumber;
    this.expenseRefNumber = eNumber;
    //this.eNumber = expense.getExpenseRefNumber();
    //expense.setExpenseRefNumber(eNumber);


}
// An abstract print method printing the values of all variables. You may add additional printing methods as needed.
public abstract void printPa(); /*{
    System.out.println("Card Name: " + Name);
    System.out.println("Card Number: " + Number);
    System.out.println("Payment Date: " + paymentDate);;
    System.out.println("Payment Amount: " + paymentAmount);
    System.out.println("Reference Number: " + paymentRefNumber);
    System.out.println();
}*/


}

