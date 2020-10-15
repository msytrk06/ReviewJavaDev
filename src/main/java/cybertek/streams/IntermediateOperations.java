package cybertek.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntermediateOperations {

    public static void main(String[] args) {

        Integer[] numbersArray = {1,2,3,4,5,6,7,8,9,10};
        Stream<Integer> numbersStream = Arrays.stream(numbersArray);

        System.out.println("***********FILTER***********");

        //fILTER
        System.out.println(numbersStream.filter(number -> number%2 !=0).count());

        Stream<String> strStream = Arrays.asList("Apple","Orange","Kiwi","Banana", "Apple","Cheery","Mango").stream();
        System.out.println(strStream.filter(str -> str.length() == 5).count());

        //System.out.println(strStream.filter(str -> str.startsWith("A")).count()); //ERROR

        Arrays.asList("Apple","Orange","Kiwi","Banana", "Apple","Cheery","Mango").stream().filter(str -> str.equals("Apple")).forEach(str -> System.out.println(str));






    }
}
