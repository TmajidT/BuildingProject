import java.util.Scanner;

public class Admin_access {

    public static void main_loop(){
        System.out.println("\n---------------------Welcome to the admin section---------------------\n");
        Scanner input = new Scanner(System.in);
        int choice;
        boolean condition = true;
        do {
            System.out.println("-------------------------------");
            System.out.println("afzoodane vahed: 1");
            System.out.println("afzoodane saken: 2");
            System.out.println("update kardane darkhast'ha: 3");
            System.out.println("update kardane ekhtarha'ha: 4");
            System.out.println("afzoodane bedehie vahed: 5");
            System.out.println("update kardane bedehie vahed: 6");
            System.out.println("update kardane mohlate takhlie vahed: 7");
            System.out.println("daryafte etela'at: 8");
            System.out.println("taghire ramze oboor: 9");
            System.out.println("khoroj: 0");
            System.out.println("-------------------------------");

            do {
                condition = true;
                System.out.print("entekhabe shoma:");
                choice = input.nextInt();
                if (choice==0){
                    break;
                }
                else if ((choice<1)||(choice>9)){
                    System.out.println("lotfan addad ra ba deghat vared konid!!");
                    condition = false;
                }
            }while (!condition);


            switch (choice){
                case 1:{
                    add_vahed();
                    break;
                }
                case 2: {
                    add_saken();
                    break;
                }
                case 3: {
                    User_access.update_request();
                    break;
                }
                case 4: {
                    update_warning();
                    break;
                }
                case 5: {
                    add_vahed_payment();
                    break;
                }
                case 6: {
                    update_vahde_payment();
                    break;
                }
                case 7: {
                    update_mohlate_sokoonat();
                    break;
                }
                case 8: {
                    Get_data.main_loop();
                    break;
                }
                case 9:{
                    Update_info.update_password(1);
                    break;
                }
                case 0: {
                    condition = false;
                    break;
                }
            }

        }while (condition);
    }


    public static void add_vahed(){
        Vahed vahed = new Vahed();
        vahed = Add_Info.add_vahed_info();
        Write_To_Sql.add_vahed(vahed);
    }

    public static void add_saken(){
        Saken saken = new Saken();
        saken = Add_Info.add_saken_info();
        Write_To_Sql.add_saken(saken);
    }

    public static void update_warning(){
        Update_info.update_vahed_warning();
    }

    public static void add_vahed_payment(){
        Vahed_payment vahed_payment = new Vahed_payment();
        vahed_payment = Add_Info.add_vahed_payment_info();
        Write_To_Sql.add_payment(vahed_payment);
    }

    public static void update_vahde_payment(){
        Update_info.update_vahed_payment();
    }

    public static void get_saken_info(){
        Scanner input = new Scanner(System.in);
        int code_meli;
        do {
            System.out.print("lotfan code meli ke az ghabl sabt shode ra vared konid:  ");
            code_meli = input.nextInt();
        }while(!(Check_data.code_meli_check(code_meli)));
        Get_data.get_sakenan_row(code_meli);
    }

    public static void get_vahed_info_id(){
        Scanner input = new Scanner(System.in);
        int vahed_id;
        do {
            System.out.print("lotfan ID vahedi ke ghablan zakhire shode ra vared konid : ");
            vahed_id = input.nextInt();
        }while (!(Check_data.vahed_id_check(vahed_id)));
        Get_data.get_vahed_row(vahed_id,"0");
    }

    public static void get_vahed_info_vaziat(){
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.print("search bar hasbe= ejare neshin: 1  saheb khane: 2  khali: 3     :");
            choice = input.nextInt();
        }while ((choice!=1)&&(choice!=2)&&(choice!=3));
        String vaziat = "";
        if (choice==1)
            vaziat = "ejare neshin";
        else if (choice==2)
            vaziat = "forookhte shode";
        else
            vaziat = "empty";
        Get_data.get_vahed_row(-1,vaziat);
    }

    public static void get_payment_info(){
        Scanner input = new Scanner(System.in);
        int vahed_id;
        do {
            System.out.print("ID vahedi ke az ghabl sabt shode ra vared konid: ");
            vahed_id = input.nextInt();
        }while (!(Check_data.vahed_payment_id_check(vahed_id)));
        Get_data.get_payment_row(vahed_id);
    }

    public static void get_payment_history_info(){
        Scanner input = new Scanner(System.in);
        int vahed_id;
        do {
            System.out.print("ID vahedi ke az ghabl update shode ra vared konid: ");
            vahed_id = input.nextInt();
        }while (!(Check_data.vahed_payment_history_id_check(vahed_id)));                //check kardane in ke ID vojod dashte bashad
        Get_data.get_payment_history_info(vahed_id);
    }

    public static void update_mohlate_sokoonat(){
        Update_info.update_mohlate_sokoonat();
    }

    public static void get_vahed_date(){
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.print("search tarikhe saken shodan: 1    mohlate takhlie: 2  ra vared konid:  ");
            choice = input.nextInt();
        }while ((choice!=1)&&(choice!=2));
        boolean condition;
        System.out.println("ba deghat va kamel tarikhe movrede nazar ra vared konid.");
        String date;
        int sal;
        do {
            condition = false;
            System.out.print("sal:  ");
            sal = input.nextInt();
            if ((sal>1407)||(sal<1401)){
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
        date = String.format("%d-%d-%d", sal, mah, rooz);

        Get_data.get_vahed_date(choice,date);
    }

}
