/*
Approach :
Take the Ration of Items and Profit and sort them in Descending Order and add the starting Objects
 */
import java.util.Arrays;
import java.util.Comparator;

public class _1_Fractional_KnapSack {
    private static double getMaxValue(ItemValue[] arr, int capacity) {
        Arrays.sort(arr, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue item1, ItemValue item2) {
                double cpr1 = (double) item1.value / item1.weight;
                double cpr2 = (double) item2.value / item2.weight;

                // Sort in decreasing order of value-to-weight ratio
                if (cpr1 < cpr2) return 1;
                else if (cpr1 > cpr2) return -1;
                else return 0;
            }
        });

        double totalValue = 0d;

        for (ItemValue i : arr) {
            int curWt = i.weight;
            int curVal = i.value;

            if (capacity - curWt >= 0) {
                capacity -= curWt;
                totalValue += curVal;
            } else {
                double fraction = (double) capacity / curWt;
                totalValue += curVal * fraction;
                break;
            }
        }

        return totalValue;
    }

    static class ItemValue {
        int value, weight;

        public ItemValue(int val, int wt) {
            this.weight = wt;
            this.value = val;
        }
    }

    public static void main(String[] args) {
        ItemValue[] arr = {
                new ItemValue(10, 19),
                new ItemValue(120, 60),
                new ItemValue(90, 34),
                new ItemValue(23, 87)
        };

        int capacity = 48;

        double maxValue = getMaxValue(arr, capacity);
        System.out.println(maxValue);
    }
}
