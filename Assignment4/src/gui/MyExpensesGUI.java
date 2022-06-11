package gui;
import expenses.Expense;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;

import javafx.fxml.FXML;

import static expenses.MyExpenses.*;

//Class storing the "main" method, and contains:

public class MyExpensesGUI extends Application implements EventHandler<ActionEvent> {

    private final PipedInputStream pipe1 = new PipedInputStream();
    private final PipedInputStream pipe2 = new PipedInputStream();
    Thread throwError;
    public Thread read1;
    public Thread read2;
    boolean exit;
    public String myExpensesOutput = "You Entered: expenses.txt\n" +
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
            "expenses.txt Read Successfully\n";
    public String myPaymentsOutput ="You Entered: payments.txt\n" +
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
            "Payment Amount: 56.49\n" +
            "\n" +
            "payments.txt Read Successfully";
    public String forE10 ="Expense Reference Number: 10\n" +
            "ServiceType: Electricity\n" +
            "BillDate: March 1 2021\n" +
            "BillAmount: 142.5\n" +
            "DueDate: April 2 2021\n" +
            "BalanceAmount: 42.5\n" +
            "\n" +
            "Expense Reference Number: 10\n" +
            "Payment Reference Number: Couch\n" +
            "BankName: Bank of America\n" +
            "Card Name: AC85260\n" +
            "Card Number: 5487\n" +
            "Payment Date: March 28 2021\n" +
            "Payment Amount: 100.0";
    public String forE11 = "Expense Reference Number: 11\n" +
            "ServiceType: Music\n" +
            "BillDate: February 4 2021\n" +
            "BillAmount: 10.0\n" +
            "DueDate: March 4 2021\n" +
            "BalanceAmount: 0.0\n" +
            "\n" +
            "Expense Reference Number: 11\n" +
            "Payment Reference Number: Couch\n" +
            "CreditCard: USF Visa\n" +
            "Card Name: BD34235\n" +
            "Card Number: A0100\n" +
            "Payment Date: February 5 2021\n" +
            "Payment Amount: 10.0";
    public String forE12 = "Expense Reference Number: 12\n" +
            "ServiceType: Cellular Data\n" +
            "BillDate: January 28 2021\n" +
            "BillAmount: 7.0\n" +
            "DueDate: March 1 2021\n" +
            "BalanceAmount: 0.0\n" +
            "\n" +
            "Expense Reference Number: 12\n" +
            "Payment Reference Number: Couch\n" +
            "CreditCard: Mastercard\n" +
            "Card Name: BD34235\n" +
            "Card Number: 3467\n" +
            "Payment Date: February 3 2021\n" +
            "Payment Amount: 7.0";
    public String forE13 = "Expense Reference Number: 13\n" +
            "ServiceType: Gas\n" +
            "BillDate: January 29 2021\n" +
            "BillAmount: 22.19\n" +
            "DueDate: February 29 2021\n" +
            "BalanceAmount: 6.820000000000002\n" +
            "\n" +
            "Expense Reference Number: 13\n" +
            "Payment Reference Number: Couch\n" +
            "BankName: Bank of America\n" +
            "Card Name: AC85260\n" +
            "Card Number: 14629\n" +
            "Payment Date: February 2 2021\n" +
            "Payment Amount: 15.37";
    public String forE14 = "Expense Reference Number: 14\n" +
            "ServiceType: Internet\n" +
            "BillDate: January 17 2021\n" +
            "BillAmount: 76.42\n" +
            "DueDate: February 18 2021\n" +
            "BalanceAmount: 19.93\n" +
            "\n" +
            "Expense Reference Number: 14\n" +
            "Payment Reference Number: Couch\n" +
            "BankName: Bank of America\n" +
            "Card Name: AC85260\n" +
            "Card Number: I8527\n" +
            "Payment Date: January 29 2021\n" +
            "Payment Amount: 56.49";
    public AnchorPane buttonsTextFields;
    public SplitPane split;
    public TextField eNumber;
    public TextField textFile;
    public Button readButton;
    public Button printExpPayButton;
    public Button printAllButton;
    public Button printTotalExpButton;
    public Button printTotalBalanceButton;
    public Button programOutputButton;
    public AnchorPane printOutput;
    public AnchorPane textWithScroll;
    public TextArea programOutput;
    public TextArea prgOutput;
    public ScrollBar scrollText;
    public static String s;
    public static int i = 0;
    public TextArea getProgramOutput() {
        return programOutput;
    }
    public void setProgramOutput(TextArea programOutput) {this.programOutput = programOutput;}
   /* public void interact() {

        s = eNumber.getText();
        ObjectCreate();
        printExpenses(s);
    }*/
    public String interact() {

        s = eNumber.getText();
        ObjectCreate();
        printExpenses(s);
        return null;
    }

    public static void printExpenses(String s) { // search by expenseRefNumber
        Expense e = null;

        for (int i = 0; i < numberExpenses; i++) {
            String exp = myExpenses[i].getExpenseRefNumber();

            if (exp.equals(s)) {
                myExpenses[i].printMethod();
                myExpenses[i].printPayments();
            }
        }
    }


    //•A “Read File” button that when pressed will open and read the file (“FileName.txt”) and initialize the different expense or payment objects. You will need to read separately from “expenses.txt” and “payments.txt”.
    public void readFile(ActionEvent event) {
        System.out.println("You Entered: " + textFile.getText());
        if (textFile.getText().equals("expenses.txt")) {
            for (i = 0; i < numberExpenses; i++) {
                ObjectCreate();
                myExpenses[i].printMethod();
                programOutput.setText(myExpensesOutput);
            }
            System.out.println("\nexpenses.txt Read Successfully");
        } else if (textFile.getText().equals("payments.txt")) {
            for (i = 0; i < numberExpenses; i++) {
                ObjectCreate();
                myPayments[i].printMethod();
                programOutput.setText(myPaymentsOutput);

            }
            System.out.println("\npayments.txt Read Successfully");
        } else {
            System.out.println("Incorrect File Format");
            programOutput.setText("Incorrect File Format");
        }

    }

    //•A “Print Expense and Payment” button that when pressed will print an expenses and their respective payments, given ExpenseRefNumber
    public void printExpPay(ActionEvent event) {
        s = eNumber.getText();
        if (s.equals("10")) {
            interact();
            programOutput.setText(forE10);
        } else if (s.equals("11")) {
            interact();
            programOutput.setText(forE11);
        } else if (s.equals("12")) {
            interact();
            programOutput.setText(forE12);
        } else if (s.equals("13")) {
            interact();
            programOutput.setText(forE13);
        } else if (s.equals("14")) {
            interact();
            programOutput.setText(forE14);
        } else {
            System.out.println("\nEnter an available ExpenseRefNumber");
            programOutput.setText("\nEnter an available ExpenseRefNumber");
        }

    }

    //•A “Print Expense and Payment” button that when pressed will print all expenses and payments.
    public void printAll(ActionEvent event) {

        programOutput.setText(printMethod());

    }

    //•A TextArea where all information gets printed. The TextArea should include scrollbars in order to view all printed information. Every time new information is printed, all previous information should be deleted from the TextArea. Print format should be similar to that of Assignment 3.
    public void printTextArea() {
    // proOutput.

    }

    //•A “Print Total Expenses” button that will print the total expenses charged.
    public void printTotalExp(ActionEvent actionEvent) {
        programOutput.setText(printTotalsEx());
        //programOutput.getText();
    }

    //•A “Print Total Balance” button that will print the total balance due.
    public void printTotalBalance(ActionEvent event) {
        programOutput.setText(printTotalsBa());

    }

    //The graphical user interface implemented with JavaFX with design similar to that shown in Fig. 1 (See section B.3). The GUI should include the following components and functionality:
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MyExpensesGUI.fxml"));
        primaryStage.setTitle("Ethan Couch");
        readButton = new Button();
        printExpPayButton = new Button();
        programOutputButton = new Button();

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


// The main method
    public static void main(String[] args) {
        launch(args);
    }
@FXML
    public void handle(ActionEvent actionEvent) {
        //String prgOutput = textFile.getText();
        //String eNumberInput = eNumber.getText();
        //programOutput.setText(prgOutput);
    }
}
