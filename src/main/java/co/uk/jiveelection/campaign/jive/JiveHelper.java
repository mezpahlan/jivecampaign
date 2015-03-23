package co.uk.jiveelection.campaign.jive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class JiveHelper {
	private static final String JIVE_ENDPOINT = "http://www.cs.utexas.edu/users/jbc/bork/bork.cgi";

	public static String translateToJive(String textToJive) {
		String jive = "";

		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

			// Create a new HTTP post object with parameters
			// TODO: Character encoding problem here
			HttpPost httpPost = new HttpPost(JIVE_ENDPOINT);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("type", "jive"));
			nvps.add(new BasicNameValuePair("input", textToJive));
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));

			// Execute the request and get a response
			CloseableHttpResponse response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			BufferedReader rd = new BufferedReader(new InputStreamReader(entity.getContent()));
			
			// While we can read lines from the buffered reader
			String line;
			while ((line = rd.readLine()) != null) {
				jive += line;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jive;
	}
}
