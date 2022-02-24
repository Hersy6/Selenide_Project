package ForTest1.Steps;

import ForTest1.Pages.RegistrationPage;
import ListenersPack.ConnToDB;
import ListenersPack.InsertQuery;
import ListenersPack.RandomGenerator;
import io.qameta.allure.Step;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationPageSteps extends RandomGenerator {
    RegistrationPage registrationPage;


    @Step
    public RegistrationPageSteps insert() {
        registrationPage = new RegistrationPage();
        InsertQuery.main();
        try (Connection conn = ConnToDB.getConnection();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT top 1 * FROM [users].[dbo].[users] ORDER BY ID DESC")) {
            while (rs.next()) {
                registrationPage.firstName.sendKeys(rs.getString("firstName"));
                registrationPage.lastName.sendKeys(rs.getString("lastName"));
                registrationPage.email.sendKeys(rs.getString("email"));
                registrationPage.telephone.sendKeys(rs.getString("phone"));
                registrationPage.password.scrollTo();
                registrationPage.password.sendKeys(rs.getString("password"));
                registrationPage.conPassword.sendKeys(rs.getString("password"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }


        return this;
    }
    @Step
    public RegistrationPageSteps nextPage() {
        registrationPage.agreeTC.click();
        registrationPage.Continue.click();
        return this;
    }

}
