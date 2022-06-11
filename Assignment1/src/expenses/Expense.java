package expenses;

public class Expense {

    private String serviceType;

    private String billDate;

    private double billAmount;

    private String dueDate;

    private String paymentDate;

    private String paymentForm;

    private String paymentRefNumber;

    private double paymentAmount;

    private double balanceAmount;

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
        //this.billAmount = billAmount;
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

    public String getPaymentForm() {
        return paymentForm;
    }

    public void setPaymentForm(String paymentForm) {
        this.paymentForm = paymentForm;
    }

    public String getPaymentRefNumber() {
        return paymentRefNumber;
    }

    public void setPaymentRefNumber(String paymentRefNumber) {
        this.paymentRefNumber = paymentRefNumber;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }


    //A constructor method receiving all the arguments required to create each expense

    public Expense(String Type, String bDate, double biAmount, String dDate, String pDate, String Form, String Number, double pAmount, double balanceAmount) {
        serviceType = Type;
        billDate = bDate;
        billAmount = biAmount;
        dueDate = dDate;
        paymentDate = pDate;
        paymentForm = Form;
        paymentRefNumber = Number;
        paymentAmount = pAmount;
        balanceAmount = biAmount - pAmount;
        this.balanceAmount = balanceAmount;
    }
//  A print method printing the values of all variables in the class.
public void print() {
    System.out.println("ServiceType: " + serviceType);
    System.out.println("BillDate: " + billDate);
    System.out.println("BillAmount: " + billAmount);
    System.out.println("DueDate: " + dueDate);
    System.out.println("PaymentDate: " + paymentDate);
    System.out.println("PaymentForm: " + paymentForm);
    System.out.println("PaymentRefNumber: " + paymentRefNumber);
    System.out.println("PaymentAmount: " + paymentAmount);
    System.out.println("BalanceAmount: " + balanceAmount);
    System.out.println();}


}

