import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Calculator {
    public int Add(String... num) {
        int sum = 0;
        for (String arg : num) {
            if (arg.contains("-")) {
                throw new IllegalArgumentException("Throws exception with Negatives not allowed: -1, -3");
            }
        }
        if (num[0].equals("") && num.length < 2) {
            return sum;
        }

        //Change char array to string array delimited by commars then trying to parse an integer and if it can it puts it in a new array that sums up
//        the numbers

        String numString = String.join(",", num);
        if (numString.contains("//"))
        {
            String[] test = numString.split("\n");
            var uncleanedDelims = test[0];
            var numbersToParse = test[1];

            String[] delims = returnDelimiters(uncleanedDelims);

            // "1,2,3"
            numString = ReplaceDelimsWithComma(delims, numbersToParse);
        }
        else
        {
            numString = numString.replace("\n", ",");
        }

        // Safe from here
        String[] numbersAsStrings = numString.split(",");

        return sumNumbers(numbersAsStrings);
//
//        String tostring = Arrays.toString(num);
//        List<String> elephantList1 = Arrays.asList(tostring.split(","));
//        if ((!elephantList1.toString().contains("\n")) && (num.length < 2)) {
//            for (String arg : elephantList1) {
//                String new1 = arg.replace("[", "");
//                String new2 = new1.replace("]", "");
//                if (Integer.parseInt(new2) < 1000) {
//                    sum += IntStream.of(Integer.parseInt(new2)).sum();
//                    return sum;
//                }
//            }
//        }
//
//        char[] checknum = tostring.toCharArray();
//        for (char arg : checknum) {
//            if (Character.isDigit(arg)) {
//                sum += IntStream.of(Character.getNumericValue(arg)).sum();
//            }
//        }
//        return sum;
    }

    public int sumNumbers(String[] numbers)
    {
        int sum = 0;
        for (String num:numbers) {
            Integer changed = Integer.parseInt(num);
            if(changed < 1000) {
                sum += changed;
            }
        }
        return sum;
    }

    public String ReplaceDelimsWithComma(String[] delims, String stringToClean)
    {
        System.out.println(stringToClean);
        for (String arg:delims) {
            stringToClean = stringToClean.replace(arg,",");
    }
        return stringToClean;
    }

    public String[] returnDelimiters(String delims) {

        // [*1*][%]
        delims = delims.replace("//", "");

        // *1*]%]
        delims = delims.replace("[", "");

        // *1*, %
        String[] delimsSplit = delims.split("]");


        System.out.println(Arrays.toString(delimsSplit));
        return delimsSplit;
    }

}
