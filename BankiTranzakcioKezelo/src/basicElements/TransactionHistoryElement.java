/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicElements;

/**
 *
 * @author ckranyecz
 * A számlához tartozó tranzakció előzményeket tároló osztály
 */
public class TransactionHistoryElement extends Transaction{
    private Double balanceAfterTR;

    public TransactionHistoryElement(String accountNr, String curr, Double amount, Double exRate) {
        super(accountNr, curr, amount, exRate);
    }


      public void setBalanceAfterTR(Double balanceAfterTR) {
        this.balanceAfterTR = balanceAfterTR;
    }

    public Double getBalanceAfterTR() {
        return balanceAfterTR;
    }
    
}
