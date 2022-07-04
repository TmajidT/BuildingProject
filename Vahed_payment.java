public class Vahed_payment {
    private static int vahed_id;
    private static double water_debt;
    private static double electricity_debt;
    private static double gas_debt;
    private static double rent_debt;
    private static String water_last_payment;
    private static String electricity_last_payment;
    private static String gas_last_payment;
    private static String rent_last_payment;
    private static String last_update;


    public Vahed_payment (){
    }

    public Vahed_payment(int vahed_id,double water_debt,double electricity_debt,double gas_debt,double rent_debt,String water_last_payment,String electricity_last_payment,String gas_last_payment,String rent_last_payment,String last_update){
        setVahed_id(vahed_id);
        setWater_debt(water_debt);
        setElectricity_debt(electricity_debt);
        setGas_debt(gas_debt);
        setRent_debt(rent_debt);
        setWater_last_payment(water_last_payment);
        setElectricity_last_payment(electricity_last_payment);
        setGas_last_payment(gas_last_payment);
        setRent_last_payment(rent_last_payment);
        setLast_update(last_update);
    }

    public static void setVahed_id(int vahed_id){
        Vahed_payment.vahed_id = vahed_id;
    }
    public static int getVahed_id(){
        return vahed_id;
    }


    public static void setWater_debt(double water_debt){
        Vahed_payment.water_debt = water_debt;
    }
    public static double getWater_debt(){
        return water_debt;
    }

    public static void setElectricity_debt(double electricity_debt) {
        Vahed_payment.electricity_debt = electricity_debt;
    }
    public static double getElectricity_debt() {
        return electricity_debt;
    }


    public static void setGas_debt(double gas_debt) {
        Vahed_payment.gas_debt = gas_debt;
    }
    public static double getGas_debt() {
        return gas_debt;
    }


    public static void setRent_debt(double rent_debt) {
        Vahed_payment.rent_debt = rent_debt;
    }
    public static double getRent_debt() {
        return rent_debt;
    }


    public static void setWater_last_payment(String water_last_payment) {
        Vahed_payment.water_last_payment = water_last_payment;
    }
    public static String getWater_last_payment() {
        return water_last_payment;
    }


    public static void setElectricity_last_payment(String electricity_last_payment) {
        Vahed_payment.electricity_last_payment = electricity_last_payment;
    }
    public static String getElectricity_last_payment() {
        return electricity_last_payment;
    }


    public static void setGas_last_payment(String gas_last_payment) {
        Vahed_payment.gas_last_payment = gas_last_payment;
    }
    public static String getGas_last_payment() {
        return gas_last_payment;
    }


    public static void setRent_last_payment(String rent_last_payment) {
        Vahed_payment.rent_last_payment = rent_last_payment;
    }
    public static String getRent_last_payment() {
        return rent_last_payment;
    }


    public static void setLast_update(String last_update) {
        Vahed_payment.last_update = last_update;
    }
    public static String getLast_update() {
        return last_update;
    }
}
