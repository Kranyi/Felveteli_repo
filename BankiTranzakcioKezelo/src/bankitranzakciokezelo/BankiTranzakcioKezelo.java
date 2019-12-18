/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankitranzakciokezelo;

import readerClasses.TransactionReader;
import readerClasses.AccountReader;
import basicElements.AccountObj;
import basicElements.Transaction;
import java.util.ArrayList;

/**
 *
 * @author ckranyecz
 */
public class BankiTranzakcioKezelo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // A számlák beolvasása
          String accCSVFile = "accounts.txt";
          String trCSVFile = "transactions.txt";
          ArrayList<AccountObj> accountArray;
          accountArray = AccountReader.Read(accCSVFile);
          // A tranzakciók beolvasása
          ArrayList<Transaction> transactionArray = TransactionReader.Read(trCSVFile);
          
          // Tranzakciók kezelés
          
        for (int i=0;i<transactionArray.size();i++){
            
            boolean existingAccount = false;
            Transaction currentTR = transactionArray.get(i);
            //Melyik számlához tartozik?
                        for(int j=0; j<accountArray.size();j++){
            AccountObj currentAcc = accountArray.get(j);
            transactionExecution:
                if(currentAcc.getAccount().compareTo(currentTR.getAccountNr())== 0){

            //Végrehajtjuk a műveletet és hozzáadjuk a tranzakciót a tranzakció történethez
                    currentAcc.executeTransaction(currentTR);
                    //Létezik a számlaszám, mivel megtaláltuk a számlák listájában
                existingAccount = true;
               break transactionExecution;
            }  
            }
                        //Megvizsgáljuk, hogy létezik-e a számlaszám (ha történt tranzakció végrehajtás bármely létező számlán, akkor az existingAccount változó true-ra állítódik)
                        //Ha 
                        if(!existingAccount){
                            System.out.println("-------------------------------------------------------------");
                            System.out.println("Az alábbi számlaszám nem létezik: " + currentTR.getAccountNr());}
                        //Ha 10 tranzakció végrehajtása megtörtént, akkor a számlatörténetet kiírjuk a standard outputra
                        //0-ról indul, ezért a +1 korrekció
                        if((i+1)%10==0){
                        for(int accIterator=0;accIterator<accountArray.size();accIterator++){
                        accountArray.get(accIterator).showHistory();
                        }
                        }
        }
          
    }
    
}
