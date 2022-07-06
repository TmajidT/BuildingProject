import java.util.Scanner;

public class User_access {

    public static void main_loop(){
        System.out.println("\n---------------------Welcome to the user section---------------------\n");
        Scanner input = new Scanner(System.in);
        int choice;
        boolean condition = true;
        do {
            System.out.println("-------------------------------");
            System.out.println("update kardane darkhast'ha: 1");
            System.out.println("daryafte etela'at: 2");
            System.out.println("taghire ramze oboor: 3");
            System.out.println("khoroj: 0");
            System.out.println("-------------------------------");

            do {
                condition = true;
                System.out.print("entekhabe shoma:");
                choice = input.nextInt();
                if (choice == 0) {
                    break;
                } else if ((choice != 1) && (choice != 2) && (choice != 3)) {
                    System.out.println("lotfan addad ra ba deghat vared konid!!");
                    condition = false;
                }
            } while (!condition);


            switch (choice) {
                case 1: {
                    update_request();
                    break;
                }
                case 2: {
                    Get_data.main_loop();
                    break;
                }
                case 3:{
                    Update_info.update_password(2);
                    break;
                }
                case 0: {
                    condition = false;
                    break;
                }
            }

        }while (condition);




    }
    public static void update_request(){
        Update_info.update_saken_request();
    }
}
