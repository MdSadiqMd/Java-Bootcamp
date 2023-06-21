/*
💡 You have a long flowerbed in which some plots are planted, and some are not.
However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
 */
public class Possible_Number_of_Plots {
    public static int canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i=1;i<flowerbed.length-1;i++){
            if((flowerbed[i-1]==0 && flowerbed[i]==0 && flowerbed[i+1]==0)){
                count++;
            }
        }
        if(flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length-2]==0){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 0};
        int n = 1;
        int result = canPlaceFlowers(flowerbed, n);
        System.out.println(result);
    }
}

