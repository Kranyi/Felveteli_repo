/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readerClasses;

import basicElements.AccountObj;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ckranyecz
 * Számlákat fájlból olvassa be az osztály
 */
public class AccountReader {
    //Visszadja arrayList formájában a beolvasott számlákat
    public static ArrayList<AccountObj> Read(String csvFile){
   ArrayList<AccountObj> accountList = new ArrayList<AccountObj>();
        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        //Fájl beolvasása
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // ; az elválasztó
                String[] accountElements = line.split(cvsSplitBy);
                
               // System.out.println("Számla= " + accountElements[0] + " , Pénznem=" + accountElements[1]  + " , Egyenleg=" + accountElements[2]);
                accountList.add(new AccountObj(accountElements[0], accountElements[1], Double.valueOf(accountElements[2])));
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
        
        
    return accountList;
    }
    
}
