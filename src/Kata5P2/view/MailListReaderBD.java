package Kata5P2.view;

import Kata5P2.model.Mail;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailListReaderBD {

    public List<Mail> read() {
        List mailList = new ArrayList<Mail>();

        Connection connection = connect();
        String sqlQuery = "SELECT * FROM EMAIL";

        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            String mailValue;
            Pattern pattern = Pattern.compile("\\w+(\\.\\w+)*@\\w+(\\.\\w+)+");
            Matcher matcher;

            while (resultSet.next()) {
                mailValue = resultSet.getString("Mail");
                matcher = pattern.matcher(mailValue);

                if (matcher.matches()) {
                    mailList.add(new Mail(mailValue));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mailList;
    }

    private static Connection connect() {
        Connection connection = null;
        String url = "jdbc:sqlite:kata5.db";

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
