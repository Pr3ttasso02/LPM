import java.util.Scanner;

public class Cinco {
    public static void main(String[] args) {
        Scanner leitorTeclado = new Scanner(System.in);
        
        char c;
        String string;

        System.out.print("Digite seu nome: ");
        string = leitorTeclado.nextLine();

        System.out.print("Digite um caractere: ");
        c = leitorTeclado.next().charAt(0);

        System.out.println("Caractere: "+c);
        System.out.printf("Caractere como número: %d",c);
        System.out.println("String: "+string);

        leitorTeclado.close();
    }
}
