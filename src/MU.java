
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


class MU {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final String SYM = "MU";
		URL url = new URL("https://www.worldtradingdata.com/api/v1/stock?symbol=MU&api_token=WyhHnzKh1ObQnfXgYjxslzp9iHrWh694K6zbevaA2SMrLjTQHLtqazAxEQML");
		URLConnection urlConn = url.openConnection();
		InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
		BufferedReader buff = new BufferedReader(inStream);
		
		String price = "Not Found";
		String line = buff.readLine();
		String find = "\"price\":\"";
		while (line != null) {
			if (line.contains("\"symbol\":\""+ SYM + "\"")) {
				int target = line.indexOf(find);
				int start = target+find.length();
				price = line.substring(start, start+5);
				System.out.println(price);
			}
			line = buff.readLine();
		}
	}

}
