import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Get_data {
    public static void get_sakenan_row(int code_meli){

        String query = "SELECT * FROM sakenan WHERE code_meli='" + code_meli + "'";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building","root","testpass");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String first_name = resultSet.getString(2);
                String last_name = resultSet.getString(3);
                int is_landlord = Integer.parseInt(resultSet.getString(4));
                String request = resultSet.getString(5);
                int vahed_id = Integer.parseInt(resultSet.getString(6));
                String last_update = resultSet.getString(7);
                System.out.println("----------------------------etela'ate saken----------------------------");
                System.out.println("code meli = " + code_meli);
                System.out.println("nam = " + first_name);
                System.out.println("name khanevadegi = " + last_name);
                System.out.println("ID vahedi ke dar an sokoonat darad = " + vahed_id);
                if (is_landlord==1)
                    System.out.println("sahebkhane ast");
                else
                    System.out.println("sahebkhane nist");
                System.out.println("darkhaste shakhs: " + request);
                System.out.println("akharin be rooz resani: " + last_update);
                System.out.println("-----------------------------------------------------------------------");
            }

            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\nERROR :" + e);
        }
    }



    public static void get_vahed_row(int vahed_id){

        String query = "SELECT * FROM vahedha WHERE vahed_id='" + vahed_id + "'";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building","root","testpass");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String warning = resultSet.getString(2);
                int tabaghe_vahed = Integer.parseInt(resultSet.getString(3));
                String vaziate_vahed = resultSet.getString(4);
                int metrazhe_vahed = Integer.parseInt(resultSet.getString(5));
                int tedade_otaghe_vahed = Integer.parseInt(resultSet.getString(6));
                int tedade_sakenane_vahed = Integer.parseInt(resultSet.getString(7));
                String mohlate_sokoonate_vahed = (resultSet.getString(8));
                String tarikhe_saken_shodan = (resultSet.getString(9));
                System.out.println("----------------------------etela'ate vahed----------------------------");
                System.out.println("ID vahed : " + vahed_id);
                System.out.println("ekhtar : " + warning);
                System.out.println("vahed dar kodam tabaghe gharar darad : " + tabaghe_vahed);
                System.out.println("vaziate_vahed : " + vaziate_vahed);
                System.out.println("metrazhe vahed : "+ metrazhe_vahed);
                System.out.println("tedade otaghe vahed : " + tedade_otaghe_vahed);
                System.out.println("tedade sakenane vahed : " + tedade_sakenane_vahed);
                System.out.println("mohlate sokoonat : " + mohlate_sokoonate_vahed);
                System.out.println("tarikhe saken shodane sakenan : " + tarikhe_saken_shodan);
                System.out.println("-----------------------------------------------------------------------");
            }

            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\nERROR :" + e);
        }





    }


    public static void get_payment_row(int vahed_id){

        String query = "SELECT * FROM vahed_payment WHERE vahed_id='" + vahed_id + "'";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building","root","testpass");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                double water_debt = Double.parseDouble((resultSet.getString(2)));
                double electricity_debt = Double.parseDouble(resultSet.getString(3));
                double gas_debt = Double.parseDouble(resultSet.getString(4));
                double rent_debt = Double.parseDouble(resultSet.getString(5));
                String water_last_payment = resultSet.getString(6);
                String electricity_last_payment = resultSet.getString(7);
                String gas_last_payment = resultSet.getString(8);
                String rent_last_payment = resultSet.getString(9);
                String last_update = resultSet.getString(10);
                String tarikhe_saken_shodan = (resultSet.getString(9));
                System.out.println("----------------------------bedehie vahed----------------------------");
                System.out.println("ID vahed : " + vahed_id);
                System.out.println("bedehie ad : " + water_debt + "   |  akharin tarikhe pardakht: " + water_last_payment);
                System.out.println("bedehie bargh : " + electricity_debt + "   |  akharin tarikhe pardakht: " + electricity_last_payment);
                System.out.println("bedehie gas : " + gas_debt + "   |  akharin tarikhe pardakht: " + gas_last_payment);
                System.out.println("bedehie ejare khane : " + rent_debt + "   |  akharin tarikhe pardakht: " + rent_last_payment);
                System.out.println("akharin be rooz resani : " + last_update);
                System.out.println("----------------------------------------------------------------------");
            }

            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("\nERROR :" + e);
        }
    }



public static void get_payment_history_info(int vahed_id){

    String query = "SELECT * FROM vahed_payment_history WHERE vahed_id='" + vahed_id + "'";
    try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/building","root","testpass");
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        System.out.println("----------------------------tarikhcheye pardakht'ha----------------------------");
        System.out.println("ID vahed : " + vahed_id + "\n");
        String explanation = "";
        while (resultSet.next()) {
            int payment_explanation = Integer.parseInt((resultSet.getString(2)));
            double payment_amount = Double.parseDouble(resultSet.getString(3));
            String payment_date = resultSet.getString(4);

            if (payment_explanation == 1)
                explanation =  "ghabze ab";
            else if (payment_explanation == 2)
                explanation = "ghabze bargh";
            else if (payment_explanation == 3)
                explanation = "ghabze gas";
            else
                explanation = "ghabze ejare";

            System.out.println("dalile pardakht : " + explanation);
            System.out.println("meghdare pardakhti : " + payment_amount);
            System.out.println("tarikhe pardakht : " + payment_date);
            System.out.println("---------------------");
        }
        System.out.println("----------------------------------------------------------------------");
        statement.close();
        connection.close();
    }catch (Exception e){
        System.out.println("\nERROR :" + e);
    }





    }
}
