import org.junit.Assert;
import org.junit.Test;
import java.util.stream.IntStream;

//public int total(ArrayList<Card> playerDeck) {
//        Integer sum = 0;
//        for (Card item : playerDeck) {
//        if ((item.getValue() == 11) && (IntStream.of(item.value).sum() < 22)) {
//        item.setValue(1);
//        System.out.println("value changed to 1");
//        }
//        sum += IntStream.of(item.value).sum();
//        }
//        return sum;
//        }

public class TestClass {
    public int Add(String... num) {
        int sum = 0;
        String tostring = num.toString();
        char[] checknum = tostring.toCharArray();
        if(num[0].equals("") && num.length < 2) {
            return sum;
        }
        for (String arg : num) {
            int converted = Integer.parseInt(arg);
            sum += IntStream.of(converted).sum();

        }
        return sum;
    }
    @Test
    public void Return0() {
        int actual = Add("");
        int expected = 0;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void returnsNumber() {
        int actual = Add("1");
        int expected = 1;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addsTwoNumbers() {
        int actual = Add("2","2");
        int expected = 4;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addsMultipleNumbers() {
        int actual = Add("3","5","3","9");
        int expected = 20;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void regexTest() {
        int actual = Add("1,2\n3");
        int expected = 20;
        Assert.assertEquals(expected,actual);
    }
}
