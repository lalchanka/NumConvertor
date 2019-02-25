/**
 * The Convertor class includes functions that allow you to convert
 * inputed number (represented in String format) from one numeral
 * system to enother.
 */

public class Convertor {
    /**  */
    public String baseString = "0123456789ABСDEFGHIJKLMNOPQRSTUVWXYZ";      //String with all digits 0=0, 1=1,..,Y=34, Z=35

    public int inputToInt(String inputNumber, int inputBase) {         //Converts a number(inpNum) with base(inpBase) to int
        char tempChar;
        int tempInt;
        int result = 0;

        for (int i = 0, p = inputNumber.length() - 1; i < inputNumber.length(); i++, p--) {
            tempChar = inputNumber.charAt(i);

            if (baseString.indexOf(tempChar) != -1) {
                tempInt = baseString.indexOf(tempChar);
            } else
            {
                tempInt = 0;
                break;
            }

            result += Math.pow(inputBase, p) * tempInt;
        }

        return result;
    }


    public String intToOutput(int inpVal, int outpBase) {         //Converts int number(inpVal) with base(outpBase) to String
        String finalString = "", temp = "";
        int flr = outpBase + 1, rst;

        while (flr >= outpBase) {
            rst = inpVal % outpBase;
            flr = Math.floorDiv(inpVal, outpBase);

            inpVal = flr;
            finalString = Character.toString(baseString.charAt(rst)) + finalString;
        }

        finalString = Character.toString(baseString.charAt(flr)) + finalString;
        return finalString;
    }
}
