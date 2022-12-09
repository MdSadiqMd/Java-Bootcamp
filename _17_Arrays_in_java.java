import javax.lang.model.SourceVersion;

public class _17_Arrays_in_java {
    public static void main(String[] args) {

        //there are three ways to create an array
        /*
        1)int[] marks;
          marks=new int[5]
        2)int[] marks ={1,2,3,4,5}
        3)
        */
        int [] marks = new int[5]; //here the array of name is marks and it stores 5 elements
        //if we want we can create an floating array like syntax:float[] marks=new int[5]
        //if we want we can create an string array like syntax:string[] marks=new int[5]
        //entering values in array
        marks[0]=1;
        marks[1]=2;
        marks[2]=3;
        marks[3]=4;
        marks[4]=5; //here only upto 4 as five elements of index from 1 to 4
        System.out.println(marks[2]);

        //using length of array
        System.out.println(marks.length);  //it prints the length of the array

        //printing array  using for loop
        System.out.println("printing values in array:");
        for (int i=0;i<marks.length;i++){
            System.out.println(marks[i]);
        }

        //printing array in reverse order using for loop
        System.out.println("printing values in array in reverse order:");
        for (int i=marks.length -1;i>=0;i--){
            System.out.println(marks[i]);
        }

        //for-each loop *********
        System.out.println("printing array using for each loop:");
        for (int element: marks){  //syntax: for(datatype element:array name)
            System.out.println(element); //print element not array name
        }

        /*multidimensional arrays
        if there is an array inside an array it is called 2D array
        if there is an another array inside the the array it is called 3D array
         */


        //creating an 2D array
        int [][] twoD=new int[2][3]; //it form an array of name twoD and of two elements having three elements in each
        twoD [0][0]=1;
        twoD [0][1]=2;
        twoD [0][2]=3;
        twoD [1][0]=4;
        twoD [1][1]=5;
        twoD [1][2]=6;
        //printing value of an array
        System.out.println("two dimensional array output:");
        System.out.println(twoD[0][1]);

        //printing elements in array using for loop
        System.out.println("printing twoD array using loop");
        for (int i=0;i<twoD.length;i++){        //this for loop used to print the elements of the array
            for(int j=0;j<twoD[i].length;j++){  //this for loop used to print the array of the elements of the array
                System.out.print(twoD[i][j]);
                System.out.print(" "); //this used for gap in between the numbers
            }
            System.out.println("");
        }

        //creating an 3D array
        System.out.println("three dimensional array output:");
        int [][][] threeD=new int[2][1][2];
        threeD [0][0][0] = 1;
        threeD [0][0][1] = 2;
        threeD [1][0][0] = 3;
        threeD [1][0][1] = 3;
        System.out.println(threeD[0][0][0]);

        //crating an array of strings
        System.out.println("three dimensional String array output:");
        String [][][] string3D=new String[2][1][2];
        string3D [0][0][0] = String.valueOf("a");
        string3D [0][0][1] = String.valueOf("b");
        string3D [1][0][0] = String.valueOf("c");
        string3D [1][0][1] = String.valueOf("d");
        System.out.println(string3D[0][0][0]);

        //finding a value in the array
        System.out.println("finding value in the array");
        float[] find={1.2f,3.4f,5.6f,7.8f,9.1f}; //here we are creating an float array sol put f at last in every element
        boolean isINArray=false;
        for (float element:find){
            if (5==element){
                isINArray =true;
                break;
            }
        }
        if(isINArray){
            System.out.println("the number is present in the array");
        }
        else{
            System.out.println("the number is not present in the array");
        }

        //adding two matrices
        System.out.println("adding two matrices:");
        int [][] mat1={{1,2,3},{4,5,6}};
        int [][] mat2={{1,2,3},{4,5,6}};
        int [][] result={{0,0,0},{0,0,0}};
        for(int i=0;i<mat1.length;i++){         //row number of times
            for(int j=0;j<mat1[i].length;j++){  //column number of times
                result[i][j]=mat1[i][j] + mat2[i][j];
                System.out.print(result[i][j]+ " ");
            }
            System.out.println("");
        }

        //java program to reverse an array
        System.out.println("reversing an array:");
        //we will do it by swapping the elements for odd number of elements in the array
        //let there is an array of length of 4 (even) elements then there will be replace it by Length-1-i where i increses l-1 because index start with zero
        int[] reverse={2,3,4,5};
        int l=reverse.length;
        int s=Math.floorDiv(l,2); //here we are finding the mid length value of the array
        int temp;
        for (int i=0;i<s;i++){
            temp=reverse[i];
            reverse[i]=reverse[s-1-i];
            reverse[s-1-i]=temp;
        }
        for ( int element:reverse){
            System.out.print(element+ " ");

        }

        //finding maximum element in an array
        System.out.println("maximum element in an array");
        int[] maxele={1,2,3,4,5};
        int max=0;
        for(int element:maxele){
            if(element>max){
                max=element;
            }
        }
        System.out.println(max);

        //to check whether a array is sorted or not
        System.out.println("sorting of array");
        int[] sorted={1,3,2,4,5};//here array is not sorted as 2 is less than 3 and three had appeared first
        boolean isSorted=true;
        for(int i=0;i<sorted.length;i++){
            if(sorted[i]>sorted[i+1]){    //here the value checks its next element whether sorted or not
                isSorted=false;
                break;
            }
        }
        if(isSorted){
            System.out.println("array is sorted");
        }
        else{
            System.out.println("array is not sorted");
        }
    }
}

