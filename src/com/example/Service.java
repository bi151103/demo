package com.example;
import com.example.model.manager.*;
import com.example.model.user.*;
import java.util.*;

public abstract class Service {
    protected static ArrayList<ProductForSale> products;//list of all products in store
    protected static ArrayList<ProductForSale> newProducts;//list of new products
    protected static ArrayList<ProductForSale> saleOffProducts;//list of saleOffProducts
    public static BestSeller getBestSeller() {
        /*get bestSeller based on number of items sold of each product*/
        int max = ManagerService.products.get(0).getNoOfSolds();
        ProductForSale bestSeller = ManagerService.products.get(0);
        int noOfBrands = ManagerService.getNoOfBrands();
        for(int i = 1; i < noOfBrands; i++) {
            ProductForSale product = ManagerService.products.get(i);
            int noOfSolds = product.getNoOfSolds();
            if(noOfBrands > max) {
                bestSeller = product;
                max = noOfSolds;
            }
        }
        return new BestSeller(bestSeller, max);
    }
    public static ArrayList<ProductForSale> getProducts(String prodPath) {
        //get all products
        return products;
    }
    public static ArrayList<ProductForSale> getSaleOffProducts() {
        //get sale off products
        return saleOffProducts;
    }
    public static ArrayList<ProductForSale> getNewProducts() {
        //get new products
        return newProducts;
    }
}