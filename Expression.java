public class Expression {
  private String expression;
  private String firstNumber;
  private String secondNumber;
  private char operation;

  public Expression(String expression) throws Exception {
    String newExpression = "";
    for (char ch : expression.toCharArray()) {
      if (ch != ' ') {
        newExpression += ch;
      }
    }
    this.expression = newExpression;

    int operationIndex;
    if (this.expression.indexOf('+') != -1) {
      operationIndex = this.expression.indexOf('+');
    } else if (this.expression.indexOf('-') != -1) {
      operationIndex = this.expression.indexOf('-');
    } else if (this.expression.indexOf('*') != -1) {
      operationIndex = this.expression.indexOf('*');
    } else if (this.expression.indexOf('/') != -1) {
      operationIndex = this.expression.indexOf('/');
    } else {
      throw new Exception();
    }

    this.operation = this.expression.charAt(operationIndex);

    this.firstNumber = this.expression.substring(0, operationIndex);
    this.secondNumber = this.expression.substring(operationIndex + 1, this.expression.length());
  }  

  public String getFirstNumber() {
    return this.firstNumber;
  }

  public String getSecondNumber() {
    return this.secondNumber;
  }

  public char getOperation() {
    return this.operation;
  }
}