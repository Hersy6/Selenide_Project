package ListenersPack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class RandomGenerator {
    public String Name = "tornike";
    public String Surname = "tchavtchavadze";

    public String Password = "20202020";
    public int Number = 551551551;
    public String Addres = "ketskhoveli";
    public String Country = "Georgia";
    public String City = "Tbilisi";
    public String state = "Tbilisi";
    public int Postalcode = 0167;





    public RandomGenerator RandomEmail( ) {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String m = "@gmail.com";

        Email = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString() + m;

        System.out.println(Email);
        return this;
    }
    public String Email = RandomEmail().Email;

}
