package ListenersPack;

import java.sql.Connection;
        import java.sql.Date;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;

public class InsertQuery {

    public static int insertUser(int id,String firstName,String lastName,
                                      int phone, String password,String address ,String email , String country
                                      ,String state, String city, int zip) {
        // for insert a new candidate
        ResultSet rs = null;
        int userId = 0;
        RandomGenerator randomGenerator;
        randomGenerator = new RandomGenerator();
        randomGenerator.RandomEmail();


        String sql =  "set IDENTITY_INSERT [users].[dbo].[users] ON\n"+
                "insert into [users].[dbo].[users]\n" +
                "(id,firstName,lastName,phone,password,address,email,country,state,city,zip)\n" +
                "  values(?,?,?,?,?,?,?,?,?,?,?)"
                +"set IDENTITY_INSERT [users].[dbo].[users] OFF\n";

        try (Connection conn = ConnToDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {

            // set parameters for statement
            pstmt.setInt(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setInt(4, phone);
            pstmt.setString(5, password);
            pstmt.setString(6, address);
            pstmt.setString(7, email);
            pstmt.setString(8, country);
            pstmt.setString(9, state);
            pstmt.setString(10, city);
            pstmt.setInt(11, zip);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1)
            {
                // get id
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                    userId = rs.getInt(1);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return userId;
    }

    public static void main() {
        RandomGenerator randomGenerator;
        randomGenerator = new RandomGenerator();
        // insert a new user
        int id = insertUser(1,  randomGenerator.Name, randomGenerator.Surname,
                randomGenerator.Number, randomGenerator.Password, randomGenerator.Addres, randomGenerator.Email,
                randomGenerator.Country, randomGenerator.state, randomGenerator.City, randomGenerator.Postalcode);

        System.out.println(String.format("A new user with id %d has been inserted.",id));
    }
}