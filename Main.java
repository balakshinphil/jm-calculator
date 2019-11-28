import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    String inputString = buffer.readLine();
    Expression expression = new Expression(inputString);
    Solution solution = new Solution(expression.getFirstNumber(), expression.getSecondNumber(), expression.getOperation());
    System.out.println(solution.getResult());
  }
}
