import java.util.Scanner;

public class Admin_access {
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

    public static void get_vahed_info(){
        Scanner input = new Scanner(System.in);
        int vahed_id;
        do {
            System.out.print("lotfan ID vahedi ke ghablan zakhire shode ra vared konid : ");
            vahed_id = input.nextInt();
        }while (!(Check_data.vahed_id_check(vahed_id)));
        Get_data.get_vahed_row(vahed_id);
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
}
