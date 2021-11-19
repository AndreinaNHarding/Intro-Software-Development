/**
 * Write a description of class ProvinceTerritory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProvinceTerritory
{
    // instance variables - replace the example below with your own
    private String name;
    private int population;

    public ProvinceTerritory (String name, int population){
        setName(name);
        setPopulation(population);
    }

    
    public void setName(String name){
        if (name!=null){
            this.name=name;
        }
    }

    public String getName(){
        return name;
    }

    public void setPopulation(int population){
        if (population>0)
            this.population=population;
    }

    public int getPopulation(){
        return population;
    }
    
    
}
