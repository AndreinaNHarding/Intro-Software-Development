
/**
 * Class Canada.
 *
 * @author (Andreina Nunez)
 * @version (2019/03/27)
 */
import java.util.ArrayList;
public class Canada
{
    private ArrayList<ProvinceTerritory> provinces;
    /**
     * Canada Constructor
     *
     */
    public Canada(){
        provinces= new ArrayList<ProvinceTerritory>();
        provinces.add(new ProvinceTerritory("British Columbia", 4400057));
        provinces.add(new ProvinceTerritory("Alberta", 3645257));
        provinces.add(new ProvinceTerritory("Ontario", 12851821));
        provinces.add(new ProvinceTerritory("Quebec", 7903001));
        provinces.add(new ProvinceTerritory("Manitoba", 1208268));
        provinces.add(new ProvinceTerritory("Saskatchewan", 1033381));
        provinces.add(new ProvinceTerritory("Nova Scotia", 921727));
        provinces.add(new ProvinceTerritory("New Brunswick", 751171));
        provinces.add(new ProvinceTerritory("Newfoundland and Labrador", 514536));
        provinces.add(new ProvinceTerritory("Prince Edward Island", 140204));
        provinces.add(new ProvinceTerritory("Northwest Territories", 41462));
        provinces.add(new ProvinceTerritory("Yukon", 33897));
        provinces.add(new ProvinceTerritory("Nunavut", 31906));
        provinces.add(null);
    }

    /**
     * Method getTotalPopulation
     *
     * @return The total population of Canada
     */
    public int getTotalPopulation(){
        int totalPopulation=0;
        for(ProvinceTerritory province : provinces){
            if(province!=null){
                totalPopulation += province.getPopulation();
            }
        } 
        return totalPopulation;
    }  

    /**
     * Method getLowestPopulation
     *
     * @return  The province with the lowest population.
     */
    public String getLowestPopulation(){
        int LowestPopulation=getTotalPopulation();
        String nameOfLowest="";
        for(ProvinceTerritory province : provinces){
            if((province!=null) && (province.getPopulation()<LowestPopulation)){
                LowestPopulation = province.getPopulation();
                nameOfLowest=province.getName();
            }
        } 
        return  nameOfLowest;
    }

    /**
     * Method getHigestPopulation
     *
     * @return The name of the province with the higest population.
     */
    public ProvinceTerritory getHigestPopulation(){
        int HigestPopulation=0;
        ProvinceTerritory higestProvince=null;
        for(ProvinceTerritory province : provinces){
            if((province!=null) && (province.getPopulation()>HigestPopulation)){
                HigestPopulation = province.getPopulation();
                higestProvince= province;
            }
        } 
        return higestProvince;
    }

    /**
     * Method getPopulation
     *
     * @param province1 
     * @return The population of province1
     */
    public int getPopulation(String province1){
        if ((province1!=null) && (!province1.equals(""))){
            for(ProvinceTerritory province : provinces){
                if((province!=null) && (province.getName().equalsIgnoreCase(province1))){
                    return province.getPopulation();
                }
            }
        }else{
            throw new IllegalArgumentException("no valid name");
        }
        throw new IllegalArgumentException ("no valid province");
    }

    /**
     * Method isProvinceInCanada
     *
     * @param name 
     * @return true when name is the name of a province
     */
    public boolean isProvinceInCanada(String name){
        if ((name!=null) && (!name.equals(""))){
            for(ProvinceTerritory province : provinces){
                if(province.getName().equalsIgnoreCase(name)){
                    return true;
                } 
            }   
        }else{
            throw new IllegalArgumentException(" not null or empty values, please");
        }
        return false;
    }

    /**
     * Method getProvincesWhoseNamesStartsWith
     *
     * @param letter 
     * @return matching province(s).
     */
    public ArrayList<String> getProvincesWhoseNamesStartsWith(char letter){     
        ArrayList<String> matchingProvinces;
        String theProvince;
        matchingProvinces = new ArrayList<String>();
        for(ProvinceTerritory province : provinces){
            if((province!=null)&&(province.getName().charAt(0)==letter)){
                theProvince= province.getName();
                matchingProvinces.add(theProvince);   
            }
        }
        return matchingProvinces;
    }

    /**
     * Method getMoreProvincesWhoseNameContains
     *
     * @param substring 
     * @return matching province(s)
     */
    public ArrayList<ProvinceTerritory> getMoreProvincesWhoseNameContains(String substring){
        ArrayList<ProvinceTerritory> matchingProvinces;
        matchingProvinces = new ArrayList<>();
        if((substring!=null) && (!substring.equals(""))){
            for(ProvinceTerritory province : provinces){
                if((province!=null)&&(province.getName().contains(substring))){
                    province.getName();
                    matchingProvinces.add(province);   
                }
            }
            return matchingProvinces;
        } else{
            throw new IllegalArgumentException("no null or empty");
        }
    }

    /**
     * Method getProvincesWhoseNameContains
     *
     * @param substring
     * @return The matching province(s).
     */
    public ProvinceTerritory[] getProvincesWhoseNameContains (String substring){     

        int index=0;
        int j=0;
        int numOfProvWithPop = 0;
        ProvinceTerritory [] matchingProvinces;
        if((substring!=null) && (!substring.equals(""))){
            for(ProvinceTerritory province : provinces){    
                if((province!=null) && (province.getName().contains(substring))){
                    numOfProvWithPop++;
                }
            }
            if(numOfProvWithPop==0){
                return null;
            }
            
            matchingProvinces = new ProvinceTerritory[numOfProvWithPop];
            for(ProvinceTerritory province : provinces){   
                if((province!=null) && (province.getName().contains(substring))){
                    province.getName();
                    matchingProvinces[j] = province;
                    j++;
                }
            }
            return matchingProvinces;  
        }
        return null;
    }
}


