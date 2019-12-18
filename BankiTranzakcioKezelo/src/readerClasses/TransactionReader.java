/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readerClasses;

import basicElements.Transaction;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ckranyecz
 * Tranzakciókat olvas be fájból
 */
public class TransactionReader {
        //Visszadja arrayList formájában a beolvasott számlákat
       public static ArrayList<Transaction> Read(String csvFile){
       ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
       
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
                
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // ; az elválasztó
                String[] transactionElements = line.split(cvsSplitBy);
                
                // null elemek kezelése
                if(transactionElements[3].contains("null"))transactionElements[3]="0";
                
             //   System.out.println("Számla= " + transactionElements[0] + " , Pénznem=" + transactionElements[1]  + " , Összeg=" + transactionElements[2] + " , Árfolyam=" + transactionElements[3]);
                transactionList.add(new Transaction(transactionElements[0], transactionElements[1], Double.valueOf(transactionElements[2]), Double.valueOf(transactionElements[3])));
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }      
        
    return transactionList;
       
       }
}
