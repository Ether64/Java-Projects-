package expenses;

import payments.Payment;

//Class Expense in package expenses. It implements the Print interface and contains:
public class Expense {



    // A private String data field serviceType, e.g. “Electricity”, “Gas”, etc.
 private String serviceType;
// A private String data field billDate, e.g. “Jan 4 2021”.
    private String billDate;
//  A private double(or Double) data field billAmount, e.g. 25.00
    private double billAmount;
// A private String data field dueDate, e.g.“Jan 30 2021”.
    private String dueDate;

    private String paymentDate;

    private String paymentRefNumber;

    private double paymentAmount;
// A private double(or Double) data field named balanceAmount,computing the difference between the billAmount and the paymentAmount for the expense.
    private double balanceAmount = billAmount - paymentAmount;

// A private String data field expenseRefNumber, e.g. “12345”, etc.
    private String expenseRefNumber;


// A private Payment data field named payment,storing a reference to the payment object where the corresponding payment information is stored.
   private Payment payment; //= new Payment("Couch", "AC85260","March 28 2021", 100.0, "5487", "5") {
    //@Override
    public void printPa() {

    }

    //@Override
    public String printMethod() {
        return null;
    }

//NOTE: the paymentAmount is obtained from the payment object reference
    //private double paymentAmount = paymentObject.pAmount;

    //Methods that set and return the values for each variable. Note that for balanceAmount there should only be a “get” method, and not a “set” method.
   public String getServiceType() {
        return serviceType;
    }

   public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public String getDueDate() {
        return dueDate;
    }
   public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }


    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }


    public String getPaymentRefNumber() {
        return paymentRefNumber;
    }

    public void setPaymentRefNumber(String paymentRefNumber) {
        this.paymentRefNumber = paymentRefNumber;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public String getExpenseRefNumber() {
        return getExpenseRefNumber();
    }

    public void setExpenseRefNumber(String expenseRefNumber) {
        this.expenseRefNumber = expenseRefNumber;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    //A constructor method receiving all the arguments required to create each expense, except balanceAmount and payment.

    public Expense(String Type, String bDate, double biAmount, String dDate, String pDate, String pNumber, String eNumber, double pAmount) {
        serviceType = Type;
        billDate = bDate;
        billAmount = biAmount;
        dueDate = dDate;
        paymentDate = pDate;
        paymentRefNumber = pNumber;
        paymentAmount = pAmount;
        balanceAmount = billAmount - paymentAmount;
        expenseRefNumber = eNumber;
    }
//  A print method printing the values of all variables in the class.
public String printEx() {
    return
            "Expense Reference Number: " + expenseRefNumber + "\nServiceType: " + serviceType + "\nBillDate: " + billDate + "\nBillAmount: " + billAmount
            + "\nDueDate: " + dueDate + "\nBalanceAmount: "
            + balanceAmount +"\n";
}

}

