/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexkamposassignment4.tshirt;

import alexkamposassignment4.enums.Colors;
import alexkamposassignment4.enums.Fabric;
import alexkamposassignment4.enums.Size;
import alexkamposassignment4.utils.UtilMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author alexk
 */
public class Tshirt {
     private Colors colors;
    private Fabric fabric;
    private Size size;

    public Colors getColors() {
        return colors;
    }

    public void setColors(Colors colors) {
        this.colors = colors;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Tshirt(Colors colors, Fabric fabric, Size size) {
        this.colors = colors;
        this.fabric = fabric;
        this.size = size;
    }

    public static List<Tshirt> makeRandomTshirts(int count){
        Random rand = new Random();
        List<Tshirt> randomTshirts = new ArrayList();
        for(int i=0; i<count; i++){
            randomTshirts.add(new Tshirt(UtilMethods
                    .getEnumValueByNumber(UtilMethods.getRandomNumberFromOneToSix(),Colors.class), 
                    UtilMethods.getEnumValueByNumber(UtilMethods.getRandomNumberFromOneToSix(), Fabric.class),
                    UtilMethods.getEnumValueByNumber(UtilMethods.getRandomNumberFromOneToSix(), Size.class)));
        }
        return randomTshirts;
    }
    
    public static Tshirt makeTshirt(Colors colors, Fabric fabric, Size size){
        return new Tshirt(colors, fabric, size);
    }

    @Override
    public String toString() {
        return "TShirt{" + "colors=" + colors + ", fabric=" + fabric + ", size=" + size + '}';
    }
}
