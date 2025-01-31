package NonTraversalLoops;

public class BurritoCalculator {

    public static int getBurritoQuantity(int burritoCost) {
        int budget = 4267;

        int numBurritos = 0;
        while (budget >= burritoCost) {
            numBurritos++;
            budget -= burritoCost;
        }
        return numBurritos;
    }

    public static boolean hasLeftOverFunds(int burritoCost) {
        int budget = 100;
        int numBurritos = 0;

        while (budget >= burritoCost) {
            numBurritos++;
            budget -= burritoCost;
        }

        if (budget == 0) {
            return false;
        }

        System.out.println("Remaining budget: " + budget);
        return true;

    }

    public static int getBurritosSold(int lastOrderNumber) {
        int totalBurritoSold = 0;
        for(int i = 0; i <= lastOrderNumber; i++) {
            totalBurritoSold +=i;
        }
        return totalBurritoSold;

    }

    public static int getNumDivisibleOrders(int modulo, int lastOrderNumber) {
        int numDivisibleOrders = 0;

        for(int i = 0; i <= lastOrderNumber; i++) {
            if (i % modulo == 0) {
                numDivisibleOrders++;
            }
        }
        return numDivisibleOrders;
    }

    public static int getTip(int budget) {
        int maxDigit = 0;

        while (budget > 0) {
            int digit = budget % 10; //gets the digit in the ones column
            if (digit > maxDigit) {
                maxDigit = digit;
            }
            budget /= 10; //moves to look at the next digit by 'chopping' off last digit
        }
        return maxDigit * 900;
    }

    public static int getReverseBudget(int budget) {
        int reverseBudget = 0;

        while (budget > 0) {
            int digit = budget % 10;
            budget /= 10;
            reverseBudget = (reverseBudget * 10) + digit;
        }
        return reverseBudget;
    }

    public static void main(String[] args) {
        System.out.println(getBurritoQuantity(7));
        System.out.println(hasLeftOverFunds(9));
        System.out.println(getBurritosSold(5));
        System.out.println(getNumDivisibleOrders(8,32));
        System.out.println(getReverseBudget(948576));
    }
}
