
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import javax.xml.soap.MessageFactory;
import java.util.ArrayList;
import java.util.List;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Main {
  public static final String ACCOUNT_SID = "";
  public static final String AUTH_TOKEN = "";

  public static final String testNumber = "";
  public static final String twilioNumber = "";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID,AUTH_TOKEN);

    Message message = Message
        .creator(new PhoneNumber(testNumber), // to
            new PhoneNumber(twilioNumber), // from
            "Message")
        .create();

    System.out.println(message.getSid());

  }
}
