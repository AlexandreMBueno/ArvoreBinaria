// Alexandre Bueno
import java.util.Scanner;

public class arvore01 {

  // Funçao
  public static int buscaBinaria(int[] dados, int x, int inferior, int superior) {
    if (inferior > superior) {
      return -1; // Elemento não encontrado
    }
    int meio = (inferior + superior) / 2;
    if (x == dados[meio]) {
      return meio; //encontrou
    }
    if (x < dados[meio]) {
      return buscaBinaria(dados, x, inferior, meio - 1); 
    } else {
      return buscaBinaria(dados, x, meio + 1, superior); 
    }
  }

  public static void ordenacaoBubble(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          // trocare os elementos se nn tiverem em ordem
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Digite o tamanho desejado para o vetor:");
    int n = scan.nextInt();
    int[] dados = new int[n];
    System.out.println("Digite os elementos do vetor(programa ira ordena-los em ordem): ");

    for (int i = 0; i < n; i++) {
      dados[i] = scan.nextInt();
    }

    ordenacaoBubble(dados); // Bubble Sort serve para ordenar

    System.out.println("Digite o elemento que voce deseja encontrar:");
    int valor = scan.nextInt();
    int inferior = 0;
    int superior = dados.length - 1;
    int resultadoBusca = buscaBinaria(dados, valor, inferior, superior);

    if (resultadoBusca == -1) {
      System.out.println("Elemento não existe no vetor");
    } else {
      System.out.println("Elemento foi encontrado no indice: " + resultadoBusca);
    }

    scan.close();
  }
}
