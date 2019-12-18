/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicElements;

/**
 *
 * @author ckranyecz
 * Tranzakciók tárolására használatos osztály
 */
public class Transaction {
   
    String accountNr;         //számlaszám
    String curr;            //pénznem
    Double amount;          //összeg
    Double exRate;          //valutaárfolyam
        
    public Transaction(String accountNr, String curr, Double amount, Double exRate) {
        this.accountNr = accountNr;
        this.curr = curr;
        this.amount = amount;
        this.exRate = exRate;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public void setAccount(String accountNr) {
        this.accountNr = accountNr;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getExRate() {
        return exRate;
    }

    public void setExRate(Double exRate) {
        this.exRate = exRate;
    }
    
    
    
    
    
    
}
