/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexkamposassignment4.utils;

import alexkamposassignment4.enums.Colors;
import alexkamposassignment4.enums.Fabric;
import alexkamposassignment4.enums.Size;
import alexkamposassignment4.sorting.BubbleSort;
import static alexkamposassignment4.sorting.BubbleSort.bubbleSortTshirtsByColorsOrSizeOrFabric;
import alexkamposassignment4.sorting.BucketSort;
import static alexkamposassignment4.sorting.BucketSort.bucketSortTshirtsByColorsOrSizeOrFabric;
import alexkamposassignment4.sorting.QuickSort;
import static alexkamposassignment4.sorting.QuickSort.quickSortTshirtsByColorsOrSizeOrFabric;
import alexkamposassignment4.tshirt.Tshirt;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author alexk
 */
public class UtilMethods {

    public static int getRandomNumberFromOneToSix() {
        Random rand = new Random();
        return rand.nextInt(7);
    }

    public static <T extends Enum<T>> T getEnumValueByNumber(int enumOrdinal, Class<T> enumType) {
        if (enumType == Colors.class) {
            return (T) Colors.values()[enumOrdinal];
        }
        if (enumType == Fabric.class) {
            return (T) Fabric.values()[enumOrdinal];
        }
        if (enumType == Size.class) {
            return (T) Size.values()[enumOrdinal];
        }
        return null;
    }

    /*
        sorts the list by size,
        then by color, 
        then by fabric
     */
    public static List<Tshirt> sortTshirtsByColorsAndSizeAndFabric(List<Tshirt> tshirts, String ascOrDesc, Class<?> typeOfSorting) {
        if (typeOfSorting == QuickSort.class) {
            quickSortTshirtsByColorsOrSizeOrFabric(tshirts, ascOrDesc, Size.class);
        }
        if (typeOfSorting == BubbleSort.class) {
            bubbleSortTshirtsByColorsOrSizeOrFabric(tshirts, ascOrDesc, Size.class);
        }
        if (typeOfSorting == BucketSort.class) {
            bucketSortTshirtsByColorsOrSizeOrFabric(tshirts, ascOrDesc, Size.class);
        }
        List<List<Tshirt>> subLists = splitTshirtsBySize(tshirts, ascOrDesc);
        if (typeOfSorting == QuickSort.class) {
            for (int i = 0; i < subLists.size(); i++) {
                if (subLists.get(i).isEmpty()) {
                    continue;
                }

                quickSortTshirtsByColorsOrSizeOrFabric(subLists.get(i), ascOrDesc, Colors.class);
            }
        }
        if (typeOfSorting == BubbleSort.class) {
            for (int i = 0; i < subLists.size(); i++) {
                if (subLists.get(i).isEmpty()) {
                    continue;
                }
                bubbleSortTshirtsByColorsOrSizeOrFabric(subLists.get(i), ascOrDesc, Colors.class);
            }
        }
        if (typeOfSorting == BucketSort.class) {
            for (int i = 0; i < subLists.size(); i++) {
                if (subLists.get(i).isEmpty()) {
                    continue;
                }
                bucketSortTshirtsByColorsOrSizeOrFabric(subLists.get(i), ascOrDesc, Colors.class);
            }
        }
        List<List<Tshirt>> subLists2 = splitTshirtsByColors(subLists, ascOrDesc);
        List<Tshirt> sortedTshirts = new ArrayList();
        if (typeOfSorting == QuickSort.class) {
            for (int i = 0; i < subLists2.size(); i++) {
                if (subLists2.get(i).isEmpty()) {
                    continue;
                }

                quickSortTshirtsByColorsOrSizeOrFabric(subLists2.get(i), ascOrDesc, Fabric.class);
                sortedTshirts.addAll(subLists2.get(i));
            }
        }
        if (typeOfSorting == BubbleSort.class) {
            for (int i = 0; i < subLists2.size(); i++) {
                if (subLists2.get(i).isEmpty()) {
                    continue;
                }

                bubbleSortTshirtsByColorsOrSizeOrFabric(subLists2.get(i), ascOrDesc, Fabric.class);
                sortedTshirts.addAll(subLists2.get(i));
            }
        }
        if (typeOfSorting == BucketSort.class) {
            for (int i = 0; i < subLists2.size(); i++) {
                if (subLists2.get(i).isEmpty()) {
                    continue;
                }

                bucketSortTshirtsByColorsOrSizeOrFabric(subLists2.get(i), ascOrDesc, Fabric.class);
                sortedTshirts.addAll(subLists2.get(i));
            }
        }

        return sortedTshirts;
    }

    //Splits tshirts on different listes by size and to ascending or descending order depending on input
    public static List<List<Tshirt>> splitTshirtsBySize(List<Tshirt> tshirts, String ascOrDesc) {
        List<List<Tshirt>> subLists = new ArrayList<List<Tshirt>>();

        int[] sBySize = new int[7];
        for (int i = 0; i < 7; i++) {
            sBySize[i] = 0;
        }
        for (Tshirt tShirt : tshirts) {
            sBySize[tShirt.getSize().ordinal()]++;
        }
        Tstruct[] allSizes = new Tstruct[7];
        int counter = 0;

        if (ascOrDesc.equals("asc")) {
            for (int i = 0; i < 7; i++) {
                allSizes[i] = new Tstruct();
                if (sBySize[i] == 0) {
                    allSizes[i].start = -1;
                    allSizes[i].end = -1;
                } else {
                    allSizes[i].start = counter;
                    allSizes[i].end = counter + sBySize[i];
                    subLists.add(tshirts.subList(allSizes[i].start, allSizes[i].end));
                }
                counter += sBySize[i];
            }
        }

        if (ascOrDesc.equals("desc")) {
            for (int i = 6; i >= 0; i--) {
                allSizes[i] = new Tstruct();
                if (sBySize[i] == 0) {
                    allSizes[i].start = -1;
                    allSizes[i].end = -1;
                } else {
                    allSizes[i].start = counter;
                    allSizes[i].end = counter + sBySize[i];
                    subLists.add(tshirts.subList(allSizes[i].start, allSizes[i].end));
                }
                counter += sBySize[i];
            }
        }

        return subLists;
    }

    //Splits the  tshirts (already splitted by size) by colors and to ascending or descending order depending on input
    public static List<List<Tshirt>> splitTshirtsByColors(List<List<Tshirt>> tshirtsList, String ascOrDesc) {
        List<List<Tshirt>> subLists = new ArrayList<List<Tshirt>>();

        List<int[]> sByColors = new ArrayList<int[]>();
        for (int i = 0; i < tshirtsList.size(); i++) {
            int[] sByColor = new int[7];
            for (int j = 0; j < 7; j++) {
                sByColor[j] = 0;
            }
            sByColors.add(sByColor);
        }
        for (int i = 0; i < tshirtsList.size(); i++) {
            for (Tshirt tshirt : tshirtsList.get(i)) {
                sByColors.get(i)[tshirt.getColors().ordinal()]++;
            }
        }

        if (ascOrDesc.equals("asc")) {
            for (int i = 0; i < tshirtsList.size(); i++) {
                Tstruct[] allColors = new Tstruct[7];
                int counter = 0;
                for (int j = 0; j < 7; j++) {
                    allColors[j] = new Tstruct();
                    if (sByColors.get(i)[j] == 0) {
                        allColors[j].start = -1;
                        allColors[j].end = -1;
                    } else {
                        allColors[j].start = counter;
                        allColors[j].end = counter + sByColors.get(i)[j];
                        subLists.add(tshirtsList.get(i).subList(allColors[j].start, allColors[j].end));
                    }
                    counter += sByColors.get(i)[j];

                }
            }
        }

        if (ascOrDesc.equals("desc")) {
            for (int i = 0; i < tshirtsList.size(); i++) {
                Tstruct[] allColors = new Tstruct[7];
                int counter = 0;
                for (int j = 6; j >= 0; j--) {
                    allColors[j] = new Tstruct();
                    if (sByColors.get(i)[j] == 0) {
                        allColors[j].start = -1;
                        allColors[j].end = -1;
                    } else {
                        allColors[j].start = counter;
                        allColors[j].end = counter + sByColors.get(i)[j];
                        subLists.add(tshirtsList.get(i).subList(allColors[j].start, allColors[j].end));
                    }
                    counter += sByColors.get(i)[j];

                }
            }
        }
        return subLists;
    }

    /* A utility function to print array of size n */
    public static void printArray(List<Tshirt> tshirts) {
        int n = tshirts.size();
        for (int i = 0; i < n; ++i) {
            System.out.println(tshirts.get(i).toString() + " ");
        }
    }

    public static void quickSortDemonstration() {
        List<Tshirt> tshirts = Tshirt.makeRandomTshirts(40);
        System.out.println("Unsorted list.");
        System.out.println("---------------");
        printArray(tshirts);
        System.out.println("");
        System.out.println("Size in ascending order with Quick Sort.");
        System.out.println("------------------------------------------");
        quickSortTshirtsByColorsOrSizeOrFabric(tshirts, "asc", Size.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Size in descending order with Quick Sort.");
        System.out.println("------------------------------------------");
        quickSortTshirtsByColorsOrSizeOrFabric(tshirts, "desc", Size.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Colors in ascending order with Quick Sort.");
        System.out.println("-------------------------------------------");
        quickSortTshirtsByColorsOrSizeOrFabric(tshirts, "asc", Colors.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Colors in descending order with Quick Sort.");
        System.out.println("--------------------------------------------");
        quickSortTshirtsByColorsOrSizeOrFabric(tshirts, "desc", Colors.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Fabric in ascending order with Quick Sort.");
        System.out.println("-------------------------------------------");
        quickSortTshirtsByColorsOrSizeOrFabric(tshirts, "asc", Fabric.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Fabric in descending order with Quick Sort.");
        System.out.println("--------------------------------------------");
        quickSortTshirtsByColorsOrSizeOrFabric(tshirts, "desc", Fabric.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Sorted first by Size, then by Colors and lastly by Fabric in ascending order with Quick Sort.");
        System.out.println("----------------------------------------------------------------------------------------------");
        sortTshirtsByColorsAndSizeAndFabric(tshirts, "asc", QuickSort.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Sorted first by Size, then by Colors and lastly by Fabric in descending order with Quick Sort.");
        System.out.println("-----------------------------------------------------------------------------------------------");
        sortTshirtsByColorsAndSizeAndFabric(tshirts, "desc", QuickSort.class);
        printArray(tshirts);
        System.out.println("");

    }

    public static void bubbleSortDemonstration() {
        List<Tshirt> tshirts = Tshirt.makeRandomTshirts(40);
        System.out.println("Unsorted list.");
        System.out.println("---------------");
        printArray(tshirts);
        System.out.println("");
        System.out.println("Size in ascending order with Bubble Sort.");
        System.out.println("-------------------------------------------");
        bubbleSortTshirtsByColorsOrSizeOrFabric(tshirts, "asc", Size.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Size in descending order with Bubble Sort.");
        System.out.println("--------------------------------------------");
        bubbleSortTshirtsByColorsOrSizeOrFabric(tshirts, "desc", Size.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Colors in ascending order with Bubble Sort.");
        System.out.println("---------------------------------------------");
        bubbleSortTshirtsByColorsOrSizeOrFabric(tshirts, "asc", Colors.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Colors in descending order with Bubble Sort.");
        System.out.println("----------------------------------------------");
        bubbleSortTshirtsByColorsOrSizeOrFabric(tshirts, "desc", Colors.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Fabric in ascending order with Bubble Sort.");
        System.out.println("---------------------------------------------");
        bubbleSortTshirtsByColorsOrSizeOrFabric(tshirts, "asc", Fabric.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Fabric in descending order with Bubble Sort.");
        System.out.println("----------------------------------------------");
        bubbleSortTshirtsByColorsOrSizeOrFabric(tshirts, "desc", Fabric.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Sorted first by Size, then by Colors and lastly by Fabric in ascending order with Bubble Sort.");
        System.out.println("------------------------------------------------------------------------------------------------");
        sortTshirtsByColorsAndSizeAndFabric(tshirts, "asc", BubbleSort.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Sorted first by Size, then by Colors and lastly by Fabric in descending order with Bubble Sort.");
        System.out.println("-------------------------------------------------------------------------------------------------");
        sortTshirtsByColorsAndSizeAndFabric(tshirts, "desc", BubbleSort.class);
        printArray(tshirts);
        System.out.println("");
    }
    
    public static void bucketSortDemonstration(){
        List<Tshirt> tshirts = Tshirt.makeRandomTshirts(40);
        System.out.println("Unsorted list.");
        System.out.println("---------------");
        printArray(tshirts);
        System.out.println("");
        System.out.println("Sorted by Size in ascending order with Bucket Sort.");
        System.out.println("-----------------------------------------------------");
        bucketSortTshirtsByColorsOrSizeOrFabric(tshirts, "asc", Size.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Sorted by Size in descending order with Bucket Sort.");
        System.out.println("------------------------------------------------------");
        bucketSortTshirtsByColorsOrSizeOrFabric(tshirts, "desc", Size.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Sorted by Colors in ascending order with Bucket Sort.");
        System.out.println("-------------------------------------------------------");
        bucketSortTshirtsByColorsOrSizeOrFabric(tshirts, "asc", Colors.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Sorted by Colors in descending order with Bucket Sort.");
        System.out.println("--------------------------------------------------------");
        bucketSortTshirtsByColorsOrSizeOrFabric(tshirts, "desc", Colors.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Sorted by Fabric in ascending order with Bucket Sort.");
        System.out.println("-------------------------------------------------------");
        bucketSortTshirtsByColorsOrSizeOrFabric(tshirts, "asc", Fabric.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Sorted by Fabric in descending order with Bucket Sort.");
        System.out.println("-------------------------------------------------------");
        bucketSortTshirtsByColorsOrSizeOrFabric(tshirts, "desc", Fabric.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Sorted first by Size, then by Colors and lastly by Fabric in ascending order with Bucket Sort.");
        System.out.println("-----------------------------------------------------------------------------------------------");
        sortTshirtsByColorsAndSizeAndFabric(tshirts, "asc", BucketSort.class);
        printArray(tshirts);
        System.out.println("");
        System.out.println("Sorted first by Size, then by Colors and lastly by Fabric in descending order with Bucket Sort.");
        System.out.println("------------------------------------------------------------------------------------------------");
        sortTshirtsByColorsAndSizeAndFabric(tshirts, "desc", BucketSort.class);
        printArray(tshirts);
        System.out.println("");
    }
    
    public static void fullDemonstration(){
        quickSortDemonstration();
        bubbleSortDemonstration();
        bucketSortDemonstration();
    }
}
