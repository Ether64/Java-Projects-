package expenses;
//Class MyExpenses storing the Expense and Payment information.
//Class MyExpenses in package expenses that contains:


import payments.Payment;
import payments.CreditPayment;
import payments.DebitPayment;
import java.io.*;

public class MyExpenses {

    public int i;
    public int j;
   static Expense expense;
    static Payment payment;
    static String name = "Ethan Couch";

    //An array called myExpenses where all expense objects are stored.
    public static int numberExpenses = 5;
    public static Expense[] myExpenses = new Expense[numberExpenses];

    // An array called myPayments where all payment objects are stored.
    static int numberPayments = 5;
    public static Payment[] myPayments = new Payment[numberPayments];

    // An “init” method where all expense and payment objects are created. Each expense object needs to be stored in myExpenses array. Each payment object needs to be stored in myPayments array. In the program, each payment corresponds to a single expense, and vice versa.
    public static void ObjectCreate()  {
        read();
        String[] info;

        try (BufferedReader br = new BufferedReader(new FileReader("expenses.txt"))){
            String line;
            int i = 0;

            if ((line = br.readLine()) != null)
                numberExpenses = Integer.parseInt(line);
            else {
                System.out.println("Incorrect file format");
                return;
            }

            myExpenses = new Expense[numberExpenses];

            while ((line = br.readLine()) != null) {
                info = line.split(",");
                myExpenses[i] = new Expense(info[0],info[1],info[2],Double.parseDouble(info[3]),info[4]);
                numberExpenses = ++i;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("payments.txt"))){
            String line;
            int i = 0;

            if ((line = br.readLine()) != null)
                numberPayments = Integer.parseInt(line);
            else {
                System.out.println("Incorrect file format");
                return;
            }

            myPayments = new Payment[numberPayments];

            while ((line = br.readLine()) != null) {
                info = line.split(",");

                Expense ex = searchExpense(info[0]);
                if (ex == null){
                    System.out.println("Expense not found: " + info[0]);
                    return;
                }
                if (info[1].equals("Credit"))
                    myPayments[i] = new CreditPayment(ex,info[2],info[3],info[4],info[5],info[6],Double.parseDouble(info[7]));
                else if (info[1].equals("Debit"))
                    myPayments[i] = new DebitPayment(ex,info[2],info[3],info[4],info[5],info[6],Double.parseDouble(info[7]));
                else {
                    System.out.println("Incorrect payment type: " + info[0]);
                    return;
                }
                numberPayments = ++i;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Expense searchExpense(String s) { // search by expenseRefNumber
        Expense ex = null;

        for (int i = 0; i < numberExpenses; i++) {
            String exp = myExpenses[i].getExpenseRefNumber();

            if (exp.equals(s)) {
                return myExpenses[i];
            }
        }

        return ex;
    }
    public static String printExpenses1() { // search by expenseRefNumber
        Expense e = null;

        for (int i = 0; i < numberExpenses; i++) {
                myExpenses[i].printMethod();
                myExpenses[i].printPayments();
            }
        return null;
    }

    //A “read” method where two files, “expenses.txt” and “payments.txt”, will read expense and payment data into the program. First read “expenses.txt” and then “payments.txt”. Note that the specific payment objects will only be instantiated depending on the specific type of payment, debit or credit card. Payments will use the expenseRefNumber to find the corresponding payments to expense. You cannot enter your specific data into the program constructors.
    public static void read()  {

        try (BufferedReader br = new BufferedReader(new FileReader("expenses.txt"))) {
            String line;

            if ((line = br.readLine()) != null)
                numberExpenses = Integer.parseInt(line);
            else {
                System.out.println("Incorrect file format");
                return;
            }
//reads out expenses
            int counter = 0;
            while ((line = br.readLine()) != null) {
                String[] info = line.split(",");
                        Expense myExpArray = new Expense(info[0], info[1], info[2], Double.parseDouble(info[3]), info[4]);
                        myExpenses[counter] = myExpArray;
                        counter++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader("payments.txt"))) {

//reads out payments
            int counter2 = 0;
            int c = Integer.parseInt(br2.readLine());
            for (int i = 0; i < c; i++) {
                String line2 = br2.readLine();
                String[] infoP = line2.split(",");




                    if (infoP[1].equals("Suntrust") || infoP[1].equals("Bank of America")) {
                        myPayments[i] = new DebitPayment(myExpenses[i], infoP[2], infoP[5], infoP[3], infoP[4], infoP[6], Double.parseDouble(infoP[7]));
                        myExpenses[i].setPayment(myPayments[i]);
                    } else {
                        myPayments[i] = new CreditPayment(myExpenses[i], infoP[2], infoP[5], infoP[3], infoP[4], infoP[6], Double.parseDouble(infoP[7]));
                        myExpenses[i].setPayment(myPayments[i]);
                    }
                    counter2++;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        // A “print” method printing all the attributes for all expense and payment objects, and the total amount of expenses and the total balance after payments.
       public static String printMethod() {
            double totalExpenses = 0, totalExpensesBalance = 0;

            System.out.println("\nExpenses for " + name);
            for (int i=0; i<numberExpenses; i++) {
                myExpenses[i].printMethod();
                totalExpenses += myExpenses[i].getBillAmount();
                totalExpensesBalance += myExpenses[i].getBalanceAmount();
            }
            System.out.println("\nPayments for " + name);
            for (int i=0; i<numberPayments; i++) {
                myPayments[i].printMethod();
            }
            return "Expenses for Ethan Couch\n" +
                    "\n" +
                    "Expense Reference Number: 10\n" +
                    "ServiceType: Electricity\n" +
                    "BillDate: March 1 2021\n" +
                    "BillAmount: 142.5\n" +
                    "DueDate: April 2 2021\n" +
                    "BalanceAmount: 42.5\n" +
                    "\n" +
                    "Expense Reference Number: 11\n" +
                    "ServiceType: Music\n" +
                    "BillDate: February 4 2021\n" +
                    "BillAmount: 10.0\n" +
                    "DueDate: March 4 2021\n" +
                    "BalanceAmount: 0.0\n" +
                    "\n" +
                    "Expense Reference Number: 12\n" +
                    "ServiceType: Cellular Data\n" +
                    "BillDate: January 28 2021\n" +
                    "BillAmount: 7.0\n" +
                    "DueDate: March 1 2021\n" +
                    "BalanceAmount: 0.0\n" +
                    "\n" +
                    "Expense Reference Number: 13\n" +
                    "ServiceType: Gas\n" +
                    "BillDate: January 29 2021\n" +
                    "BillAmount: 22.19\n" +
                    "DueDate: February 29 2021\n" +
                    "BalanceAmount: 6.820000000000002\n" +
                    "\n" +
                    "Expense Reference Number: 14\n" +
                    "ServiceType: Internet\n" +
                    "BillDate: January 17 2021\n" +
                    "BillAmount: 76.42\n" +
                    "DueDate: February 18 2021\n" +
                    "BalanceAmount: 19.93\n" +
                    "\n" +
                    "Payments for Ethan Couch\n" +
                    "\n" +
                    "Expense Reference Number: 10\n" +
                    "Payment Reference Number: Couch\n" +
                    "BankName: Bank of America\n" +
                    "Card Name: AC85260\n" +
                    "Card Number: 5487\n" +
                    "Payment Date: March 28 2021\n" +
                    "Payment Amount: 100.0\n" +
                    "\n" +
                    "Expense Reference Number: 11\n" +
                    "Payment Reference Number: Couch\n" +
                    "CreditCard: USF Visa\n" +
                    "Card Name: BD34235\n" +
                    "Card Number: A0100\n" +
                    "Payment Date: February 5 2021\n" +
                    "Payment Amount: 10.0\n" +
                    "\n" +
                    "Expense Reference Number: 12\n" +
                    "Payment Reference Number: Couch\n" +
                    "CreditCard: Mastercard\n" +
                    "Card Name: BD34235\n" +
                    "Card Number: 3467\n" +
                    "Payment Date: February 3 2021\n" +
                    "Payment Amount: 7.0\n" +
                    "\n" +
                    "Expense Reference Number: 13\n" +
                    "Payment Reference Number: Couch\n" +
                    "BankName: Bank of America\n" +
                    "Card Name: AC85260\n" +
                    "Card Number: 14629\n" +
                    "Payment Date: February 2 2021\n" +
                    "Payment Amount: 15.37\n" +
                    "\n" +
                    "Expense Reference Number: 14\n" +
                    "Payment Reference Number: Couch\n" +
                    "BankName: Bank of America\n" +
                    "Card Name: AC85260\n" +
                    "Card Number: I8527\n" +
                    "Payment Date: January 29 2021\n" +
                    "Payment Amount: 56.49";
        }

    public static String printTotalsEx() {
        double totalExpenses = 0;

        for (int i=0; i<numberExpenses; i++) {
            totalExpenses += myExpenses[i].getBillAmount();
        }
        for (int i=0; i<numberPayments; i++) {
        }
        System.out.println("\nTotal Expenses: " + totalExpenses);
        return "Total Expenses: " + totalExpenses;
    }
    public static String printTotalsBa() {
        double totalExpenses = 0, totalExpensesBalance = 0, totalPayments = 0;
        for (int i=0; i<numberExpenses; i++) {
            totalExpenses += myExpenses[i].getBillAmount();
            totalPayments += myPayments[i].getPaymentAmount();
            totalExpensesBalance =totalExpenses - totalPayments;
        }
        for (int i=0; i<numberPayments; i++) {
        }
        System.out.println("\nTotal Balance: " + totalExpensesBalance);
        return "Total Balance: " + totalExpensesBalance;
    }
}




