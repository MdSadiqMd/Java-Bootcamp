public class _8_String_Methods {
    public static void main(String[] args) {
        String name = "Sadiq";

        //finding length of the string using length()
        int value=name.length();
        System.out.println(value);

        //converting string to lower case using toLowerCase()
        String a=name.toLowerCase();
        System.out.println(a);

        //converting string to upper case using toUpperCase()
        String b=name.toUpperCase();
        System.out.println(b);

        //trim means the string without space using trim()
        String c="   sadiq    ";
        System.out.println(c);
        System.out.println(c.trim());

        //indexing in strings using substring(start,end)
        System.out.println(name.substring(2));//it means 2:
        System.out.println(name.substring(1,4)); //it means it will print the string from 1,2,3 but not string at 4th index

        //replace means replacing the string value by other using replace(old letter,new letter)
        System.out.println(name.replace('d','D'));
        System.out.println(name.replace("adi","D"));//use double quotations while replacing a long string with an alphabet
        System.out.println(name.replace("adi","ADI"));

        //checking whether a string start with the letter or not using startWith()
        System.out.println(name.startsWith("adi"));//give false as name start with sad

        //checking whether a string end with the letter or not using endsWith()
        System.out.println(name.endsWith("diq"));//return true as it end with diq

        //char at use to return a value at the index given using charAt()
        System.out.println(name.charAt(2));//return value of index 2

        //indexOf used to return index of the value
        System.out.println(name.indexOf("S"));
        //suppose there are two same letters in a string like harry has two r's so for that we use the different one
        String g="haddry";
        System.out.println(g.indexOf("ddry",0));//here the index of the digit will be print after given index if the substring is not present in string it returns -1
        System.out.println(name.lastIndexOf("ddry",0));//it returns last index of the given string

        //equals used to see if the strings are equal or not using .equals
        System.out.println(name.equals("Sadiq"));//return true as it is equal

        //equals ignore case used to check the string is equal or not irrespective of case
        System.out.println(name.equalsIgnoreCase("saDIq"));

        //escape sequence characters
        // if we want a double quotation in a print statement we can't as the double quotations are used to print and close a statement
        // for closing we use  black lash characters \ not /
        // black lash characters are \' , \" , \t , \n
        System.out.println("iam escape sequence  \\ double quote");
        System.out.println("iam escape sequence  \n double quote");// it will print the remaining statement in a new line
        System.out.println("iam escape sequence  \t double quote");// it will give a tab space and print remaining statement
    }
}
