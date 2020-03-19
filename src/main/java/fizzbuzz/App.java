package fizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * App to run Fizz Buzz
 *
 */
public class App 
{
    enum Stage {
        ONE,
         TWO }

    public static String fizzBuzz(Stage stage){
        if(stage==Stage.ONE) {
           return IntStream.rangeClosed(1, 100).mapToObj(
                    i -> i % 3 == 0 ?
                            (i % 5 == 0 ? "FizzBuzz" : "Fizz") :
                            (i % 5 == 0 ? "Buzz" : i))
                   .map(String::valueOf)
                   .collect(Collectors.joining(System.lineSeparator()));
        }else if (stage==Stage.TWO){
            return IntStream.rangeClosed(1, 100).boxed().map(
                    i -> i % 3 == 0 || i.toString().contains("3") ?
                            (i % 5 == 0 || i.toString().contains("5") ? "FizzBuzz" : "Fizz") :
                            (i % 5 == 0 || i.toString().contains("5")? "Buzz" : i))
                    .map(String::valueOf)
                    .collect(Collectors.joining(System.lineSeparator()));
        }
        return null;
    }

    public static void main( String[] args )
    {
        System.out.println(App.fizzBuzz(Stage.ONE));
        System.out.println();
        System.out.println(App.fizzBuzz(Stage.TWO));
    }
}
