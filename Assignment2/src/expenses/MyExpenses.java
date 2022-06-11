package expenses;
//Class MyExpenses in package expenses that contains:


import payments.Payment;
import payments.CreditPayment;
import payments.DebitPayment;

public class MyExpenses {


    //An array called myExpenses where all expense objects are stored.
     public static Expense[] myExpenses = new Expense[5];

    // An array called myPayments where all payment objects are stored.
    public static Payment[] myPayments = new Payment[5];

    //A “read” method where two files, “expenses.txt” and “payments.txt”, will read expense and payment data into the program. First read “expenses.txt” and then “payments.txt”. Note that the specific payment objects will only be instantiated depending on the specific type of payment, debit or credit card. Payments will use the expenseRefNumber to find the corresponding payments to expense. You cannot enter your specific data into the program constructors.
    /*void read() {

        try (BufferedReader br = new BufferedReader(new FileReader("transcript.txt"))){
            String line;

            if ((line = br.readLine()) != null)
                numberCourses = Integer.parseInt(line);
            else {
                System.out.println("Incorrect file format");
                return;
            }

            while ((line = br.readLine()) != null) {
                String[] info = line.split(",");
                System.out.println("Info length: "+info.length);
                for (int j = 0; j < info.length; j++)
                    System.out.println(info[j]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }*/
// An “init” method where all expense and payment objects are created. Each expense object needs to be stored in myExpenses array. Each payment object needs to be stored in myPayments array. In the program, each payment corresponds to a single expense, and vice versa.
public static void ObjectCreate() {
   Expense Expense1 = new Expense("Electricity", "March 1 2021", 142.5,"April 2 2021","March 28 2021","5487", "5", 100.0);
   myExpenses[0] = Expense1;
   Expense Expense2 = new Expense("Music","February 4 2021",10.0,"March 4 2021","February 5 2021","A0100","6", 10.0);
   myExpenses[1] = Expense2;
    Expense Expense3 = new Expense("Cellular Data","January 28 2021",7.0,"March 1 2021","February 3 2021","3467","7", 7.0);
    myExpenses[2] = Expense3;
    Expense Expense4 = new Expense("Gas","January 29 2021",22.19,"February 29 2021","February 2 2021","14629","8", 15.37);
    myExpenses[3] = Expense4;
    Expense Expense5 = new Expense("Internet","January 17 2021",76.42,"February 18 2021","January 29 2021","I8527", "9",56.49);
    myExpenses[4] = Expense5;

    Payment Payment1 = new DebitPayment(myExpenses[0], "Suntrust", "Couch", "AC85260","March 28 2021", 100.0, "5487", "5");
    myPayments[0] = Payment1;
    Payment Payment2 = new CreditPayment(myExpenses[1],"USF Visa", "Couch","BD34235","February 5 2021", 10.0, "A0100","6");
    myPayments[1] = Payment2;
    Payment Payment3 = new CreditPayment(myExpenses[2], "Mastercard","Couch","BD34235","February 3 2021", 7.0, "3467","7");
    myPayments[2] = Payment3;
    Payment Payment4 = new DebitPayment(myExpenses[3],"Suntrust","Couch","AC85260","February 2 2021", 15.37, "14629","8");
    myPayments[3] = Payment4;
    Payment Payment5 = new DebitPayment(myExpenses[4],"Bank of America","Couch","AC85260","January 29 2021", 56.49, "I8527","9");
    myPayments[4] = Payment5;
 }

// A “print” method printing all the attributes for all expense and payment objects, and the total amount of expenses and the total balance after payments.
public static void PrintAttributes() {
    System.out.println("Expenses for Ethan Couch");
    System.out.println();
    for(int i = 0; i < myExpenses.length ; i++) {
        System.out.println(myExpenses[i].printEx());
    }

    System.out.println("Payments for Ethan Couch");
    System.out.println();
    for(int i = 0; i < myPayments.length; i++) {
        System.out.println(myPayments[i].printMethod());
    }

        System.out.print("Total Expenses: " );
    double billAmount1 = myExpenses[0].getBillAmount();
    double billAmount2 = myExpenses[1].getBillAmount();
    double billAmount3 = myExpenses[2].getBillAmount();
    double billAmount4 = myExpenses[3].getBillAmount();
    double billAmount5 = myExpenses[4].getBillAmount();
    double totalExpenses = billAmount1 + billAmount2 + billAmount3 + billAmount4 + billAmount5;
    System.out.println(totalExpenses);

        System.out.print("Total Balance: ");
    double baAmount1 = myExpenses[0].getBalanceAmount();
    double baAmount2 = myExpenses[1].getBalanceAmount();
    double baAmount3 = myExpenses[2].getBalanceAmount();
    double baAmount4 = myExpenses[3].getBalanceAmount();
    double baAmount5 = myExpenses[4].getBalanceAmount();
    double totalBalance = baAmount1 + baAmount2 + baAmount3 + baAmount4 + baAmount5;
    System.out.print(totalBalance);
}
// An "interact" method where the user will interact with the program, using the Scanner class from Java. The user will enter an expenseRefNumber and the program will print the corresponding expense and payment data.
/*void write() {
    File file = new File("transcript.txt");

    try (PrintWriter output = new PrintWriter(file)){
        output.println("4");
        output.println("USF,COP,2512,3,Programming Fundamentals for IT,Fall2019,A,4.0");
        output.println("USF,CGS,1540,3,Intro to Databases,Fall2019,A-,3.67");
        output.println("USF,CGS,3303,3,IT Concepts,Fall2019,A-,3.67");
        output.println("USF,COP,2513,3,Object-Oriented Programming for IT,Spring2020,TuTh,12:30pm,1:45pm,SOC,151,Weitzenfeld");
        output.close();
    }
    catch (IOException e) {
        e.printStackTrace();
    }
}*/

// The “main” method that calls the init, print, and interact methods.
    public static void main(String[] args) {
ObjectCreate();
PrintAttributes();
    }
}
