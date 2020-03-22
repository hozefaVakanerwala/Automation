package Utils;

import java.io.IOException;
import java.util.Random;

/**
 * Created by michael.pollino on 10/12/2015.
 */
public class Utilities {
    // takes the full name of the process, such as excel.exe
    public static void killProcess(String processName) throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM " + processName);
    }

    public static void runCommandLine(String command) throws IOException {
        Runtime.getRuntime().exec(command);
    }


    public static String getRandom() {
        String[] array = {"Pass", "Fail"};
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }


}
