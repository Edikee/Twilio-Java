
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpsServer;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import javax.xml.soap.MessageFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Main {
//  public static final String ACCOUNT_SID = "";
//  public static final String AUTH_TOKEN = "";
//
//  public static final String testNumber = "";
//  public static final String twilioNumber = "";

  public static void main(String[] args) throws Exception {
    HttpsServer server = HttpsServer.create(new InetSocketAddress(80), 0);
    server.createContext("/info", new InfoHandler());
    server.setExecutor(null); // creates a default executor
    server.start();

//    Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
//
//    Message message = Message
//        .creator(new PhoneNumber(testNumber), // to
//            new PhoneNumber(twilioNumber), // from
//            "Message")
//        .create();
//
//    System.out.println(message.getSid());

  }
  static class InfoHandler implements HttpHandler {
    public void handle(HttpExchange t) throws IOException {
      String response = "Use /get to download a PDF";
      t.sendResponseHeaders(200, response.length());
      OutputStream os = t.getResponseBody();
      os.write(response.getBytes());
      os.close();
    }
  }
}
