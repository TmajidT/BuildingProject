import java.sql.*;


public class Write_To_Sql {
    public static void add_vahed(Vahed vahed){
        String query = "INSERT INTO vahedha VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building", "root", "testpass");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,Vahed.getVahed_id());
            statement.setString(2,Vahed.getWarning());
            statement.setInt(3,Vahed.getTabaghe());
            statement.setString(4,Vahed.getVaziat());
            statement.setInt(5,Vahed.getMetrazh());
            statement.setInt(6,Vahed.getTedade_otaghe());
            statement.setInt(7,Vahed.getTedade_sakenane());
            statement.setString(8,Vahed.getMohlate_sokoonate_vahed());
            statement.setString(9,Vahed.getTarikhe_saken_shodan());

            statement.executeUpdate();

            System.out.println("\namaliat ba movafaghiat anjam shod!!!");

            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\nERROR :" + e);
        }

    }

    public static void add_saken(Saken saken){
        String query = "INSERT INTO sakenan VALUES (?,?,?,?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building", "root", "testpass");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,Saken.getCode_meli());
            statement.setString(2,Saken.getFirst_name());
            statement.setString(3,Saken.getLast_name());
            statement.setInt(4,Saken.getIs_landlord());
            statement.setString(5,Saken.getRequest());
            statement.setInt(6,Saken.getVahed_id());
            statement.setString(7,Saken.getLast_update());

            statement.executeUpdate();

            System.out.println("\namaliat ba movafaghiat anjam shod!!!");

            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\nERROR :" + e);
        }
    }

    public static void add_request(int code_meli,String request){
        String query = "UPDATE sakenan SET request='" + request + "' WHERE code_meli=" + code_meli;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building","root","testpass");
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            System.out.println("\namaliat ba movafaghiat anjam shod!!!");

            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\nERROR :" + e);
        }
    }

    public static void add_warning(int vahed_id,String warning){
        String query = "UPDATE vahedha SET warning='" + warning + "' WHERE vahed_id=" + vahed_id;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building","root","testpass");
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            System.out.println("\namaliat ba movafaghiat anjam shod!!!");

            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\nERROR :" + e);
        }
    }


    public static void add_payment(Vahed_payment vahed_payment){

        String query = "INSERT INTO vahed_payment VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building", "root", "testpass");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,Vahed_payment.getVahed_id());
            statement.setDouble(2,Vahed_payment.getWater_debt());
            statement.setDouble(3,Vahed_payment.getElectricity_debt());
            statement.setDouble(4,Vahed_payment.getGas_debt());
            statement.setDouble(5,Vahed_payment.getRent_debt());
            statement.setString(6,Vahed_payment.getWater_last_payment());
            statement.setString(7,Vahed_payment.getElectricity_last_payment());
            statement.setString(8,Vahed_payment.getGas_last_payment());
            statement.setString(9,Vahed_payment.getRent_last_payment());
            statement.setString(10,Vahed_payment.getLast_update());
            statement.executeUpdate();

            System.out.println("\namaliat ba movafaghiat anjam shod!!!");

            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\nERROR :" + e);
        }

    }

    public static void update_payment(int vahed_id,int choice ,double debt,String last_payment){
        String bill = "";
        String date = "";
        if (choice==1) {
            bill = "water_debt";
            date = "water_last_payment";
        }
        else if (choice==2) {
            bill = "electricity_debt";
            date = "electricity_last_payment";
        }
        else if (choice==3) {
            bill = "gas_debt";
            date = "gas_last_payment";
        }
        else if (choice==4) {
            bill = "rent_debt";
            date = "rent_last_payment";
        }
        String query = "UPDATE vahed_payment SET " + bill + "='" + debt + "' WHERE vahed_id=" + vahed_id;
        String query1 = "UPDATE vahed_payment SET " + date + "='" + last_payment + "' WHERE vahed_id=" + vahed_id;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building","root","testpass");
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.executeUpdate(query1);

            System.out.println("\namaliat ba movafaghiat anjam shod!!!");

            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\nERROR :" + e);
        }
    }


    public static void add_payment_history(int vahed_id,int payment_explanation,double payment_amount,String payment_date){
        String query = "INSERT INTO vahed_payment_history VALUES (?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building", "root", "testpass");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,vahed_id);
            statement.setInt(2,payment_explanation);
            statement.setDouble(3,payment_amount);
            statement.setString(4,payment_date);

            statement.executeUpdate();

            System.out.println("\namaliat ba movafaghiat anjam shod!!!");

            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\nERROR :" + e);
        }





    }


    public static void update_mohlate_sokoonat(int vahed_id,String date){

        String query = "UPDATE vahedha SET mohlate_sokoonate_vahed='" + date + "' WHERE vahed_id=" + vahed_id;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building","root","testpass");
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            System.out.println("\namaliat ba movafaghiat anjam shod!!!");

            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\nERROR :" + e);
        }

    }

    public static void update_password(int role,String password){
        String query = "UPDATE info SET user_password='" + password + "' WHERE user_number=" + role;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building","root","testpass");
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            System.out.println("\namaliat ba movafaghiat anjam shod!!!");

            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\nERROR :" + e);
        }
    }

}
