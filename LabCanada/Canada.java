
/**
 * Write a description of class Canada here.
 *
 * @author (Andreina Nunez)
 * @version (2019/03/18)
 */
public class Canada
{
    //Constants:
    public static final int NUM_PROVINCES=13;
    public static final int NUM_ELEMENTS=3;

    public static final int ON=0;
    public static final int QC=1;
    public static final int NS=2;
    public static final int NB=3;
    public static final int MN=4;
    public static final int BC=5;
    public static final int PE=6;
    public static final int SK=7;
    public static final int AB=8;
    public static final int NL=9;
    public static final int YK=10;
    public static final int NV=11;
    public static final int NT=12;

    public static final int NAME_OF_PROVINCE=0;
    public static int NAME_OF_CAPITAL=1;
    public static final int NAME_OF_BIGGEST=2;

    private String [] [] provinces;

    /**
     * Canada Constructor
     *
     */
    public Canada(){

        provinces= new String [NUM_PROVINCES] [NUM_ELEMENTS];

        provinces [ON] [NAME_OF_PROVINCE]= "Ontario";
        provinces [ON] [NAME_OF_CAPITAL]="Toronto";
        provinces [ON] [NAME_OF_BIGGEST]="Toronto";

        provinces [QC] [NAME_OF_PROVINCE]= "Quebec";
        provinces [QC] [NAME_OF_CAPITAL]="Quebec City";
        provinces [QC] [NAME_OF_BIGGEST]="Monteral";

        provinces [NS] [NAME_OF_PROVINCE]= "Nova Scotia";
        provinces [NS] [NAME_OF_CAPITAL]="Halifax";
        provinces [NS] [NAME_OF_BIGGEST]="Halifax";

        provinces [NB] [NAME_OF_PROVINCE]= "New Brunswick";
        provinces [NB] [NAME_OF_CAPITAL]="Frederiction";
        provinces [NB] [NAME_OF_BIGGEST]="Saint John";

        provinces [MN] [NAME_OF_PROVINCE]= "Manitoba";
        provinces [MN] [NAME_OF_CAPITAL]="Winnepeg";
        provinces [MN] [NAME_OF_BIGGEST]="Winnepeg";

        provinces [BC] [NAME_OF_PROVINCE]= "British Columbia";
        provinces [BC] [NAME_OF_CAPITAL]="Victoria";
        provinces [BC] [NAME_OF_BIGGEST]="Vancouver";

        provinces [PE] [NAME_OF_PROVINCE]= "Prince Edward Island";
        provinces [PE] [NAME_OF_CAPITAL]="Charlottetown";
        provinces [PE] [NAME_OF_BIGGEST]="Charlottetown";

        provinces [SK] [NAME_OF_PROVINCE]= "Saskatchewan";
        provinces [SK] [NAME_OF_CAPITAL]="Regina";
        provinces [SK] [NAME_OF_BIGGEST]="Saskatoon";

        provinces [AB] [NAME_OF_PROVINCE]= "Alberta";
        provinces [AB] [NAME_OF_CAPITAL]="Edmonton";
        provinces [AB] [NAME_OF_BIGGEST]="Calgary";

        provinces [NL] [NAME_OF_PROVINCE]= "Newfoundland and Labrador";
        provinces [NL] [NAME_OF_CAPITAL]="St. John's";
        provinces [NL] [NAME_OF_BIGGEST]="St. John's";

        provinces [YK] [NAME_OF_PROVINCE]= "Yukon";
        provinces [YK] [NAME_OF_CAPITAL]="Whitehorse";
        provinces [YK] [NAME_OF_BIGGEST]="Whitehorse";

        provinces [NV] [NAME_OF_PROVINCE]= "Nunavut";
        provinces [NV] [NAME_OF_CAPITAL]="Iqaluit";
        provinces [NV] [NAME_OF_BIGGEST]="Iqaluit";

        provinces [NT] [NAME_OF_PROVINCE]= "Northwest Territories";
        provinces [NT] [NAME_OF_CAPITAL]="Yellowknife";
        provinces [NT] [NAME_OF_BIGGEST]="Yellowknife";

    }

    /**
     * Method getCapitalCityOf
     *
     * @param province 
     * @return Name of the Capital
     */
    public String getCapitalCityOf(String province){     
        for(int i=0; i < provinces.length; i++){
            if((province!=null) && (!province.equals(""))  && (provinces[i][NAME_OF_PROVINCE].equalsIgnoreCase(province))){
                return provinces[i][NAME_OF_CAPITAL];
            } 
        }
                throw new IllegalArgumentException ("Not a province");
    }

    /**
     * Method getLargestCityOf
     *
     * @param province 
     * @return Name of the biggest city
     */
    public String getLargestCityOf(String province){
        for(int i=0; i < provinces.length; i++){
            if((province!=null) && (!province.equals(""))  && (provinces[i][NAME_OF_PROVINCE].equalsIgnoreCase(province))){

                return provinces[i][NAME_OF_BIGGEST];
            } 
        }
         throw new IllegalArgumentException ("Not a province");
    }

    /**
     * Method getProvinceWhoseCapitalIs
     *
     * @param city 
     * @return Name of the province
     */
    public String getProvinceWhoseCapitalIs(String city){
        for(int i=0; i < provinces.length; i++){
            if((city!=null) && (!city.equals(""))  && (provinces[i][NAME_OF_CAPITAL].equalsIgnoreCase(city))){

                return provinces[i][NAME_OF_PROVINCE];
            } 
        }
        throw new IllegalArgumentException ("Not a city");

    }

    /**
     * Method displayAllProvinceInfo
     *
     */
    public void displayAllProvinceInfo(){
        for(int i=0; i < provinces.length; i++){
            if(!provinces [i] [NAME_OF_CAPITAL].equalsIgnoreCase(provinces [i] [NAME_OF_BIGGEST])){
                System.out.println ( "The capital city of " + provinces [i] [NAME_OF_PROVINCE] + " is " +  provinces [i] [NAME_OF_CAPITAL] + ", but the largest city is " +
                    provinces [i] [NAME_OF_BIGGEST]);
            } else{
                System.out.println ( "The capital city of " + provinces [i] [NAME_OF_PROVINCE] + " is " +  provinces [i] [NAME_OF_CAPITAL] + ", and it is also the largest city");

            }
        }
      }
}
