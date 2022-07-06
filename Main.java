import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------------------\n");
        Scanner input = new Scanner(System.in);
        int role;
        String role_password;
        boolean condition = false;
        do {

            do {
                System.out.print("agar admin hastid: 1  va dar gheyre in soorat: 2  ra vared konid:   ");
                role = input.nextInt();
            }while ((role!=1)&&(role!=2));

            do {
                System.out.print("ramze oboor ra vared konid:  ");
                input.nextLine();
                role_password = input.nextLine();
                if (Objects.equals(role_password, "0"))
                    break;

                if (!Check_data.password_check(role,role_password)){
                    System.out.println("ramze oboor sahih nist!!!");
                    System.out.print("agar mikhahid kharej shavid 0 ra vare konid.\n ya \n");

                }
                else
                    condition = true;

            }while (!condition);


        }while (!(condition));


        if (role==1){
            Admin_access.main_loop();
        } else {
            User_access.main_loop();
        }

        System.out.println("\nBye :))))))");



        //Admin_access.add_vahed();                         //afzoodane vahed
        //Admin_access.add_saken();                         //afzoodane saken
        //User_access.update_request();
        //Admin_access.update_warning();
        //Admin_access.add_vahed_payment();                 //afzoodane bedehi
        //Admin_access.update_vahde_payment();
        //Admin_access.get_saken_info();
        //Admin_access.get_vahed_info_id();                 //daryafte etela'ate vahed ba hasbe ID vahed
        //Admin_access.get_vahed_info_vaziat();             //daryafte etela'ate vahed ba hasbe vaziate vahed
        //Admin_access.get_payment_info();
        //Admin_access.get_payment_history_info();
        //Admin_access.update_mohlate_sokoonat();
        //Admin_access.get_vahed_date();
        //Update_info.update_password(1);                 //update passworde admin
        //Update_info.update_password(2);                 //update passworde user
    }
}