import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		//Fazer uma conexão HTTP e buscar os topo 250 filmes.
		//Declarando a variável "url" e atribuindo o link como seu valor:
		
		String url = "https://alura-filmes.herokuapp.com/conteudos";
		
		//Criando uma URI associando a URL + Declaração de variável:
		URI endereco = URI.create(url);
		
		//Declarando a variável HttpClient:
		var client = HttpClient.newHttpClient();
		
		//Declarando a variável HttpRequest - métodos GET e build:
		var request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		//Guardar o body (texto) na String:
		String body = response.body();
		System.out.println(body);
		
		//Extarir apenas os dados que interessam (título, poster e classificação):
		var parser = new JsonParser();
		List<Map<String,String>> listaDeFilmes = parser.parse(body);
		
		
		//Exibir e manipular os dados:
		for (Map<String,String> filme: listaDeFilmes) {
			System.out.println(filme.get("title"));
			System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
		}
	}

}
