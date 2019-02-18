package com.example.baller;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Core
{
    private static Baller[] ballers = new Baller[10];
    private static int numBallers = 0;

    public static void addBaller(Baller ba)
    {
        //encapsulated the logic of adding patient records here
        Core.ballers[Core.numBallers] = ba;
        Core.numBallers++;
    }

    public static String getBallers()
    {
        return Arrays.toString(ballers);
    }

}
