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
public class QuickSort {

    private static int partition(List<Tshirt> tshirts, int low, int high, String ascOrDesc, Class<?> type) {

        int i = (low - 1); // index of smaller element

        if (type == Size.class) {
            int pivot = tshirts.get(high).getSize().ordinal();
            switch (ascOrDesc) {
                case "asc":

                    for (int j = low; j < high; j++) {
                        // If current element is smaller than the pivot 
                        if (tshirts.get(j).getSize().ordinal() < pivot) {
                            i++;

                            // swap tshirts.get(i) and tshirts.get(j) 
                            Tshirt temp = tshirts.get(i);
                            tshirts.set(i, tshirts.get(j));
                            tshirts.set(j, temp);
                        }
                    }
                    break;
                case "desc":
                    for (int j = low; j < high; j++) {
                        // If current element is smaller than the pivot 
                        if (tshirts.get(j).getSize().ordinal() > pivot) {
                            i++;

                            // swap tshirts.get(i) and tshirts.get(j) 
                            Tshirt temp = tshirts.get(i);
                            tshirts.set(i, tshirts.get(j));
                            tshirts.set(j, temp);
                        }
                    }
            }
        }
        if (type == Colors.class) {
            int pivot = tshirts.get(high).getColors().ordinal();
            switch (ascOrDesc) {
                case "asc":

                    for (int j = low; j < high; j++) {
                        // If current element is smaller than the pivot 
                        if (tshirts.get(j).getColors().ordinal() < pivot) {
                            i++;

                            // swap tshirts.get(i) and tshirts.get(j) 
                            Tshirt temp = tshirts.get(i);
                            tshirts.set(i, tshirts.get(j));
                            tshirts.set(j, temp);
                        }
                    }
                    break;
                case "desc":
                    for (int j = low; j < high; j++) {
                        // If current element is smaller than the pivot 
                        if (tshirts.get(j).getColors().ordinal() > pivot) {
                            i++;

                            // swap tshirts.get(i) and tshirts.get(j) 
                            Tshirt temp = tshirts.get(i);
                            tshirts.set(i, tshirts.get(j));
                            tshirts.set(j, temp);
                        }
                    }
            }
        }
        if (type == Fabric.class) {
            int pivot = tshirts.get(high).getFabric().ordinal();
            switch (ascOrDesc) {
                case "asc":

                    for (int j = low; j < high; j++) {
                        // If current element is smaller than the pivot 
                        if (tshirts.get(j).getFabric().ordinal() < pivot) {
                            i++;

                            // swap tshirts.get(i) and tshirts.get(j) 
                            Tshirt temp = tshirts.get(i);
                            tshirts.set(i, tshirts.get(j));
                            tshirts.set(j, temp);
                        }
                    }
                    break;
                case "desc":
                    for (int j = low; j < high; j++) {
                        // If current element is smaller than the pivot 
                        if (tshirts.get(j).getFabric().ordinal() > pivot) {
                            i++;

                            // swap tshirts.get(i) and tshirts.get(j) 
                            Tshirt temp = tshirts.get(i);
                            tshirts.set(i, tshirts.get(j));
                            tshirts.set(j, temp);
                        }
                    }
            }
        }
        // swap tshirts.get(i+1) and tshirts.get(high) (or pivot) 
        Tshirt temp = tshirts.get(i + 1);
        tshirts.set(i + 1, tshirts.get(high));
        tshirts.set(high, temp);

        return i + 1;
    }
    
    public static List<Tshirt> quickSortTshirtsByColorsOrSizeOrFabric(List<Tshirt> tshirts, String ascOrDesc, Class<?> type) {
        return sortTshirts(tshirts,
                tshirts.indexOf(tshirts.get(0)),
                tshirts.indexOf(tshirts.get(tshirts.size() - 1)),
                ascOrDesc,
                type);
    }

    /* The main function that implements QuickSort() 
      List<Tshirt> --> List to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    private static List<Tshirt> sortTshirts(List<Tshirt> tshirts, int low, int high, String ascOrDesc, Class<?> type) {
        if (low < high) {
            /* pi is partitioning index, swap tshirts.get(pi) is  
              now at right place */
            int pi = partition(tshirts, low, high, ascOrDesc, type);

            // Recursively sort elements before 
            // partition and after partition 
            sortTshirts(tshirts, low, pi - 1, ascOrDesc, type);
            sortTshirts(tshirts, pi + 1, high, ascOrDesc, type);
        }
        return tshirts;
    }

    

   

    

    
    
    

}
