/**
 * Write a description of class Canada here.
 *
 * @author (Andreina Nunez)
 * @version (2019/03/12)
 */
public class Canada
{
    //Constants

    private static final int NUM_PROVIDENCES=13;
    private static final int BC=0;
    private static final int AB=1;
    private static final int ONTARIO=2;
    private static final int QUEBEC=3;
    private static final int MANITOBA=4;
    private static final int SASKATCHEWAN=5;
    private static final int NOVA_SCOTIA=6;
    private static final int NEW_B=7;
    private static final int NEWFOUNDLAND=8;
    private static final int PRINCE_EDWARD=9;
    private static final int NORTHWEST=10;
    private static final int YUKON=11;
    private static final int NUNAVUT=12;
    private static final int NO_SUCH_PROVINCE=-1;

    private ProvinceTerritory[] provinces;
    public Canada(){
        provinces = new ProvinceTerritory[NUM_PROVIDENCES];
        provinces[BC]= new ProvinceTerritory("British Columbia", 4400057);
        provinces[AB]= new ProvinceTerritory("Alberta", 3645257);
        provinces[ONTARIO]= new ProvinceTerritory("Ontario", 12851821);
        provinces[QUEBEC]= new ProvinceTerritory("Quebec", 7903001);
        provinces[MANITOBA]= new ProvinceTerritory("Manitoba", 1208268);
        provinces[SASKATCHEWAN]= new ProvinceTerritory("Saskatchewan", 1033381);
        provinces[NOVA_SCOTIA]= new ProvinceTerritory("Nova Scotia", 921727);
        provinces[NEW_B]= new ProvinceTerritory("New Brunswick", 751171);
        provinces[NEWFOUNDLAND]= new ProvinceTerritory("Newfoundland and Labrador", 514536);
        provinces[PRINCE_EDWARD]= new ProvinceTerritory("Prince Edward Island", 140204);
        provinces[NORTHWEST]= new ProvinceTerritory("Northwest Territories", 41462);
        provinces[YUKON]= new ProvinceTerritory("Yukon", 33897);
        provinces[NUNAVUT]= new ProvinceTerritory("Nunavut", 31906);
    }

    /**
     * Method getTotalPopulation
     *
     * @return The total population of Canada.
     */
    public int getTotalPopulation(){
        int index=0;
        int totalPopulation=0;

        while(index<provinces.length){
            totalPopulation += provinces[index].getPopulation();
            index++;
        }

        return totalPopulation;
    }

    /**
     * Method getLowestPopulation
     *
     * @return The lowest population of all provinces.
     */
    public String getLowestPopulation(){
        int index=0;
        int lowestPopulation=getTotalPopulation();
        String nameOfLowest="";

        while(index<provinces.length){

            if(provinces[index].getPopulation()< lowestPopulation){
                lowestPopulation=provinces[index].getPopulation();
                nameOfLowest=provinces[index].getName();
            }
            index++;
        }
        return nameOfLowest;

    }

    /**
     * Method getPopulation
     *
     * @param province 
     * @return The return the population of the province
     */
    public int getPopulation(String province){

        int index=0;
        if((province!=null) && (!province.equals(""))){
            while(index<provinces.length){

                if(provinces[index].getName().equalsIgnoreCase(province)){

                    return provinces[index].getPopulation();
                }
                index ++;

            } 
        }else{
            throw new IllegalArgumentException("no valid name");
        }
        return NO_SUCH_PROVINCE;
    }

    /** 
     * Gets all provinces with populations between the given range
     * 
     * @param min Minimum population
     * @param max Maximum population
     */
    public String[] getProvincesWithPopulationBetween(int min, int max) {
        int i= 0;
        int j= 0;  // the new array index
        int      numOfProvWithPop = 0;
        String[] matchingProvinces;

        while(i < provinces.length){
            if((provinces[i].getPopulation() >= min) && 
            (provinces[i].getPopulation() <= max)){
                numOfProvWithPop++;
            }
            i++;
        }

        if(numOfProvWithPop > 0){
            matchingProvinces = new String[numOfProvWithPop];
        }else{
            //no matches
            return null;
        }

        i = 0;	// start looking from the beginning again
        while(i < provinces.length){
            if((provinces[i].getPopulation()>= min) && 
            (provinces[i].getPopulation()<= max)){
                matchingProvinces[j] = provinces[i].getName();
                j++;
            }
            i++;
        }
        return matchingProvinces;   
    }

    /**
     * Method isProvinceInCanada
     *
     * @param name 
     * @return True if name is a province otherwise return false
     */
    public boolean isProvinceInCanada(String name){
        int index=0;
        if((name!=null) && (!name.equals(""))){
            while(index<provinces.length){
                if(provinces[index].getName().equalsIgnoreCase(name)){
                    return true;

                }
                index++;
            }  
        }else{
            throw new IllegalArgumentException(" not null or empty values, please");
        }
        return false;
    }

    /**
     * Method getProvincesWhoseNameStartsWith
     *
     * @param letter A parameter
     * @return matchingProvinces: an array of the provinces that contain the char letter value.
     */
    public String[] getProvincesWhoseNameStartsWith (char letter){
        int index=0;
        int j=0;
        int numOfProvWithPop = 0;
        String[] matchingProvinces;
        char firstLetter;

        while(index<provinces.length){
            firstLetter=(provinces[index].getName()).charAt(0);

            if((provinces[index].getName()).charAt(0)==letter){
                numOfProvWithPop++;
            }

            index++;
        }

        if(numOfProvWithPop > 0){
            matchingProvinces = new String[numOfProvWithPop];
        }else{
            return null;
        }

        index = 0;	
        while(index < provinces.length){
            if((provinces[index].getName()).charAt(0)==letter){
                matchingProvinces[j] = provinces[index].getName();
                j++;
            }
            index++;
        }
        return matchingProvinces;  
    }

    /**
     * Method getProvincesWhoseNameContains
     *
     * @param substring A parameter
     * @return matchingProvinces: an array of the provinces that contain the substring value.
     */
    public String [] getProvincesWhoseNameContains(String substring){

        int index=0;
        int j=0;
        int numOfProvWithPop = 0;
        String[] matchingProvinces;

        while(index<provinces.length){
            if(provinces[index].getName().contains(substring)){
                numOfProvWithPop++;

            }
            index++;
        }

        if(numOfProvWithPop > 0){
            matchingProvinces = new String[numOfProvWithPop];
        }else{
            return null;
        }

        index = 0;	
        while(index < provinces.length){
            if(provinces[index].getName().contains(substring)){
                matchingProvinces[j] = provinces[index].getName();
                j++;
            }
            index++;
        }
        return matchingProvinces;  
    }

    /**
     * Method getMoreProvincesWhoseNameContains
     *
     * @param substring A parameter
     * @return matchingProvinces: an array of the provinces that contain the substring value.
     */
    public ProvinceTerritory[] getMoreProvincesWhoseNameContains(String substring){

    int index=0;
    int j=0;
    int numOfProvWithPop = 0;
    ProvinceTerritory [] matchingProvinces;

    while(index<provinces.length){

    if(provinces[index].getName().contains(substring)){
    numOfProvWithPop++;
    }
    index++;
    }

    if(numOfProvWithPop > 0){
     matchingProvinces = new ProvinceTerritory[numOfProvWithPop ];
    }else{
    return null;
    }
     index = 0;	
    while(index < provinces.length){
    if(provinces[index].getName().contains(substring)){
        provinces[index].getName();
    matchingProvinces[j] = provinces[index];
    j++;
    }
    index++;
    }
    return matchingProvinces;     
    }

    }
