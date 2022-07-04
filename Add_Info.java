import java.util.*;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;


public class Add_Info {
    public static Vahed add_vahed_info() {                                           //daryafte etela'at baraye sakhte vahede jadid
        System.out.print("----------------------shoma dar hale afzoodane vahed hastid!----------------------\n");

        Scanner input = new Scanner(System.in);
        int id;
        boolean condition;                                                              //baraye check kardane shart dar toole Method
        do {
            System.out.print("id vahed ra vared konid: ");
            id = input.nextInt();
            condition = false;                              //check kardane dadeye tekrari
            if ((id<0)||(Check_data.vahed_id_check(id))){
                if (id<0){
                    System.out.println("lotfan adad ra ba deghat vared konid!!!");
                    condition = true;
                }else {
                    System.out.println("in id tekrari ast!!!");
                    condition = true;
                }
            }
        } while (condition);


        String warning = "bedoone ekhtar";

        int tabaghe;
        do {                                                   //tedade tabaghe
            condition = false;
            System.out.print("vahed dar kodam tabaghe ast?  ");
            tabaghe = input.nextInt();
            if ((tabaghe<0)||(tabaghe>20)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        }while (condition);

        String vaziat = "";
        int ejare_neshin;
        do {                                                    //vaziate vahed (ejare ya saheb khane)
            condition = false;
            System.out.print("agar vahed forokhte shode: 1 aga ejare ast: 2 va agar khali ast: 0 ra vared konid:  ");
            ejare_neshin = input.nextInt();
            if ((ejare_neshin!=1)&&(ejare_neshin!=0)&&(ejare_neshin!=2)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            } else if (ejare_neshin == 2)
                vaziat = "ejare neshin";
            else if (ejare_neshin == 1)
                vaziat = "forookhte shode";
            else
                vaziat = "empty";

        }while (condition);


        int metrazh;
        do {                                                    //metrazh
            condition = false;
            System.out.print("metrazhe vahed ra moshakhas konid:  ");
            metrazh = input.nextInt();
            if ((metrazh<20)||(metrazh>1000)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        }while (condition);

        int otagh;
        do {                                                    //tedade otagh
            condition = false;
            System.out.print("tedade otagh ra moshakhas konid: ");
            otagh = input.nextInt();
            if ((otagh<0)||(otagh>7)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        }while (condition);

        int sakenan;
        do {                                                    //tedade sakenan
            condition = false;
            System.out.print("chand nafar dar in vahed eghamat darand?  ");
            sakenan = input.nextInt();
            if ((sakenan<0)||(sakenan>10)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        }while (condition);


        String mohlate_sokoonat = "";
        if ((ejare_neshin == 1)||(ejare_neshin == 0))
            mohlate_sokoonat = "0000-00-00";
        else {                                                                              //gereftane sal va mah va rooze mohlate sokoonat
            System.out.println("mohlate sokoonat ra be tartib va kamel vared konid!");
            int sal;
            do {
                condition = false;
                System.out.print("sal:  ");
                sal = input.nextInt();
                if ((sal>1420)||(sal<1401)){
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

            mohlate_sokoonat = String.format("%d-%d-%d", sal, mah, rooz);                   //ijade tarikhi be formate (xxxx-xx-xx)

        }


        String tarikhe_sokoonat = "";

        if (ejare_neshin == 0)
            tarikhe_sokoonat = "0000-00-00";
        else {
            System.out.println("tarikhe saken shodan ra be tartib va kamel vared konid!");              //gereftane tarikhe sokoonat
            int sal;
            do {
                condition = false;
                System.out.print("sal:  ");
                sal = input.nextInt();
                if ((sal > 1403) || (sal < 1401)) {
                    System.out.println("lotfan adad ra ba deghat vared konid!!!");
                    condition = true;
                }
            } while (condition);

            int mah;
            do {
                condition = false;
                System.out.print("mah:  ");
                mah = input.nextInt();
                if ((mah > 12) || (mah < 1)) {
                    System.out.println("lotfan adad ra ba deghat vared konid!!!");
                    condition = true;
                }
            } while (condition);

            int rooz;
            do {
                condition = false;
                System.out.print("rooz:  ");
                rooz = input.nextInt();
                if ((rooz > 31) || (rooz < 1)) {
                    System.out.println("lotfan adad ra ba deghat vared konid!!!");
                    condition = true;
                }
            } while (condition);

            tarikhe_sokoonat = String.format("%d-%d-%d", sal, mah, rooz);                   //ijade tarikhi be formate (xxxx-xx-xx)
        }

        //sakhte vahed dar classe (Vahed)


        return new Vahed(id,warning,tabaghe,vaziat,metrazh,otagh,sakenan,mohlate_sokoonat,tarikhe_sokoonat);
    }

    public static Saken add_saken_info(){
        System.out.print("----------------------shoma dar hale afzoodane saken hastid!----------------------\n");

        Scanner input = new Scanner(System.in);


        boolean condition;                                      //baraye check kardane shart dar toole Method
        int code_meli;
        do {
            condition = false;
            System.out.print("code meli ra vared konid: ");
            code_meli = input.nextInt();
            if ((code_meli/10000000 != 112)||(Check_data.code_meli_check(code_meli))){
                if (code_meli/10000000 != 112){
                    System.out.println("lotfan adad ra ba deghat vared konid!!!");
                    condition = true;
                }
                else {
                    System.out.println("code meli tekrari ast!!!");
                    condition = true;
                }
            }
        }while (condition);

        System.out.println("nam va name khanevadegi ra ba deghat vared konid.");
        String first_name = "";
        do {
            System.out.print("nam: ");
            first_name = input.next();
        }while (condition);
        String last_name = "";
        System.out.print("name khanevadegi: ");
        last_name = input.next();

        int is_landlord;
        do {
            condition = false;
            System.out.print("agar shakhs saheb khane ast: 1 va dar gheyre in soorat: 0 ra vared konid:  ");
            is_landlord = input.nextInt();
            if ((is_landlord != 0)&&(is_landlord != 1)) {
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        }while (condition);

        String request = "bedoone darkhast";

        int vahed_id;
        do {
            condition = false;
            System.out.print("ID vahedi ke shakhs dar an sokoonat darad ra vared konid: ");
            vahed_id = input.nextInt();
            if (!(Check_data.vahed_id_check(vahed_id))){
                System.out.println("in ID vojood nadarad!!");
                condition = true;
            }
        }while (condition);

        String last_update = "0000-00-00";

        Saken saken = new Saken(code_meli,first_name,last_name,is_landlord,request,vahed_id,last_update);               //fixe in ghesmat

        return saken;
    }

    public static Vahed_payment add_vahed_payment_info(){
        System.out.print("----------------------shoma dar hale afzoodane pardakhti'haye vahed hastid!----------------------\n");

        Scanner input = new Scanner(System.in);

        int id;
        boolean condition;                                                              //baraye check kardane shart dar toole Method
        do {
            System.out.print("ID vahed ra vared konid: ");
            id = input.nextInt();
            condition = false;                              //check kardane dadeye tekrari
            if ((id<0)||!(Check_data.vahed_id_check(id))||(Check_data.vahed_payment_id_check(id))){
                if (id<0){
                    System.out.println("lotfan adad ra ba deghat vared konid!!!");
                    condition = true;
                }else if (Check_data.vahed_payment_id_check(id)){
                    System.out.println("in ID ghablan sabt shode!!!");
                    condition = true;
                }
                else {
                    System.out.print("in ID vojod nadarad!!");
                    condition = true;
                }
            }
        } while (condition);

        double water_debt;
        do {
            System.out.print("bedehie ab ra vared konid:  ");
            water_debt = input.nextDouble();
        }while (condition);

        double electricity_debt;
        do {
            System.out.print("bedehie bargh ra vared konid:  ");
            electricity_debt = input.nextDouble();
        }while (condition);


        double gas_debt;
        do {
            System.out.print("bedehie gas ra vared konid:  ");
            gas_debt = input.nextDouble();
        }while (condition);

        double rent_debt;
        do {
            System.out.print("ejare khane ra vared konid:  ");
            rent_debt = input.nextDouble();
        }while (condition);





        //behboode in ghesmat **********&&&&&&&&&&&&&&&&&&&&&*%%%%%%%%%%%%%%

        System.out.println("ba deghat va kamel akharin tarikhe pardakhte ghabze ab ra vared konid.");
        String water_last_payment;
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

        water_last_payment = String.format("%d-%d-%d", sal, mah, rooz);



        System.out.println("ba deghat va kamel akharin tarikhe pardakhte ghabze bargh ra vared konid.");
        String electricity_last_payment;
        do {
            condition = false;
            System.out.print("sal:  ");
            sal = input.nextInt();
            if ((sal>1403)||(sal<1401)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        } while (condition);

        do {
            condition = false;
            System.out.print("mah:  ");
            mah = input.nextInt();
            if ((mah>12)||(mah<1)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        } while (condition);

        do {
            condition = false;
            System.out.print("rooz:  ");
            rooz = input.nextInt();
            if ((rooz>31)||(rooz<1)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        } while (condition);
        electricity_last_payment = String.format("%d-%d-%d", sal, mah, rooz);


        System.out.println("ba deghat va kamel akharin tarikhe pardakhte ghabze gas ra vared konid.");
        String gas_last_payment;
        do {
            condition = false;
            System.out.print("sal:  ");
            sal = input.nextInt();
            if ((sal>1403)||(sal<1401)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        } while (condition);

        do {
            condition = false;
            System.out.print("mah:  ");
            mah = input.nextInt();
            if ((mah>12)||(mah<1)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        } while (condition);

        do {
            condition = false;
            System.out.print("rooz:  ");
            rooz = input.nextInt();
            if ((rooz>31)||(rooz<1)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        } while (condition);
        gas_last_payment = String.format("%d-%d-%d", sal, mah, rooz);


        System.out.println("ba deghat va kamel akharin tarikhe pardakhte ejare ra vared konid.");
        String rent_last_payment;
        do {
            condition = false;
            System.out.print("sal:  ");
            sal = input.nextInt();
            if ((sal>1403)||(sal<1401)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        } while (condition);

        do {
            condition = false;
            System.out.print("mah:  ");
            mah = input.nextInt();
            if ((mah>12)||(mah<1)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        } while (condition);

        do {
            condition = false;
            System.out.print("rooz:  ");
            rooz = input.nextInt();
            if ((rooz>31)||(rooz<1)){
                System.out.println("lotfan adad ra ba deghat vared konid!!!");
                condition = true;
            }
        } while (condition);
        rent_last_payment = String.format("%d-%d-%d", sal, mah, rooz);


        String last_update = "0000-00-00";


        Vahed_payment vahed_payment = new Vahed_payment(id,water_debt,electricity_debt,gas_debt,rent_debt,water_last_payment,electricity_last_payment,gas_last_payment,rent_last_payment,last_update);


        return vahed_payment;
    }

}
