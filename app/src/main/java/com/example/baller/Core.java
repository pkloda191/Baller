package com.example.baller;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Core
{
    public static Baller[] ballers = new Baller[100];
    public static String[] theBallerStrings = new String[100];
    private static int numBallers = 0;

    public static void addBaller(Baller ba)
    {
        //encapsulated the logic of adding patient records here
        Core.ballers[Core.numBallers] = ba;
        Core.theBallerStrings[Core.numBallers] = ba.toString();
        Core.numBallers++;
    }

    public static String getBallers()
    {
        return Arrays.toString(ballers);
    }

}
