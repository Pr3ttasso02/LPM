public class Dois {
  public static void main(String[] args) {

    int i = Integer.MAX_VALUE;
    float f = Float.MAX_VALUE;
    double d = Double.MAX_VALUE;

    System.out.println("Maior inteiro positivo: " + i);
    System.out.println("Maior inteiro negativo: " + (i + 1));
    System.out.println("Maior float positivo: " + f);
    System.out.println("Maior double positivo: " + d);

    System.out.printf("Maior float positivo: %.2f\n", f);
    System.out.printf("Maior double positivo: %.2f\n", d);

  }
}
