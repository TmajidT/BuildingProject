import java.sql.*;


public class Check_data {

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
}
