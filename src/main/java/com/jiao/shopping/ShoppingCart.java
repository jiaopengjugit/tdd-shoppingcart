package com.jiao.shopping;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by jiaopengju on 16/3/20.
 */
public class ShoppingCart {
    private int amount;
    private HashMap<Product, Integer> map;
    private double totalCost;

    public ShoppingCart() {
        map = new HashMap<>();
    }

    public int getAmount() {
        return amount;
    }

    public void addProduct(Product product) {
        if (map.containsKey(product)){
            map.put(product, map.get(product) + 1);
        }else {
            map.put(product, 1);
        }
        amount ++;
    }

    public int getProductNumber(Product product) {
        return map.containsKey(product) ? map.get(product) : 0;
    }

    public void removeProduct(Product product) {
        if (!map.containsKey(product)){
            throw new RuntimeException();
        }
        map.remove(product);
        amount --;
    }

    public double getTotalCost() {
        Set<Product> set = map.keySet();
        for (Product product : set){
            totalCost += product.getPrice() * map.get(product);
        }
        return totalCost;
    }
}
