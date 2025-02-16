package paquete;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ClasePrincipal {

	public static void main(String[] args) {
		
		String publicKey = "d95599b40347dfaa630d7440b157c98c";
		String privateKey = "6507596995990b1fc7c0ea986770e5ea56d5d831";
		String result = null;
		
		 try {
	            String baseUrl = "https://gateway.marvel.com:443/v1/public/characters/1010787/comics?limit=100";
	            String timeStamp = Long.toString(System.currentTimeMillis());
	            String hash = DigestUtils.md5Hex(timeStamp + privateKey + publicKey);

	            String url = baseUrl + "&ts=" + timeStamp + "&apikey=" + publicKey + "&hash=" + hash;

	            CloseableHttpClient httpClient = HttpClients.createDefault();
	            HttpGet request = new HttpGet(url);
	            CloseableHttpResponse response = httpClient.execute(request);

	            result = EntityUtils.toString(response.getEntity());
	            

	            response.close();
	            httpClient.close();
	    } catch (Exception e) {
	            e.printStackTrace();
	    }
		
		JSONObject obj = new JSONObject(result);
		JSONArray results = obj.getJSONObject("data").getJSONArray("results");
		
		for (int i = 0; i < results.length(); i++) {
			
            JSONObject resultado = results.getJSONObject(i);
            
            JSONObject imagen = resultado.getJSONObject("thumbnail");
            String urlImagen = imagen.getString("path") + "." + imagen.getString("extension");
            
            JSONObject serie = resultado.getJSONObject("series");
            String nombreSerie = serie.getString("name");
            System.out.println(nombreSerie);
            
            
            Comic comicActual = new Comic(String.valueOf(resultado.getInt("id")),resultado.getString("title"),resultado.getString("description"),String.valueOf(resultado.getInt("pageCount")),String.valueOf(resultado.getInt("issueNumber")),null,resultado.getString("format"),null);
        }
	}
	
	

}
