/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexkamposassignment4.sorting;

import alexkamposassignment4.enums.Colors;
import alexkamposassignment4.enums.Fabric;
import alexkamposassignment4.enums.Size;
import alexkamposassignment4.tshirt.Tshirt;
import java.util.List;

/**
 *
 * @author alexk
 */
public class BubbleSort {
    
    public static List<Tshirt> bubbleSortTshirtsByColorsOrSizeOrFabric(List<Tshirt> tshirts, String ascOrDesc, Class<?> type) 
    { 
        int n = tshirts.size(); 
        
        if(type == Size.class){
        switch(ascOrDesc){
                case "asc":
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) 
                if (tshirts.get(j).getSize().ordinal() > tshirts.get(j+1).getSize().ordinal())
                { 
                    // swap tshirts.get(j+1) and arr[i] 
                     Tshirt temp = tshirts.get(j); 
                    tshirts.set(j, tshirts.get(j+1)); 
                    tshirts.set(j+1, temp); 
                }
        }
        break;
                case "desc":
               for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) 
                if (tshirts.get(j).getSize().ordinal() < tshirts.get(j+1).getSize().ordinal())
                { 
                    // swap tshirts.get(j+1) and arr[i] 
                     Tshirt temp = tshirts.get(j); 
                    tshirts.set(j, tshirts.get(j+1)); 
                    tshirts.set(j+1, temp); 
                }
        }
        }
        }
        
        if(type == Colors.class){
        switch(ascOrDesc){
                case "asc":
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) 
                if (tshirts.get(j).getColors().ordinal() > tshirts.get(j+1).getColors().ordinal())
                { 
                    // swap tshirts.get(j+1) and arr[i] 
                     Tshirt temp = tshirts.get(j); 
                    tshirts.set(j, tshirts.get(j+1)); 
                    tshirts.set(j+1, temp); 
                }
        }
        break;
                case "desc":
               for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) 
                if (tshirts.get(j).getColors().ordinal() < tshirts.get(j+1).getColors().ordinal())
                { 
                    // swap tshirts.get(j+1) and arr[i] 
                     Tshirt temp = tshirts.get(j); 
                    tshirts.set(j, tshirts.get(j+1)); 
                    tshirts.set(j+1, temp); 
                }
        }
        }
        }
        
        if(type == Fabric.class){
        switch(ascOrDesc){
                case "asc":
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) 
                if (tshirts.get(j).getFabric().ordinal() > tshirts.get(j+1).getFabric().ordinal())
                { 
                    // swap tshirts.get(j+1) and arr[i] 
                     Tshirt temp = tshirts.get(j); 
                    tshirts.set(j, tshirts.get(j+1)); 
                    tshirts.set(j+1, temp); 
                }
        }
        break;
                case "desc":
               for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) 
                if (tshirts.get(j).getFabric().ordinal() < tshirts.get(j+1).getFabric().ordinal())
                { 
                    // swap tshirts.get(j+1) and arr[i] 
                     Tshirt temp = tshirts.get(j); 
                    tshirts.set(j, tshirts.get(j+1)); 
                    tshirts.set(j+1, temp); 
                }
        }
        }
        }
      return tshirts;  
    } 
}
