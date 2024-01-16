public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 100000; i++) {
            System.out.println(i);
            int sum = 0;
            for (int j = 1; j <= i / 2; j++) {
                if(i%j==0)
                    sum+=j;
            }
            if(sum==i)
                System.out.print(i + " ");
        }
    }
}
