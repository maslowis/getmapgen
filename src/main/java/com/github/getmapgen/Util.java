package com.github.getmapgen;

/**
 * Class provide useful method for processing strings
 *
 * @author maslowis
 */
public final class Util {

    private Util() {
    }

    /**
     * Split string to string array
     *
     * @param arg source string
     * @return array strings
     */
    public static String[] splitString(String arg) {
        return arg.split("(, \\n|,\\n)|(, |,)|( \\n|\\n)|( )");
    }

    /**
     * Convert string array to integer array
     *
     * @param args source string array
     * @return integer array
     */
    public static int[] stringToInt(String[] args) {
        int[] result = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            result[i] = Integer.valueOf(args[i]);
        }
        return result;
    }

}
