public class DailyTemperatures {
        public int[] dailyTemperatures(int[] temperatures) {

            // int[] result = new int[T.length];
            // for (int day = T.length - 1; day >= 0; day--)
            //     for (int i = day - 1; i >= 0 && T[i] < T[day]; i--)
            //         result[i] = day - i;
            // return result;

            int [] result = new int [temperatures.length];

            for(int i = 0; i < temperatures.length; i++) {
                for(int j = i+1; j < temperatures.length && temperatures[i] > temperatures[j]; j++) {
                    result[i] = j-i;

                }
            }
            return result;
        }
}
