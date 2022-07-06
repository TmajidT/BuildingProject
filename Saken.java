public class Saken {
    private static int code_meli;
    private static String first_name;
    private static String last_name;
    private static int is_landlord;
    private static String request;
    private static int vahed_id;
    private static String last_update;



    public Saken(){
    }

    public Saken(int code_meli,String first_name,String last_name,int is_landlord,String request,int vahed_id,String last_update){
        setCode_meli(code_meli);
        setFirst_name(first_name);
        setLast_name(last_name);
        setIs_landlord(is_landlord);
        setRequest(request);
        setVahed_id(vahed_id);
        setLast_update(last_update);
    }

    public static void setCode_meli(int code_meli){
        Saken.code_meli = code_meli;
    }
    public static int getCode_meli() {
        return code_meli;
    }

    public static void setFirst_name(String first_name) {
        Saken.first_name = first_name;
    }

    public static String getFirst_name() {
        return first_name;
    }

    public static void setLast_name(String last_name) {
        Saken.last_name = last_name;
    }
    public static String getLast_name() {
        return last_name;
    }


    public static void setIs_landlord(int is_landlord) {
        Saken.is_landlord = is_landlord;
    }
    public static int getIs_landlord() {
        return is_landlord;
    }

    public static void setRequest(String request) {
        Saken.request = request;
    }
    public static String getRequest() {
        return request;
    }

    public static void setVahed_id(int vahed_id) {
        Saken.vahed_id = vahed_id;
    }

    public static int getVahed_id() {
        return vahed_id;
    }

    public static void setLast_update(String last_update) {
        Saken.last_update = last_update;
    }

    public static String getLast_update() {
        return last_update;
    }

}
