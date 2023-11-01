import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Letra {
    
    public static String GetHtml(String urlString) {

        try {

            URL url = new URL(urlString);

            // Abra uma conexão com a URL
            URLConnection connection = url.openConnection();

            // Crie um BufferedReader para ler os dados da URL
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Variável para armazenar as linhas lidas do HTML
            String linha;
            StringBuilder total = new StringBuilder(); // Usar StringBuilder para concatenação eficiente

            // Loop para ler e adicionar cada linha do HTML ao StringBuilder
            while ((linha = reader.readLine()) != null) {
                total.append(linha);
            }

            // Feche o BufferedReader
            reader.close();
            return total.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Retornar null em caso de erro
    }

    public static String handleHtml(String html) {
        String resultado = "";
        // devo encontrar essa string <div class="lyric-original">
        // <div class="viewFractions"> ler ate essa

        for (int i = 0; true; i++) {
            if (html.charAt(i) == '<' && html.charAt(i + 1) == 'd' && html.charAt(i + 2) == 'i'
                    && html.charAt(i + 3) == 'v' && html.charAt(i + 4) == ' ' && html.charAt(i + 5) == 'c'
                    && html.charAt(i + 6) == 'l' && html.charAt(i + 7) == 'a' && html.charAt(i + 8) == 's'
                    && html.charAt(i + 9) == 's' && html.charAt(i + 10) == '=' && html.charAt(i + 11) == '"'
                    && html.charAt(i + 12) == 'l' && html.charAt(i + 13) == 'y' && html.charAt(i + 14) == 'r'
                    && html.charAt(i + 15) == 'i' && html.charAt(i + 16) == 'c' && html.charAt(i + 17) == '-'
                    && html.charAt(i + 18) == 'o' && html.charAt(i + 19) == 'r' && html.charAt(i + 20) == 'i'
                    && html.charAt(i + 21) == 'g' && html.charAt(i + 22) == 'i' && html.charAt(i + 23) == 'n'
                    && html.charAt(i + 24) == 'a' && html.charAt(i + 25) == 'l' && html.charAt(i + 26) == '"'
                    && html.charAt(i + 27) == '>') {
                for (int j = i + 28; true; j++) {
                    if (html.charAt(j) == '<' && html.charAt(j + 1) == '/' && html.charAt(j + 2) == 'd'
                            && html.charAt(j + 3) == 'i' && html.charAt(j + 4) == 'v' && html.charAt(j + 5) == '>') {
                        break;
                    }
                    resultado += html.charAt(j);
                }
                break;
            }
        }

        return resultado;
    }

    // reomver tag <p> e substituir tag <br> por \n
    public static String handleTags(String html) {
        // Substitua todas as ocorrências da tag <br> por quebras de linha \n

        html = html.replaceAll("<br/>", "\n");
        String novaString = "";

        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == '<' && html.charAt(i + 1) == 'p' && html.charAt(i + 2) == '>') {
                i += 2;

            } else if (html.charAt(i) == '<' && html.charAt(i + 1) == '/' && html.charAt(i + 2) == 'p'
                    && html.charAt(i + 3) == '>') {
                i += 3;
                novaString += "\n\n\n";
            } else {
                novaString += html.charAt(i);

            }
        }
        return novaString;
    }

    public static String getUrlFromMusic(String nomeMusica) {
        try {
            // Construa a URL de pesquisa com base no nome da música
            String pesquisaUrl = "https://www.letras.mus.br/?q=" + nomeMusica;
    
            // Use o Jsoup para buscar a página de resultados da pesquisa
            Document resultadoPesquisa = Jsoup.connect(pesquisaUrl).get();
    
            // Selecione todos os resultados da pesquisa
            Elements resultados = resultadoPesquisa.select(".search-results .item.music");
    
            // Verifique se foram encontrados resultados
            if (!resultados.isEmpty()) {
                // Obtenha o primeiro resultado (a primeira música encontrada)
                Element primeiroResultado = resultados.first();
    
                // Obtenha o link (URL) da música
                String urlMusica = primeiroResultado.select(".title a").attr("href");
    
                // Construa a URL completa
                String urlCompleta = "https://www.letras.mus.br" + urlMusica;
    
                return urlCompleta;
            } else {
                System.out.println("Música não encontrada.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return null;
    }

    public static void main(String[] args) {

            while( true){

            System.out.println("Pesuiar por \n 1-Url \n 2-Nomde de musica(Em desenvolvimento) \n 3-Sair");
            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();
            if(opcao == 0){
                break;
            }else if(opcao == 1){
                System.out.println("Digite a url");
                String url = sc.next();
                System.out.println("URL digitada: " + url);
                String html = GetHtml(url);

                if (html != null) {
                String lyrics = handleHtml(html);
                System.out.println(handleTags(lyrics));
                }else {
                System.out.println("Falha ao obter o HTML da página.");
                }

            } else{ //opção 2
                //pesquisar por nome de musica
                System.out.println("Digite o nome da musica");
                sc.nextLine();
                String nomeMusica = sc.nextLine();
                System.out.println("Nome da musica digitada: " + nomeMusica);

                String url = getUrlFromMusic(nomeMusica);
                System.out.println("URL da música: " + url);
                String html = GetHtml(url);

                if (html != null) {
                String lyrics = handleHtml(html);
                System.out.println(handleTags(lyrics));
                }else {
                System.out.println("Falha ao obter o HTML da página.");
                }

            }

        }

    }
}

    
    
    

