public class NumberOfStepsToReduceNumberToZero {

    public int numberOfSteps(int num) {
        String binaryString = Integer.toBinaryString(num);

        int firstPart = binaryString.length() - 1;
        int secondPart = binaryString.replace("0", "").length();

        return firstPart+secondPart;
    }

    public static void main(String[] args) {
        int i = new NumberOfStepsToReduceNumberToZero().numberOfSteps(555);
        System.out.println(i);
    }
}
