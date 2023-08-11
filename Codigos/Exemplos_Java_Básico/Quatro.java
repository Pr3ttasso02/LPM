import java.util.Scanner;
import java.time.LocalDateTime;

public class Quatro {
    
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int mat;
        LocalDateTime data = LocalDateTime.now();
        
        System.out.print("Qual é a sua matrícula? ");
        mat = Integer.parseInt(leitor.nextLine());
        System.out.println("Olá, "+mat+".");
        if(data.getHour()<13)
          System.out.println("Bom dia.");
        else if(data.getHour()>19)
                System.out.println("Boa noite.");
        leitor.close();
    }
}
