package bank.core;

import bank.common.ConstantMessages;
import bank.common.ExceptionMessages;
import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;


import java.util.ArrayList;
import java.util.Collection;
public class ControllerImpl implements Controller{
    private LoanRepository loans;
    private Collection<Bank> banks;


    public ControllerImpl() {
        this.loans = new LoanRepository();
        this.banks = new ArrayList<>();

    }

    private Bank getBankByName(String bankName) {
        return this.banks.stream().filter(bank -> bank.getName().equals(bankName))
                .findFirst().get();
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank;

        if (type.equals("CentralBank")) {
            bank = new CentralBank(name);
            
        } else if (type.equals("BranchBank")) {
            bank = new BranchBank(name);

        }else {
            throw  new NullPointerException(ExceptionMessages.INVALID_BANK_TYPE);
        }
        this.banks.add(bank);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan;

        if (type.equals("StudentLoan")) {
            loan = new StudentLoan();
            
        } else if (type.equals("MortgageLoan")) {
            loan = new MortgageLoan();

        }else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_LOAN_TYPE);
        }
         this.loans.addLoan(loan);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan loanBank = this.loans.findFirst(loanType);

        if (loanBank == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_LOAN_FOUND, loanType));
        }
        for (Bank bank : this.banks) {
            if (bank.getName().equals(bankName)) {
                bank.addLoan(loanBank);
                String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
            }else {
                this.loans.removeLoan(loanBank);
            }
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }

    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Client client;
           switch (clientType) {
               case "Student":
                   client = new Student(clientName, clientID, income);
                   break;

               case "Adult":
                   client = new Adult(clientName, clientID, income);
                   break;

               default:
                   throw new IllegalArgumentException(ExceptionMessages.INVALID_CLIENT_TYPE);
           }
           Bank bank = getBankByName(bankName);
           boolean checkShort = clientType.startsWith("Adult")&& bank.getClass().getSimpleName().startsWith("CentralBank");
           boolean checkLong = clientType.startsWith("Student")&& bank.getClass().getSimpleName().startsWith("BranchBank");

           if (checkShort || checkLong) {
               bank.addClient(client);
           }else {
               return ConstantMessages.UNSUITABLE_BANK;
           }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
    }

    @Override
    public String finalCalculation(String bankName) {
        Bank bank = getBankByName(bankName);

        double priceClient = bank.getClients().stream().mapToDouble(Client::getIncome).sum();
        double priceLoad = bank.getLoans().stream().mapToDouble(Loan::getAmount).sum();
        double priceAll = priceClient + priceLoad;
        return String.format(ConstantMessages.FUNDS_BANK, bankName, priceAll);
    }

    @Override
    public String getStatistics() {
          StringBuilder builder = new StringBuilder();
        for (Bank bank : this.banks) {
            builder.append(bank.getStatistics()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
