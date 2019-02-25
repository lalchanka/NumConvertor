import java.util.Scanner;

public class MainClass {


    public static void main(String[] args) {
        String input = "", output = "", symbolTable = "";
        boolean finishWork = false;                         //Changes on "true" if you choose "N" after conversion
        Scanner inp = new Scanner(System.in);
        Convertor conv = new Convertor();
        int middleIntValue, inBase, outBase;

        System.out.println("Hi there! I`m a num convertor. \nWrite ur num using a table below this msg");
        for (int i = 0; i < conv.baseString.length(); i++) {
            symbolTable += " \"" + conv.baseString.charAt(i) + "\" - " + i + ";";
            if ((i + 1) % 6 == 0) {
                symbolTable += "\n";
            }
        }
        System.out.println(symbolTable);
        while (!finishWork) {               //Continues conversation while you chose 'N' after conversion
            String tempStr = "";

            System.out.println("Ur number:");
            while (true) {                  //Continues conversation while you input correct data
                input = inp.nextLine();

                for (int i = 0; i < input.length(); i++) {
                    if (conv.baseString.indexOf(input.charAt(i)) == -1) {     //Check if baseString contains i-char
                        tempStr = Character.toString(input.charAt(i));
                        System.out.println("What means ur \"" + tempStr + "\" symbol?\n" +
                                "Maybe u will try to type more carefully?");
                        break;
                    }
                }

                if (tempStr == "") {
                    //inp.close();
                    break;
                }
            }

            System.out.println("The inputed num base is:");
            while (true) {              //Continues conversation while you input correct data
                boolean finishLoop = true;    //This var finishes while loop
                inBase = inp.nextInt();

                if (inBase > 1 && inBase < 36) {
                    for (int i = 0; i < input.length(); i++) {
                        if (conv.baseString.indexOf(input.charAt(i)) >= inBase) {
                            finishLoop = false;
                            System.out.println("Noo! That`s not true base!\n" +
                                    "Hint: Try all digits in ur number to be less than inputed base");
                            break;
                        }
                    }

                    if (finishLoop) {
                        break;
                    }
                } else
                {
                    System.out.println("Your base is incorrecto!!\n" +
                            "Hint: Try to choose out of range 2-35");
                }
            }

            System.out.println("And the output:");
            while (true) {              //Continues conversation while you input correct data
                outBase = inp.nextInt();

                if (outBase > 1 && outBase < 36) {
                    break;
                } else
                {
                    System.out.println("Don`t make me angry with ur wrong data!\n" +
                            "Hint: Try to choose out of range 2-35");
                }
            }

            middleIntValue = conv.inputToInt(input, inBase);
            output = conv.intToOutput(middleIntValue, outBase);

            System.out.println("And the answ is: " + output);
            System.out.println("Wanna convert again? (Y/N)");
            while (true) {              //Continues conversation while you input correct data
                String str = "";
                inp.next();
                str = inp.nextLine();  //Почему не работет по людски с этой строкой?


                if (str.toUpperCase().equals("Y")) {
                    System.out.println("Ok. Let`s do it!");
                    break;
                } else if (str.toUpperCase().equals("N")) {
                    System.out.println("It was a great fun! See ya!");
                    finishWork = true;
                    break;
                } else {
                    System.out.println("I do not wanna play ur creepy games.\n" +
                            "Find someone else or input correct letties!");
                }
            }
        }
    }
}
