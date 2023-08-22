import java.util.Scanner;

public class Seis {
    
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        double a, b;
        double res;

        a = Integer.parseInt(leitor.nextLine());
        b = leitor.nextInt();

        res = a*b;
        
        System.out.println(a + " * "+b+" = "+res);
        leitor.close();
    }
}
