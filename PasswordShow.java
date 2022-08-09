import java.io.*;
import java.nio.charset.StandardCharsets;

public class PasswordShow
{
    public static void show() throws IOException
    {
        File file = new File("password.xlsx");
        String content;
        InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        System.out.println("Your stored passwords are below:");
        while ((content = bufferedReader.readLine()) != null)
        {
            System.out.println(content);
        }
    }
}
