/*
 * This program was written by Fernando Herrera
 * Reuse of this code is permitted provided that the work is properly sourced.
 */
package vigenerecrack;

import java.util.Arrays;

/**
 *
 * @author fhj
 */
public class Backend {
  
  char alpha[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                 'U', 'V', 'W', 'X', 'Y', 'Z'};
  
  
  public String caesarEncipher(String text, int key) {
    int shift;
    String upperCased = text.toUpperCase();
    String result;
    char temp[] = upperCased.toCharArray();
    
    for (int i = 0; i < temp.length; ++i) {
      shift = (i+key) % 26;
      temp[i] = alpha[shift];
    }
    result = Arrays.toString(temp).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
    return result;
  }
  
  public String caesarDecipher(String text, int key) {
    int shift;
    String upperCased = text.toUpperCase();
    String result;
    char temp[] = upperCased.toCharArray();
    
    for (int i = 0; i < temp.length; ++i) {
      for (int j = 0; j < alpha.length; ++j) {
        if (temp[i] == alpha[j]) {
          shift = (26+j-key) % 26;
          temp[i] = alpha[shift];
          break;
        }
      }
    }
    result = Arrays.toString(temp).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
    return result;
  } 
 
  public String vigenereEncipher(String text, String key) {
    int shift;
    String result;
    char tempText[] = text.toUpperCase().toCharArray();
    char tempKey[] = key.toUpperCase().toCharArray();
    int keyOfInts[] = new int[tempKey.length];
    
    for (int i = 0; i < tempKey.length; ++i) {
      for (int j = 0; j < alpha.length; ++j) {
        if (tempKey[i] == alpha[j]) {
         keyOfInts[i] = j; 
        }
      }
    }
    
    int move = 0;
    for (int i = 0; i < tempText.length; ++i) {
      for (int j = 0; j < alpha.length; ++j) {
        if (tempText[i] == alpha[j]) {
          if (move == keyOfInts.length) {
            move = 0;
          }
          shift = (keyOfInts[move++] + j) % alpha.length;
          tempText[i] = alpha[shift];
          break;
        }
      }
    }
    result = Arrays.toString(tempText).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
    return result;
    
  }
  
  public String vigenereDecipher(String text, String key) {
    int shift;
    String result;
    char tempText[] = text.toUpperCase().toCharArray();
    char tempKey[] = key.toUpperCase().toCharArray();
    int keyOfInts[] = new int[tempKey.length];
    
    for (int i = 0; i < tempKey.length; ++i) {
      for (int j = 0; j < alpha.length; ++j) {
        if (tempKey[i] == alpha[j]) {
         keyOfInts[i] = j; 
        }
      }
    }
    
    int move = 0;
    for (int i = 0; i < tempText.length; ++i) {
      for (int j = 0; j < alpha.length; ++j) {
        if (tempText[i] == alpha[j]) {
          if (move == keyOfInts.length) {
            move = 0;
          }
          shift = (alpha.length + j - keyOfInts[move++]) % alpha.length;
          tempText[i] = alpha[shift];
          break;
        }
      }
    }
    result = Arrays.toString(tempText).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
    return result;
  }
  
}
