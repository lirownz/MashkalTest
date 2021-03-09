package sitePagesTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpResponseCode {

	private HttpURLConnection connection;
	private URL url;

	public HttpResponseCode() throws MalformedURLException {
		url = new URL("");
	}
	public HttpResponseCode(URL pageUrl) throws IOException {

		try {
			this.url = pageUrl;
			connection = (HttpURLConnection) url.openConnection();
			//request setup
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			int status = connection.getResponseCode();
			System.out.println(pageUrl + " >>> HTTP response status Code: " + status);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
