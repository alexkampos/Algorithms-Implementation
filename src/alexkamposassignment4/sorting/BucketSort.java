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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexk
 */
public class BucketSort {

    public static List<Tshirt> bucketSortTshirtsByColorsOrSizeOrFabric(List<Tshirt> tshirts, String ascOrDesc, Class<?> type) {
        List<Tshirt> sortedTshirts = new ArrayList();
        // Create bucket array
        List<Tshirt>[] buckets = new List[7];
        // Associate a list with each index 
        // in the bucket array         
        for (int i = 0; i < 7; i++) {
            buckets[i] = new ArrayList();
        }
        // sort buckets
        if (type == Size.class) {
            for (Tshirt tshirt : tshirts) {

                buckets[tshirt.getSize().ordinal()].add(tshirt);
            }
        }
        if (type == Colors.class) {
            for (Tshirt tshirt : tshirts) {

                buckets[tshirt.getColors().ordinal()].add(tshirt);
            }
        }
        if (type == Fabric.class) {
            for (Tshirt tshirt : tshirts) {

                buckets[tshirt.getFabric().ordinal()].add(tshirt);
            }
        }

        // Merge buckets to get sorted list
        int counter = 0;
        if (ascOrDesc.equals("asc")) {
            for (int i = 0; i < buckets.length; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    tshirts.set(counter++, buckets[i].get(j));
                }
            }
        }
        if (ascOrDesc.equals("desc")) {
            for (int i = 0; i < buckets.length; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    counter++;
                }
            }
            counter-=1;
            for (int i = 0; i < buckets.length; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    tshirts.set(counter--, buckets[i].get(j));
                }
            }
        }
        return tshirts;
    }
}
