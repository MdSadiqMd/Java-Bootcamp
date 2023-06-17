/*
Refer Notes for understanding
 */
public class _3_Permutation_of_Given_String {
    public static String Swap(String Input,int StartIndex,int LastIndex){
        char temp;
        char[] charArray=Input.toCharArray();
        temp=charArray[StartIndex];
        charArray[StartIndex]=charArray[LastIndex];
        charArray[LastIndex]=temp;
        return String.valueOf(charArray);
    }
    public static void Permutation(String Input,int StartIndex,int LastIndex){
        if(StartIndex==LastIndex){
            System.out.println(Input);
        }
        else{
            for(int i=StartIndex;i<=LastIndex;i++){
                Input=Swap(Input,StartIndex,LastIndex);
                Permutation(Input,StartIndex+1,LastIndex);
                Input=Swap(Input,StartIndex,i);
            }
        }
    }
    public static void main(String[] args) {
        String Input="Sadiq";
        Permutation(Input,0,4);
    }
}
