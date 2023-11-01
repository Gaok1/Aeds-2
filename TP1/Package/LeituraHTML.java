import java.io.*;
import java.net.*;

public class LeituraHTML {

   public static String getHtml(String endereco) {
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream(); // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      }

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;
   }

   public static int getBr(String frase, int[] array) {
      int countbr = 0;
      String br = "<br>";

      for (int i = 0; i < frase.length(); i++) {
         if (frase.charAt(i) == '<') {
            int count = 0;
            for (int j = 0; j < 4; j++) {
               if (frase.charAt(i + j) == br.charAt(j)) {
                  count++;
               }
            }
            if (count == 4) {
               array[23]++;
            }
         }
      }
      return countbr;
   }

   public static void getTable(String frase, int[] array) {

      String br = "<table>";

      for (int i = 0; i < frase.length(); i++) {
         if (frase.charAt(i) == '<') {
            int count = 0;
            for (int j = 0; j < 7; j++) {
               if (frase.charAt(i + j) == br.charAt(j)) {
                  count++;
               }
            }
            if (count == 7) {
               array[24]++;
               array[0]--;
               array[1]--;
               array[22] -= 3;
            }
         }
      }

   }

   public static void getAEIOU(String frase, int[] array) {

      for (int i = 0; i < frase.length(); i++) {

         if (frase.charAt(i) == 'a') {
            array[0]++;
         } else if (frase.charAt(i) == 'e') {
            array[1]++;
         } else if (frase.charAt(i) == 'i') {
            array[2]++;
         } else if (frase.charAt(i) == 'o') {
            array[3]++;
         } else if (frase.charAt(i) == 'u') {
            array[4]++;
         } else if (frase.charAt(i) >= 'a' && frase.charAt(i) <= 'z') {
            array[22]++;
         }
      }

   }

   public static void getAEIOUAGUDO(String frase, int[] array) {

      for (int i = 0; i < frase.length(); i++) {

         if (frase.charAt(i) == '\u00e1') {
            array[5]++;
         } else if (frase.charAt(i) == '\u00e9') {
            array[6]++;
         } else if (frase.charAt(i) == '\u00ed') {
            array[7]++;
         } else if (frase.charAt(i) == '\u00f3') {
            array[8]++;
         } else if (frase.charAt(i) == '\u00fa') {
            array[9]++;
         }
      }

   }

   public static void getAEIOUCRASE(String frase, int[] array) {

      for (int i = 0; i < frase.length(); i++) {

         if (frase.charAt(i) == '\u00e0') {
            array[10]++;
         } else if (frase.charAt(i) == '\u00e8') {
            array[11]++;
         } else if (frase.charAt(i) == '\u00ec') {
            array[12]++;
         } else if (frase.charAt(i) == '\u00f2') {
            array[13]++;
         } else if (frase.charAt(i) == '\u00f9') {
            array[14]++;
         }
      }

   }

   public static void getAEIOUTIW(String frase, int[] array) {

      for (int i = 0; i < frase.length(); i++) {

         if (frase.charAt(i) == '\u00e3') {
            array[15]++;
         } else if (frase.charAt(i) == '\u00f5') {
            array[16]++;
         }
      }

   }

   public static void getAEIOUCIRCUNFLEXO(String frase, int[] array) {

      for (int i = 0; i < frase.length(); i++) {

         if (frase.charAt(i) == '\u00e2') {
            array[17]++;
         } else if (frase.charAt(i) == '\u00ea') {
            array[18]++;
         } else if (frase.charAt(i) == '\u00ee') {
            array[19]++;
         } else if (frase.charAt(i) == '\u00f4') {
            array[20]++;
         } else if (frase.charAt(i) == '\u00fb') {
            array[21]++;
         }
      }

   }

   public static void chamarfunc(String frase, int[] array, String nome) {
      getAEIOU(frase, array);
      getAEIOUAGUDO(frase, array);
      getAEIOUCIRCUNFLEXO(frase, array);
      getAEIOUCRASE(frase, array);
      getAEIOUTIW(frase, array);
      getBr(frase, array);
      getTable(frase, array);
      MyIO.println("a(" + array[0] + ") e(" + array[1] + ") i(" + array[2] + ") o(" + array[3] + ") u(" + array[4]
            + ") á(" + array[5] + ") é(" + array[6] + ") í(" + array[7] + ") ó(" + array[8] + ") ú(" + array[9] + ") à("
            + array[10] + ") è(" + array[11] + ") ì(" + array[12] + ") ò(" + array[13] + ") ù(" + array[14] + ") ã("
            + array[15] + ") õ(" + array[16] + ") â(" + array[17] + ") ê(" + array[18] + ") î(" + array[19] + ") ô("
            + array[20] + ") û(" + array[21] + ") consoante(" + array[22] + ") <br>(" + array[23] + ") <table>("
            + array[24] + ") " + nome);

   }

   public static void main(String[] args) {
      String endereco, html, nome;

      while (true) {

         nome = MyIO.readLine();
         if (igual(nome)) {
            break;
         }

         endereco = MyIO.readLine();

         int[] array = new int[26];

         html = getHtml(endereco);

         chamarfunc(html, array, nome);

      }

   }

   static boolean igual(String frase) { // veririca tamanho e caracter por caracter para ver se é igual a FIM

      if (frase.length() == 3 && frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M') {
         return true;
      } else {
         return false;
      }

   }
}
