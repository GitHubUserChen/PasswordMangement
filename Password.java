import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Password {

  String website;
  String username;
  String password;

  public Password(String website, String username, String password) throws IOException {
    this.website = website;
    this.username = username;
    this.password = password;
    savePass(this);
  }

  public static void savePass(Password myPasswd) throws IOException {
    String fileName = "passwordSaved.xml";
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
      out.write(myPasswd.website + "\t" + myPasswd.username + "\t" + myPasswd.password);
      out.write("\r\n");
      out.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
