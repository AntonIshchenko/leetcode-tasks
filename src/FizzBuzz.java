import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        String[] result = new String[n];
        for (int i = 1; i <= n; i++) {
            result[i-1] = String.valueOf(i);
        }
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result[i - 1] = "FizzBuzz";
                continue;
            }
            if (i % 3 == 0) {
                result[i - 1] = "Fizz";
            }
            if (i % 5 == 0) {
                result[i - 1] = "Buzz";
            }
        }
        return List.of(result);
    }

}
