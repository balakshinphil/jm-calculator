public class Solution {
  private String firstNumber;
  private String secondNumber;
  private char operation;
  private boolean areAllNumbersArabic = false;
  private String result;

  public Solution(String firstNumber, String secondNumber, char operation) throws Exception {
    this.firstNumber = firstNumber;
    this.secondNumber = secondNumber;
    this.operation = operation;
    this.areAllNumbersArabic = areNumbersArabic();
    this.result = solve();
  } 

  private String solve() throws Exception {
    if (areAllNumbersArabic) {
      int a = Integer.parseInt(this.firstNumber);
      int b = Integer.parseInt(this.secondNumber);
      return calculate(a, b, this.operation);
    } else {
      int a = Numeral.romanToArab(this.firstNumber);
      int b = Numeral.romanToArab(this.secondNumber);
      int result = Integer.parseInt(calculate(a, b, this.operation));
      return Numeral.arabicToRoman(result);
    }
  }


  private String calculate(int a, int b, char operation) {
    String result;
    switch (this.operation) {
        case '+':
          result = String.valueOf(a+b);
          break;
        case '-':
          result = String.valueOf(a-b);
          break;
        case '*':
          result = String.valueOf(a*b);
          break;
        case '/':
          result = String.valueOf(a/b);
          break;
        default:
          result = null;
          break;
    }
    return result;
  }
  

  private boolean areNumbersArabic() throws Exception {
    if (Numeral.isArabic(this.firstNumber) && Numeral.isArabic(this.secondNumber)) {
      return true;
    } else if (Numeral.isArabic(this.firstNumber) && !Numeral.isArabic(this.secondNumber) || !Numeral.isArabic(this.firstNumber) && Numeral.isArabic(this.secondNumber)) {
      throw new Exception();
    }

    return false;
  }

  public String getResult() {
    return this.result;
  }
}