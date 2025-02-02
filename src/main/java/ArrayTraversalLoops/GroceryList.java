package ArrayTraversalLoops;

import java.util.ArrayList;
import java.util.Arrays;

public class GroceryList {

    public static double getTotalCost(double[] groceryPrices) {
        double totalCost = 0.0;

        //calculate the sum of all groceryPrices
        for (double itemCost : groceryPrices) {
            totalCost += itemCost;
        }
        return totalCost;
    }

    public static double getMostExpensiveItemCost(double[] groceryPrices) {
        double maxCost = groceryPrices[0];

        for (double itemCost : groceryPrices) {
            if (itemCost > maxCost) {
                maxCost = itemCost;
            }
        }
        return maxCost;
    }

    public static double getCheapestItemCost(double[] groceryPrices) {

        double minCost = groceryPrices[0];

        for (double itemCost : groceryPrices) {
            if (itemCost < minCost) {
                minCost = itemCost;
            }
        }
        return minCost;
    }

    public static int getNumAllergicItems(String[] groceryList) {
        int numAllergicItems = 0;

        for(int i = 0; i < groceryList.length; i++) {
            if (groceryList[i].length() > 5) {
                numAllergicItems++;
            }
        }

        return numAllergicItems;
    }

    public static boolean hasSpecialItem (double[] groceryPrices) {
        for (double itemCost : groceryPrices) {
            String itemCostStr = String.format("%.2f", itemCost);
            if (itemCostStr.endsWith("99")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        double[] groceryPrices = {10.0, 12.3, 8.45, 2.43};
        System.out.println(getTotalCost(groceryPrices));

        double[] unlikelyGroceryPrices = {100.23, -100.23, 0.0, -78.54};
        System.out.println(getTotalCost(unlikelyGroceryPrices));

        double[] groceryPrices2 = {10.0, 12.3, 8.45, 2.34};
        System.out.println(getMostExpensiveItemCost(groceryPrices2));
        System.out.println(getCheapestItemCost(groceryPrices2));

        String[] groceryList3 = {"apple", "milk", "banana", "bananas", "chocolate"};
        System.out.println(getNumAllergicItems(groceryList3));

        double[] groceryList = {10.0, 89.9, 8.99, 2.34};
        System.out.println(hasSpecialItem(groceryList));
    }
}
