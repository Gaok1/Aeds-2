/**
 * fialcircularDOmingues
 */
public class FilaCircularDomingues {

  int[] array = { 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7 };
  int primeiro = 4, ultimo = 3;

  FilaCircularDomingues() {


  }

  

  void inserir(int x) throws Exception {
    if (((ultimo + 1) % array.length) == primeiro)
      throw new Exception("Erro!");
    array[ultimo] = x;
    ultimo = (ultimo + 1) % array.length;
  }

  int remover() throws Exception {
    if (primeiro == ultimo)
      throw new Exception("Erro!");
    int resp = array[primeiro];
    primeiro = (primeiro + 1) % array.length;
    return resp;
  }

  void mostrar() {
    int i = primeiro;
    System.out.print("[");
    while (i != ultimo) {
      System.out.print(array[i] + " ");
      i = (i + 1) % array.length;
    }
    System.out.println("]");
  }

  int tam() {
    return (primeiro < ultimo)
        ? (ultimo - primeiro)
        : (array.length - (primeiro - ultimo));
  }

  int meio() {
    return (primeiro + (tam() / 2)) % array.length;
  }

  boolean buscaBinaria(int target) {
    int esq = primeiro;
    int tam = tam();
    int dir = ultimo;
    boolean flag = true;
    
    while (flag) {
      int meio = esq + (tam / 2) % array.length;
      tam = tam / 2;

      if (array[meio] == target) {
        return true;
      } else if (array[meio] < target) {
        if (esq == dir) {
          flag = false;
        }
        esq = (meio + 1) % array.length;
      } else {
        if (esq == dir) {
          flag = false;
        }
        dir = (meio - 1) % array.length;
      }
    }
    return false;
  }

  public static void main(String args[]) {
    FilaCircularDomingues fila = new FilaCircularDomingues();


    // printar fila
    fila.mostrar();
    for (int i = 0; i < 11; i++) {
      System.out.println("busca binaria de " + i + " = " + fila.buscaBinaria(i));
  }

  }
}