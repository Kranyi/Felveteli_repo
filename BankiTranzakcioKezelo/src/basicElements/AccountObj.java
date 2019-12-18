/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicElements;

import java.util.ArrayList;

/**
 *
 * @author ckranyecz
 * Számaszám osztálya
 */
public class AccountObj {
    String account;         //Számla száma
    String accountCurr;     //Számla pénzneme
    Double accountBalance;  //Számla egyenlege
    ArrayList<TransactionHistoryElement> transactionHistory = new ArrayList<TransactionHistoryElement>(); // a számlához tartozó tranzakció előzményeket tárolja listában

    public AccountObj(String account, String accountCurr, Double accountBalance) {
        this.account = account;
        this.accountCurr = accountCurr;
        this.accountBalance = accountBalance;
    }

    
    public void executeTransaction(Transaction tr){
        //Megegyezik a tranzakció és a számlaszám devizája 
                if(this.accountCurr.compareTo(tr.getCurr()) == 0){
                     accountBalance = accountBalance + tr.getAmount();
                }
                //Különböző a tranzakció és a számlaszám devizája, átváltás szükséges
                else{
                 accountBalance = accountBalance + tr.getAmount()*tr.getExRate();
                }
                //A számlatörténethez adjuk a tranzakciót
                TransactionHistoryElement trhElement = new TransactionHistoryElement(tr.getAccountNr(),tr.getCurr(),tr.getAmount(),tr.getExRate()); 
                trhElement.setBalanceAfterTR(accountBalance);
                transactionHistory.add(trhElement);
        
    }
    // Kiírja a standard outputra a számlaszámhoz tartozó eddigi tranzakciókat 
    public void showHistory(){
                System.out.println("-------------------------------------------------------------");
        System.out.println("A " + this.account + " számlaszámhoz tartozó eddigi tranzakciók:");
        int sorszam=1;
        for(int i=0;i<transactionHistory.size();i++){
        
            System.out.println(sorszam++ + ". Tranzakció összege: " + transactionHistory.get(i).getAmount() + " pénznem: "+ transactionHistory.get(i).getCurr() + " új egyenleg: " + transactionHistory.get(i).getBalanceAfterTR());
        }
    }
     
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account.trim();
    }

    public String getAccountCurr() {
        return accountCurr;
    }

    public void setAccountCurr(String accountCurr) {
        this.accountCurr = accountCurr;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }
    
    

}
