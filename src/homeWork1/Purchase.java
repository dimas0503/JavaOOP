package homeWork1;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dima on 02.10.2015.
 */
public class Purchase {
    private int count;
    private HashMap<Product, Integer> productList = new HashMap<>();

    public void addProduct(Product product, int count) {
        if (productList.containsKey(product)){
            productList.put(product,productList.get(product)+count);
        }else {
            productList.put(product,count);
        }
    }

    public void removeProduct(Product product, int count) {
        if (productList.containsKey(product)){

            int prCount = (int) productList.get(product);
            if (count >= prCount){
                productList.remove(product);
            }else {
                productList.put(product,prCount - count);
            }
        }
    }

    public double closePurchase(){
        double totalSum = 0;
        for (Map.Entry<Product,Integer> product: productList.entrySet()){
            totalSum += product.getValue();
        }
        return totalSum;
    }
}
