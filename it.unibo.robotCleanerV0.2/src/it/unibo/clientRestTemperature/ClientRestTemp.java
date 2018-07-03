package it.unibo.clientRestTemperature;
/*Client Rest che ricava il valore della temperatura da un servizio esterno*/



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.*;
import org.apache.http.NameValuePair;




public class ClientRestTemp {
	
	//punto di accesso, APPID è personale ed è da inserire sempre, id rappresenta l'id della città di Bologna (vedere sito per altri id)
	private static String hostAddr = "http://api.openweathermap.org/data/2.5/weather?id=6541998&APPID=7160b3c47ad9cef03982f9cfd819f930";
	

	//Metodo che restitusce il risultato in Stringa JSON
	public static String connectGet(String url) {
	 
		String info = "";
		String output;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);		
			CloseableHttpResponse response = httpclient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}
			
			BufferedReader br = new BufferedReader(
                         new InputStreamReader((response.getEntity().getContent())));
			
			
			while ((output = br.readLine()) != null) {
			info = info + output;
			}
			
 		} catch ( Exception e) { e.printStackTrace();}
		
		return info;
		
	}
	
	//Metodo per il parsing del risultato da Json in temperatura in int (se restituisce negativo è errore).
	public static int getTemperature(){
		
		String data;
		int temperature = -1;
		data = connectGet(hostAddr);
		
		JSONObject jsonObject = new JSONObject(data);
		JSONObject myResponse = jsonObject.getJSONObject("main");
		temperature = myResponse.getInt("temp");
		temperature-=273; //conversione Kelvin a Celsius
		return temperature;
	
	}
	
	public static void main (String args[]) throws Exception{

		int temperature = getTemperature();	
		System.out.println(temperature);
		System.out.println(connectGet(hostAddr));
		Thread.sleep(700);
	}
}

	    
	
 

	
