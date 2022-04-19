package com.solidprinciple.violation;

//SRP Violation
class AccountService{
    public void openAccount(){
        System.out.println("Fill account internal details");
        System.out.println("store account objects in database");
        System.out.println("send out welcome message");
    }

    //OCP Violation
    public void aadharLinking(long number){
        System.out.println("Aadhar Number " + number + " is now linked to your account");
    }

    public void creditAmount(long amount){
        System.out.println("Your account is credited with: " + amount);
    }
}

//LSP Violation
class LoanAccount extends AccountService{

    long totalBalance = 100000;
    public void openAccount(){
        System.out.println("Fill the credentials for creating your loan account");
    }

    public void aadharLinking(long number){
        System.out.println("Your Aadhar Number " + number + " is now linked to your loan account");
    }

    public void withdrawLoanAmount(long amount){
        System.out.println("Your balance is debited with: " + amount + "from your loan account and current balance is: " + (totalBalance-amount));
    }
}

class CustomerCareService{
    CustomerQuery query = new CustomerQuery();
    public void send(String to, String message){
        query.sendMessage("message to " + to + " " + message);
    }
}

class CustomerQuery extends CustomerCareService {
    public void sendMessage(String query){
        System.out.println("your query: " + query + " is resolved");
    }
}
public class SolidPrincipleViolationDemo {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        accountService.openAccount();
        accountService.aadharLinking(8561);
    }
}
