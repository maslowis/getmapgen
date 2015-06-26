/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Ivan Maslov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.getmapgen;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * Class provide useful method for processing strings
 *
 * @author maslowis
 */
public final class Util {
    private static final Logger log = Logger.getLogger(Util.class);

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

    /**
     * Serialize a object in the file
     *
     * @param object   {@link java.lang.Object}
     * @param fileName name of file in which will saved serialized object
     */
    public static void serialize(Object object, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(
                    System.getProperty("user.dir") + File.separator + fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            log.error(e);
        }
    }

    /**
     * Deserialize a object from the file
     *
     * @param fileName name of file in which saved serialized object
     * @return {@link java.lang.Object}
     */
    public static Object deserialize(String fileName) {
        Object object = null;
        try {
            FileInputStream fileIn = new FileInputStream(
                    System.getProperty("user.dir") + File.separator + fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            object = in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            log.error(e);
        }
        return object;
    }

}
