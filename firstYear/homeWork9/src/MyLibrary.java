public class MyLibrary {

    public void writeTenTimesName(String name, String surname) {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " " + surname);
        }
    }

    public void writeFiveOddNumbers() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i * 2 + 1);
        }
    }

    public int sumNNums(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public int sumOddNums(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i * 2 + 1;
        }
        return sum;
    }

    public double sumFractionalNums(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (double) 1/i;
        }
        return sum;
    }

    public void writePowersTwo() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("2 ^ " + i + " = " + (int) Math.pow(2,i));
        }
    }

    public int calcFactorial(int n){
        if (n<2) return 1;
        return n*calcFactorial(n-1);
    }

    public void writeFunctionTable() {
        for (double i = -2; i <= 2; i+=0.25) {
            System.out.println("-2,4*("+i+")+5*("+i+")-3 = " + (-2.4*Math.pow(i,2)+5*i-3));
        }
    }

    public void writeTenRandNumsAndAverage(){
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int randX= (int) (Math.random() * 10);
            sum+=randX;
            System.out.println(randX);
        }
        System.out.println("Average of that 10 random numbers is " + (double) sum/10);
    }

    public boolean isNumPrime (int n) {
        for (int i = 2; i*i < n; i++) {
            if(n%i==0) return false;
        } return true;
    }
}
