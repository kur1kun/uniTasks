public class Tester {
    public static void main(String[] args) {
        MyLibrary api = new MyLibrary();

        //First test
        System.out.println("\nFirst method test:");
        String name = "Oleksii";
        String surname = "Kostyk";
        api.writeTenTimesName(name, surname);

        //Second test
        System.out.println("\nSecond method test:");
        api.writeFiveOddNumbers();

        //Third test
        System.out.println("\nThird method test:");
        int num3 = 3;
        System.out.println(api.sumNNums(num3));

        //Fourth test
        System.out.println("\nFourth method test:");
        int num4 = 4;
        System.out.println(api.sumOddNums(num4));

        //Fifth test
        System.out.println("\nFifth method test:");
        int num5 = 5;
        System.out.println(api.sumFractionalNums(num5));

        //Sixth test
        System.out.println("\nSixth method test:");
        api.writePowersTwo();

        //Seventh test
        System.out.println("\nSeventh method test:");
        int num7 = 4;
        System.out.println(api.calcFactorial(num7));

        //Eighth test
        System.out.println("\nEighth method test:");
        api.writeFunctionTable();

        //Ninth test
        System.out.println("\nNinth method test:");
        api.writeTenRandNumsAndAverage();

        //Tenth test
        System.out.println("\nTenth method test:");
        int num10 = 20;
        System.out.println(api.isNumPrime(num10) ? num10 + " is prime" : num10 + " isn't prime");
    }
}
