package com.example.boombz.myapplication.Utils;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

/**
 * Created by boombz on 23/09/16.
 */
public class CipherUtils {

    /**
     * Method that converts hexadecimal to string
     * @param hexa Hexadecimal to convert
     * @return Converted string
     */
    private static String hextoString (String hexa) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < hexa.length(); i+=2) {
            String str = hexa.substring(i, i+2);
            output.append((char)Integer.parseInt(str, 16));
        }
        return output.toString();
    }

    /**
     * Method that converts byte array to hexadecimal
     * @param bytes The byte array to convert
     * @return Converted string
     */
    //final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
    private static String bytesToHex(byte[] bytes) {
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     * Method that converts hexadecimal to byte array
     * @param s Hexadecimal to convert
     * @return Converted byte array
     */
    private static byte[] hexToBytes(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    /**
     *
     * @param inputDec
     * @param keyString
     * @param ivString
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws ShortBufferException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String encrypt(String inputDec, String keyString, String ivString) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, ShortBufferException, BadPaddingException, IllegalBlockSizeException {
        /*
        byte[] keyBytes = keyString.getBytes();
        byte[] ivBytes = ivString.getBytes();

        byte [] inputByte = inputDec.getBytes();

        // wrap key data in Key/IV specs to pass to cipher
        SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        // create the cipher with the algorithm you choose
        // see javadoc for Cipher class for more info, e.g.


        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        byte[] encrypted= new byte[cipher.getOutputSize(inputByte.length)];
        int enc_len = cipher.update(inputByte, 0, inputByte.length, encrypted, 0);
        enc_len += cipher.doFinal(encrypted, enc_len);

        return bytesToHex(encrypted);
        */
        return inputDec;
    }

    /**
     * Method to decrypt a string
     *
     * @param inputEnc Encrypted string
     * @param keyString Key to decrypt
     * @param ivString IV to decrypt
     * @return Plain text String
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws ShortBufferException
     */
    public static String decrypt(String inputEnc, String keyString, String ivString) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, ShortBufferException {
        /*
        byte[] keyBytes = keyString.getBytes();
        byte[] ivBytes = ivString.getBytes();

        byte [] inputByte = hexToBytes(inputEnc);

        // wrap key data in Key/IV specs to pass to cipher
        SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        // create the cipher with the algorithm you choose
        // see javadoc for Cipher class for more info, e.g.
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);

        //int enc_len = cipher.update(encrypted, 0, encrypted.length, encrypted, 0);
        int enc_len = inputByte.length;
        byte[] decrypted = new byte[cipher.getOutputSize(enc_len)];
        int dec_len = cipher.update(inputByte, 0, enc_len, decrypted, 0);
        try {
            dec_len += cipher.doFinal(decrypted, dec_len);
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (ShortBufferException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        */
        return inputEnc;
    }

}
