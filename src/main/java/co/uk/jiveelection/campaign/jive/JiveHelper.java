package co.uk.jiveelection.campaign.jive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import co.uk.jiveelection.campaign.twit.EntitiesModel;
import co.uk.jiveelection.campaign.utils.TextHelper;

public class JiveHelper {
	private static final String JIVE_ENDPOINT = "http://www.cs.utexas.edu/users/jbc/bork/bork.cgi";

	/**
	 * Accepts a String and requests a Jive translation using the Jive translation service. Attempts
	 * to correct HTML encoding on the return string.
	 * 
	 * @param textToJive The String to be jive translated
	 * @return A translated Jive String
	 */
	private static String jiveRequest(String textToJive) {
		String jiveResponse = "";

		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

			// Create a new HTTP post object with parameters
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
				jiveResponse += line;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return StringEscapeUtils.unescapeHtml4(jiveResponse);
	}

	/**
	 * Accepts a Tweeted String with optional Entities (hashtags, URLs, Mentions, etc. Extracts the
	 * normal text not defined by the bounds of the Entities and translates these separately. Finally
	 * reconstructs the string such that everything is translated apart from the Entities that remain
	 * intact.
	 * 
	 * @param inputText The original Tweet
	 * @param entities Optionally describes any Entities in the original Tweet.
	 * @return A Jive String ready to be tweeted by the jivebot
	 */
	public static String translateToJive(String inputText, List<EntitiesModel> entities) {
		int position = 0;
		int entitySize = entities.size();
		String sub;
		String jive = "";

		// Do we have entities? If not translate the input. If so substring and translate.
		if (!(entitySize > 0)) {
			jive = JiveHelper.jiveRequest(inputText);
		} else {
			for (int i = 0; i < entitySize; i++) {
				EntitiesModel entity = entities.get(i);
				sub = inputText.substring(position, entity.getStart());
				if (sub.length() > 0) {
					jive += JiveHelper.jiveRequest(sub)
							+ " "
							+ inputText.substring(entities.get(i).getStart(), entities.get(i)
									.getEnd()) + " ";
				} else {
					jive += inputText
							.substring(entities.get(i).getStart(), entities.get(i).getEnd()) + " ";
				}

				position = entities.get(i).getEnd() + 1;
			}
			// Here we have no more entities but could still have text to jivelate
			if (position < inputText.length()) {
				sub = inputText.substring(position);
				jive += JiveHelper.jiveRequest(sub);
			}
		}

		return TextHelper.twitterWorkarounds(jive);

	}
}
