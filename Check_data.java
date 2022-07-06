import java.sql.*;
import java.util.Objects;

public class Check_data {

    public static boolean password_check(int role,String password){
        String s_role;
        if (role == 1)
            s_role = "admin";
        else
            s_role = "user";


        boolean are_same = false;
        try {
            String query = "SELECT * FROM info WHERE user_role='" + s_role + "'";

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building", "root", "testpass");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            String real_password = resultSet.getString(3);

            if (Objects.equals(password, real_password))                       //check kardane barabarie 2 password
                are_same = true;



            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("The Error:" + e);
        }
        return are_same;                               //if true ===> password ha mesle ham hastand
    }

    public static boolean vahed_id_check(int id) {
        boolean is_not_unique = true;
        try {
            String query = "SELECT metrazhe_vahed FROM vahedha WHERE vahed_id=" + id;

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building", "root", "testpass");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (!(resultSet.next()))
                is_not_unique = false;                           //agar false shod tekrari nist

            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("The Error:" + e);
        }
        return is_not_unique;                               //if true ===> vojod darad
    }

    public static boolean code_meli_check(int code_meli){
        boolean is_not_unique = true;
        try {
            String query = "SELECT is_landlord FROM sakenan WHERE code_meli=" + code_meli;

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building", "root", "testpass");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (!(resultSet.next()))
                is_not_unique = false;                           //agar false shod tekrari nist

            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("The Error:" + e);
        }
        return is_not_unique;                               //if true ===> tekrari ast

    }

    public static boolean vahed_payment_id_check(int id){
        boolean is_not_unique = true;
        try {
            String query = "SELECT water_debt FROM vahed_payment WHERE vahed_id=" + id;

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building", "root", "testpass");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (!(resultSet.next()))
                is_not_unique = false;                           //agar false shod tekrari nist

            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("The Error:" + e);
        }
        return is_not_unique;                               //if true ===> vojod darad
    }

    public static boolean vahed_payment_history_id_check(int id){
        boolean is_not_unique = true;
        try {
            String query = "SELECT payment_explanation FROM vahed_payment_history WHERE vahed_id=" + id;

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building", "root", "testpass");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (!(resultSet.next()))
                is_not_unique = false;                           //agar false shod tekrari nist

            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("The Error:" + e);
        }
        return is_not_unique;                               //if true ===> vojod darad
    }

}
