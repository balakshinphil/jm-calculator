public class Numeral {

  public static String arabicToRoman(int arabicNumeral) {
    int arabicValue[] = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    String romanValue[] = { "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    String romanNumeral = "";

    for (int i = 0; i < arabicValue.length; i++) {
      while (arabicValue[i] <= arabicNumeral) {
        romanNumeral += romanValue[i];
        arabicNumeral -= arabicValue[i];
      }
    }

    return romanNumeral;
  }

  private static int valueOfRomanNumeral(char romanNumeral) {
    switch (romanNumeral) {
    case 'I':
      return 1;
    case 'V':
      return 5;
    case 'X':
      return 10;
    default:
      return -1;
    }
  }

  public static int romanToArab(String romanNumeral) throws Exception {
    int res = 0;

    for (int i = 0; i < romanNumeral.length(); i++) {
      int s1 = valueOfRomanNumeral(romanNumeral.charAt(i));
      if (s1 == -1) {
        throw new Exception();
      }
      if (i + 1 < romanNumeral.length()) {
        int s2 = valueOfRomanNumeral(romanNumeral.charAt(i + 1));
        if (s2 == -1) {
          throw new Exception();
        }
        if (s1 >= s2) {
          res += s1;
        } else {
          res += s2 - s1;
          i++;
        }
      } else {
        res += s1;
        i++;
      }
    }

    return res;
  }

  public static boolean isArabic(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      int d = Integer.parseInt(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }
}
