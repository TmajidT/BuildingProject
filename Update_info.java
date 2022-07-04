import java.util.*;
public class Update_info {
    public static void update_saken_request(){
        System.out.println("----------shoma dar hale be rooz resanie darkhaste saken hastid----------");
        Scanner input = new Scanner(System.in);

        System.out.print("code meli saken ra vared konid:  ");
        boolean condition;
        int code_meli;
        do {
            condition = false;
            code_meli = input.nextInt();
            if ((code_meli/10000000 != 112)||!(Check_data.code_meli_check(code_meli))) {
                if (code_meli / 10000000 != 112) {
                    System.out.println("lotfan adad ra ba deghat vared konid!!!");
                    condition = true;
                } else {
                    System.out.println("code meli vojod nadarad!!!");
                    condition = true;
                }
            }
        }while (condition);


        String request;
        int choice;
        do {
            System.out.print("baraye hazfe darkhaste feli: 0 va baraye afzoodane darkhaste jadid 1 ra vared konid:  ");
            choice = input.nextInt();
        }while ((choice != 0)&&(choice != 1));
        if (choice == 0)
            request = "bedoone darkhast";
        else {
            System.out.print("darkhaste khod ra vared konid:  ");
            input.nextLine();
            request = input.nextLine();
        }
        Write_To_Sql.add_request(code_meli,request);
    }

    public static void update_vahed_warning(){
        System.out.println("----------shoma dar hale be rooz resanie ekhtare vahed hastid----------");
        Scanner input = new Scanner(System.in);

        int vahed_id;
        boolean condition;
        do {
            condition = false;
            System.out.print("ID vahed ra vared konid:  ");
            vahed_id = input.nextInt();
            if (!(Check_data.vahed_id_check(vahed_id))){
                condition = true;
                System.out.println("ID vojod nadarad!!");
            }
        }while (condition);

        String warning;
        int choice;
        do {
            System.out.print("baraye hazfe ekhtare feli: 0 va baraye afzoodane ekhtare jadid 1 ra vared konid:  ");
            choice = input.nextInt();
        }while ((choice != 0)&&(choice != 1));
        if (choice == 0)
            warning = "bedoone ekhtar";
        else {
            System.out.print("ekhtar ra vared konid:  ");
            input.nextLine();
            warning = input.nextLine();
        }
        Write_To_Sql.add_warning(vahed_id,warning);
    }

    public static void update_vahed_payment(){
        System.out.println("----------shoma dar hale be rooz resanie pardakhti'haye vahed hastid----------");
        Scanner input = new Scanner(System.in);
        int vahed_id;
        do {
            System.out.println("ID vahedi ke ghablan sabt shode ra vared konid:  ");
            vahed_id = input.nextInt();
        }while (!(Check_data.vahed_payment_id_check(vahed_id)));
        System.out.println("kodam movred ra mikhahid be rooz konid?");
        int choice;                                                                                                //moshakhas kardane halate bedehi
        System.out.println("ghabze ad : 1\nghabze bargh : 2\nghabze gas : 3\nghabze ejare khane : 4");
        do {
            choice = input.nextInt();
            if ((choice!=1)&&(choice!=2)&&(choice!=3)&&(choice!=4)){
                System.out.println("lotfan adad ra ba deghat vared konid!!");
                choice = -1;
            }
        }while (choice==-1);
        System.out.print("meghdare bedehi jadid ra vared konid:  ");
        double debt;
        debt = input.nextDouble();


        boolean condition;
        System.out.println("ba deghat va kamel akharin tarikhe pardakht ra vared konid.");
        String last_payment;
        int sal;
        do {
            condition = false;
            System.out.print("sal:  ");
            sal = input.nextInt();
            if ((sal>1403)||(sal<1401)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        } while (condition);

        int mah;
        do {
            condition = false;
            System.out.print("mah:  ");
            mah = input.nextInt();
            if ((mah>12)||(mah<1)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        } while (condition);

        int rooz;
        do {
            condition = false;
            System.out.print("rooz:  ");
            rooz = input.nextInt();
            if ((rooz>31)||(rooz<1)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        } while (condition);
        last_payment = String.format("%d-%d-%d", sal, mah, rooz);


        Write_To_Sql.update_payment(vahed_id,choice,debt,last_payment);             //update kardane jadvale payment

        Write_To_Sql.add_payment_history(vahed_id,choice,debt,last_payment);            //afzoodane tarikhche'ye pardakht
    }
}
