

/////// ghesmate set hara mesle Saken kardan (Saken.first_name)

public class Vahed{                             //baraye sakhte moshkhasate har vahed
    private static int vahed_id;
    private static String warning ;
    private static int tabaghe ;
    private static String vaziat ;
    private static int metrazh;
    private static int tedade_otaghe;
    private static int tedade_sakenane ;
    private static String mohlate_sokoonat ;
    private static String tarikhe_saken_shodan ;


    public Vahed(){
    }
    public Vahed(int id,String warning,int tabaghe,String vaziat,int metrazh,int tedade_otaghe,int tedade_sakenane,String mohlate_sokoonate,String tarikhe_saken_shodan){
        setVahed_id(id);
        setWarning(warning);
        setTabaghe(tabaghe);
        setVaziat(vaziat);
        setMetrazh(metrazh);
        setTedade_otaghe(tedade_otaghe);
        setTedade_sakenane(tedade_sakenane);
        setMohlate_sokoonat(mohlate_sokoonate);
        setTarikhe_saken_shodan(tarikhe_saken_shodan);
    }

    public void setVahed_id(int id){
        this.vahed_id = id;
    }
    public static int getVahed_id() {
        return vahed_id;
    }

    public void setWarning(String warning){
        this.warning = warning;
    }
    public static String getWarning(){
        return warning;
    }

    public void setTabaghe(int tabaghe){
        this.tabaghe = tabaghe;
    }
    public static int getTabaghe() {
        return tabaghe;
    }

    public void setVaziat(String vaziat){
        this.vaziat = vaziat;
    }
    public static String getVaziat(){
        return vaziat;
    }

    public void setMetrazh(int metrazh) {
        this.metrazh = metrazh;
    }
    public static int getMetrazh() {
        return metrazh;
    }

    public void setTedade_otaghe(int tedade_otaghe) {
        this.tedade_otaghe = tedade_otaghe;
    }
    public static int getTedade_otaghe() {
        return tedade_otaghe;
    }

    public void setTedade_sakenane(int tedade_sakenane) {
        this.tedade_sakenane = tedade_sakenane;
    }
    public static int getTedade_sakenane() {
        return tedade_sakenane;
    }

    public void setMohlate_sokoonat(String mohlate_sokoonat) {
        this.mohlate_sokoonat = mohlate_sokoonat;
    }
    public static String getMohlate_sokoonate_vahed() {
        return mohlate_sokoonat;
    }

    public void setTarikhe_saken_shodan(String tarikhe_saken_shodan) {
        this.tarikhe_saken_shodan = tarikhe_saken_shodan;
    }
    public static String getTarikhe_saken_shodan() {
        return tarikhe_saken_shodan;
    }



    public void getString() {
        System.out.printf("id vahed: %d\n",getVahed_id());
        System.out.printf("ekhtar: %s\n",getWarning());
        System.out.printf("vaziate vahed: %s\n",getVaziat());
        System.out.printf("vaghe dar tabaghe %d ba metrazhe: %d , tedade otaghe: %d ,tedade sakenane: %d",getTabaghe(),getMetrazh(),getTedade_otaghe(),getTedade_sakenane());
        System.out.printf("akharin mohlate sokoonat: %s",getMohlate_sokoonate_vahed());
        System.out.printf("tarikhe saken shodan: %s",getTarikhe_saken_shodan());
    }
















}
