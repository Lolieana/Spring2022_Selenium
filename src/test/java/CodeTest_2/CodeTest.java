package CodeTest_2;
import Web.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CodeTest {


    /**
     * Ques-2:
     * Verify feelsLike-temp value is in between the low-temp value and high-temp value
     * Web: https://www.darksky.net/
     * points: 20
     */

    @Test
    public void verifyFeelsLinkTempRange() {
        MyDriver.launchUrlOnNewWindow("https://www.darksky.net/");
        String hiTemp = "//span[@class='high-temp-text']";
        By hiTempXpath = By.xpath(hiTemp);
        WebElement hiTempfound = MyDriver.getDriver().findElement(hiTempXpath);
        String hi = hiTempfound.getText();
        String removeDegree = hi.split("˚")[0];
        int hiDegree =  Integer.valueOf(removeDegree);

        String lowTemp = "//span[@class='low-temp-text']";
        By lowTempXpath = By.xpath(lowTemp);
        WebElement lowTempfound = MyDriver.getDriver().findElement(lowTempXpath);
        String low = lowTempfound.getText();
        String removeDegree_2 = low.split("˚")[0];
        int lowDegree =  Integer.valueOf(removeDegree_2);

        String feelsLikeTemp = "//span[@class='feels-like-text']";
        By feelsLikeTempXpath = By.xpath(feelsLikeTemp);
        WebElement feelsLikeTempfound = MyDriver.getDriver().findElement(feelsLikeTempXpath);
        String feels = feelsLikeTempfound.getText();
        String removeDegree_3 = feels.split("˚")[0];
        int feelsDegree =  Integer.valueOf(removeDegree_3);
        Assert.assertTrue( feelsDegree <= hiDegree && feelsDegree >= lowDegree ,"Feels like temp is not in between HiTemp and LowTemp " );

    }


    public static void main ( String[] args ) {

        System.out.println("*** Question 1 Get Factorial ***");
        int question2_A = 5;
        System.out.println(getFactorial(question2_A));

        int question2_B = 1;
        System.out.println(getFactorial(question2_B));

        int question2_C = 3;
        System.out.println(getFactorial(question2_C));

        int question2_D = 10;
        System.out.println(getFactorial(question2_D));



        System.out.println("*** Question 2 Get Common Value ***");
        String[] question3_A = {"happY", "king", "peace", "living standard"};
        String[] question3_B =  {"king kong", "Happy", "PEACE"};
        System.out.println(Arrays.toString(getCommonVal(question3_A,question3_B)));

        String[] question3_C = {"ab", "abcd", "abc", "abcde", "defg", "koli"};
        String[] question3_D =  {"abcde", "jhuy", "plot", "koli"};
        System.out.println(Arrays.toString(getCommonVal(question3_C,question3_D)));


        System.out.println("*** Question 3 Get Smallest Missing Int ***");
        int[] question4_A = {3, 5, 1, 4, 2, 7};
        System.out.println(getSmallestMissingInt(question4_A));

        int[] question4_B = {3, 5, 1, 4, 2};
        System.out.println(getSmallestMissingInt(question4_B));

        int[] question4_C = {2, 5, -1, 0, 6};
        System.out.println(getSmallestMissingInt(question4_C));

        int[] question4_D = {0, 5, -1, 1, 2, 5, 3, 7, 1, 2};
        System.out.println(getSmallestMissingInt(question4_D));

        int[] question4_E = {-2, -5, -1, -10, -6};
        System.out.println(getSmallestMissingInt(question4_E));

    }


        /**
         * Ques-1:
         * Create a method to return factorial value of input-int-value
         * points: 10
         */
        /*
         *
         * eg:
         * input -> 5
         * returned value -> (5*4*3*2*1) = 120
         *
         * input -> 1
         * returned value -> (1) = 1
         *
         * input -> 3
         * returned value -> (3*2*1) = 6
         *
         * input -> 10
         * returned value -> (10*9*8*7*6*5*4*3*2*1) =
         */

        public static int getFactorial ( int number) {
            int factorialValue = 1;
            for ( int i=1; i<=number; i++) {
                factorialValue = factorialValue * i;
            }
            return factorialValue;
        }

        /**
         * Ques-3:
         * Create a method to return the common Strings values in two input-String-arrays
         * points: 30
         * Note: two input-String-arrays can be of same size or different size
         */
        /*
         *
         * eg:
         * input -> {"happY", "king", "peace", "living standard"} , {"king kong", "Happy", "PEACE"}
         * returned value -> [happy, peace]
         *
         * input -> {“ab”, “abcd”, “abc”, “abcde”, “defg”, "koli”} , {“abcde”, “jhuy”, “plot”, “koli”}
         * returned value -> [abcde, koli]
         *
         */

        public static String[] getCommonVal (String[] str_1 , String[] str_2) {

            Set<String> words = new HashSet<>();

            for ( String value1 : str_1) {
                for ( String value2 : str_2) {
                    if ( value1.equalsIgnoreCase(value2)) {
                        words.add(value1);
                    }
                }
            }

            String[] outputArray = new String[words.size()];
            words.toArray(outputArray);

            return outputArray;
        }


    /**
     * Ques-4:
     * Create a method to return missing smallest positive integer (greater than 0) from given int-array.
     * points: 40
     */
    /*
     *
     * eg:
     * 	input -> : {3, 5, 1, 4, 2, 7}
     * 	returned value : 6
     *
     * 	input -> : {3, 5, 1, 4, 2}
     * 	returned value : 6
     *
     * 	input -> {2, 5, -1, 0, 6}
     * 	returned value : 1
     *
     * 	input -> {0, 5, -1, 1, 2, 5, 3, 7, 1, 2}
     * 	returned value : 4
     *
     * 	input -> {-2, -5, -1, -10, -6}
     * 	returned value : 1
     *
     */

    public static int getSmallestMissingInt ( int[] givingArr) {
        int returnNum =1;
        for ( int i=0; i<=givingArr.length-1; i++ ) {
            if ( givingArr[i] == returnNum) {
                returnNum = givingArr[i];
                returnNum++;
                i = -1;
            }
        }
        return returnNum;
    }

}
