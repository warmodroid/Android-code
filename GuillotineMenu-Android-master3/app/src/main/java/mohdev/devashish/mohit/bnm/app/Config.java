package mohdev.devashish.mohit.bnm.app;

/**
 * Created by Devashish on 16-02-2016.
 */
public class Config {

    public static final String URL_REQUEST_SMS = "http://mastmurgi.com/book_php/request_sms.php";
    public static final String URL_VERIFY_OTP = "http://mastmurgi.com/book_php/verify_otp.php";

    // SMS provider identification
    // It should match with your SMS gateway origin
    // You can use  MSGIND, TESTER and ALERTS as sender ID
    // If you want custom sender Id, approve MSG91 to get one
    public static final String SMS_ORIGIN = "MOHDEV";

    // special character to prefix the otp. Make sure this character appears only once in the sms
    public static final String OTP_DELIMITER = ":";
}
