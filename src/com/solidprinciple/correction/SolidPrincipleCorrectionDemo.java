package com.solidprinciple.correction;

import com.solidprinciple.violation.SolidPrincipleViolationDemo;

//SRP(Single Responsibility Principle)
class AccountService{
    public void openAccount(String name, long number){
        System.out.println("Fill Your Details required for opening account");
    }
}

class AccountRepository{
    public void create(){
        System.out.println("Account details store in database");
    }
}

class NotificationMessage{
    public void sendNotification(){
        System.out.println("Your account has been created");
    }
}

//OCP(Open/Closed Principle)
class AadharLinking extends AccountService {
    public void aadharRegistration(int number){
        System.out.println("Now, Your Aadhar Number "+number+" is linked to your account");
    }
}

//(LSP)Liskov Substitution Principle
class LoanAccount extends AccountService {
    @Override
    public void openAccount(String name, long number) {
        super.openAccount(name, number);
        System.out.println("Your Loan Account is created");
    }
}

//ISP(Interface Segregation Principle)
class TransactionHistory implements AccountCredentials{

    @Override
    public void name(String name) {
        System.out.println("Account Holder: " + name);
    }

    @Override
    public void accountNumber(long number) {
        System.out.println("Account Number " + number );
    }
}

class Balance implements Transactions{
    long totalAmount = 100000;

    @Override
    public void creditAmount(long amount) {
        System.out.println("Credit Amount is: " +  amount);
        System.out.println("Current Balance is: " + amount+totalAmount);
    }

    @Override
    public void debitAmount(long amount) {
        System.out.println("Credit Amount is: "+ amount);
        System.out.println("Current Balance is: " + (totalAmount - amount));
    }
}

//Dependency Inversion Principle

class CustomerCareServices {

    QueryHandler queryHandler;
    CustomerCareServices(QueryHandler queryHandler){
        queryHandler.sendMessage("hello");
    }
}

class CustomerQuery implements QueryHandler {

    @Override
    public void sendMessage(String query) {
        System.out.println("your query: " + query + " is resolved");
    }
}

public class SolidPrincipleCorrectionDemo {
    public static void main(String[] args) {

        AccountService accountService = new AccountService();
        accountService.openAccount("Suraj Kumar", 85444);

        AccountRepository repository = new AccountRepository();
        repository.create();

        NotificationMessage message = new NotificationMessage();
        message.sendNotification();

        AadharLinking aadharLinking = new AadharLinking();
        aadharLinking.aadharRegistration(807526);

        Balance balance = new Balance();
        balance.creditAmount(24156);
        balance.debitAmount(54545);

        LoanAccount newAccount = new LoanAccount();
        newAccount.openAccount("kishan", 8745456);

        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.name("Anubhav");
        transactionHistory.accountNumber(556454);

        CustomerCareServices obj = new CustomerCareServices(new CustomerQuery());
    }
}


