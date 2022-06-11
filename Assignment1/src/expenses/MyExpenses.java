package expenses;


public class MyExpenses {


    //An array called myExpenses where all expense objects are stored.
    private static Expense[] myExpenses = new Expense[5];


public static void ExpenseCreate() {
   Expense Expense1 = new Expense("Electricity", "March 1 2021", 142.5,"April 2 2021", "March 28 2021", "Debit Card", "5487",100.0,42.5);
   myExpenses[0] = Expense1;
   Expense Expense2 = new Expense("Music","February 4 2021",10.0,"March 4 2021", "February 5 2021","Debit Card","A0100", 10, 0);
   myExpenses[1] = Expense2;
    Expense Expense3 = new Expense("Cellular Data","January 28 2021",7.0,"March 1 2021", "February 3 2021","Debit Card","3467", 7.0, 0);
    myExpenses[2] = Expense3;
    Expense Expense4 = new Expense("Gas","January 29 2021",22.19,"February 29 2021", "February 2 2021","Debit Card","14629", 15.37, 6.82);
    myExpenses[3] = Expense4;
    Expense Expense5 = new Expense("Internet","January 17 2021",76.42,"February 18 2021", "January 29 2021","Debit Card","I8527", 56.49, 19.93);
    myExpenses[4] = Expense5;
 }


public static void PrintAttributes() {
    System.out.println("Expenses for Ethan Couch");
    System.out.println();
   for (Expense i: myExpenses){
     i.print();
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
    public static void main(String[] args) {
ExpenseCreate();
PrintAttributes();
    }
}
