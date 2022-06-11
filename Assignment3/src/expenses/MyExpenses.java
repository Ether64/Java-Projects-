package expenses;
//Class MyExpenses in package expenses that contains:


import payments.Payment;
import payments.CreditPayment;
import payments.DebitPayment;
import java.io.*;
import java.util.Scanner;

public class MyExpenses {




    int numberLines = 0;
    int numberLines2 = 0;
   static Expense expense;
    static Payment payment;
    static String name = "Ethan Couch";

    //An array called myExpenses where all expense objects are stored.
    static int numberExpenses = 5;
    static Expense[] myExpenses = new Expense[numberExpenses];

    // An array called myPayments where all payment objects are stored.
    static int numberPayments = 5;
    static Payment[] myPayments = new Payment[numberPayments];


    //A “read” method where two files, “expenses.txt” and “payments.txt”, will read expense and payment data into the program. First read “expenses.txt” and then “payments.txt”. Note that the specific payment objects will only be instantiated depending on the specific type of payment, debit or credit card. Payments will use the expenseRefNumber to find the corresponding payments to expense. You cannot enter your specific data into the program constructors.
    static void read()  {

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

/*
        if ((line2 = br2.readLine()) != null) {
            c = Integer.parseInt(line2);
            System.out.println(line2);
        }else {
            System.out.println("Incorrect file format");
            return;
        } */
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
        // An “init” method where all expense and payment objects are created. Each expense object needs to be stored in myExpenses array. Each payment object needs to be stored in myPayments array. In the program, each payment corresponds to a single expense, and vice versa.
        public static void ObjectCreate()  {
            //MyExpenses my = new MyExpenses();
            //my.read();
            read();
        }

        // A “print” method printing all the attributes for all expense and payment objects, and the total amount of expenses and the total balance after payments.
        public static void printMethod() {

            double totalExpenses = 0, totalExpensesBalance= 0;
            System.out.println("\nExpenses for "+name);
            for (int i=0; i<myExpenses.length; i++) {
                payment = myExpenses[i].getPayment();
                totalExpenses += myExpenses[i].getBillAmount();
                myExpenses[i].printMethod();
            }
            System.out.println("\nPayments for "+name);
            for (int j=0; j<myPayments.length; j++) {
                payment = myExpenses[j].getPayment();
                totalExpensesBalance +=myExpenses[j].getBillAmount() - myPayments[j].getPaymentAmount();
                payment.printMethod();
            }
            System.out.println("\nTotal Expenses: " + totalExpenses);
            System.out.println("Total Balance: " + totalExpensesBalance);
            /*double totalExpenses = 0, totalExpensesBalance = 0;

            System.out.println("\nExpenses for " + name);
            for (int i = 0; i < numberExpenses; i++) {
                payment = myExpenses[i].getPayment();
                myExpenses[i].printMethod();
                totalExpenses += myExpenses[i].getBillAmount();
                totalExpensesBalance += myExpenses[i].getBalanceAmount();
            }
            System.out.println("\nPayments for " + name);
            for (int i = 0; i < numberPayments; i++) {
                payment = myExpenses[i].getPayment();
                payment.printMethod();
            }
            System.out.println("\nTotal Expenses: " + totalExpenses);
            System.out.println("Total Balance: " + totalExpensesBalance);*/
        }

// An “interact” method where the user will interact with the program, using the Scanner class from Java. The user will enter an expenseRefNumber and the program will print the corresponding expense and payment data.
public static void interact() {
    Scanner scnr = new Scanner(System.in);
    String info = scnr.nextLine();

    while (scnr.hasNextLine()) {
        if(info.equals("Exit")) {
            break;
        }

        for (int i = 0; i < myExpenses.length; i++) {
            if (info.equals(myExpenses[i].getExpenseRefNumber())) {
                myExpenses[i].printMethod();
                //System.out.println("Expense Reference Number; " + myExpenses[i].getExpenseRefNumber());
                myPayments[i].printMethod();
            }
            System.out.println("Expense Reference Number; " + myExpenses[i].getExpenseRefNumber());
        }
    }
}
// The “main” method that calls the init, print, and interact methods.
        public static void main(String[]args){
            //MyExpenses my = new MyExpenses();
            //my.ObjectCreate();
            ObjectCreate();
            printMethod();
            interact();
            //my.printMethod();
           // my.interact();
        }
    }



