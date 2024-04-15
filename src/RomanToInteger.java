public class RomanToInteger {

    private static int startPos = 0;
    private static int result = 0;
    private static int [] array;

    public int romanToInt(String s) {
        result = 0;
        getNumArray(s);
        while (startPos < array.length) {
            result += getSubValue(array);
        }
        startPos = 0;
        return result;
//        System.out.println(result);
    }

    private int getSubValue(int[] numArray) {
        int i1 = numArray[startPos];
        int prevVal = numArray[startPos];
        startPos++;
        for (int i = startPos; i < numArray.length; i++) {
            int currentVal = numArray[i];
            if (currentVal > prevVal) {
                startPos++;
                return currentVal - prevVal;
            } else if (currentVal == prevVal) {
                startPos++;
                i1 += currentVal;
            } else {
                return i1;
            }
        }
        return i1;
    }

    private void getNumArray(String input) {
        array = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            switch(input.charAt(i)) {
                case 'I': array[i] = 1; break;
                case 'V': array[i] = 5; break;
                case 'X': array[i] = 10; break;
                case 'L': array[i] = 50; break;
                case 'C': array[i] = 100; break;
                case 'D': array[i] = 500; break;
                case 'M': array[i] = 1000; break;
            }
        }
    }

//    private Map<Character, Integer> fillInitialMap() {
//        Map<Character, Integer> map = new HashMap<>();
//        map.put('M', 1000);
//        map.put('D', 500);
//        map.put('C', 100);
//        map.put('L', 50);
//        map.put('X', 10);
//        map.put('V', 5);
//        map.put('I', 1);
//        return map;
//    }

}
