/*
Stream API is used to perform operations on the data in Collection Interface by creating a different Stream of Data
We cannot do more than one +operation on a stream for other methods we need to create other Streams
 */
import java.util.*;
import java.util.stream.Stream;  //***
public class _4_Stream_API {
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(10,30,20,40,50);
        Stream<Integer> stream =list.stream(); //Created a separate Stream for the data ,and we can apply operations on that data
        stream.forEach(n-> System.out.println(n));

        Stream<Integer> sortedStream =stream.sorted();
        stream.forEach(n-> System.out.println(n));
    }
}
