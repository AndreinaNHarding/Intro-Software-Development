import java.util.*;
/**
 * class Package.
 *
 * @author (Andreina Nunez)
 * @version (2019/03/19)
 */
public class Warehouse
{
    //Variable
    private ArrayList<Package>packages;

    /**
     * Warehouse Constructor
     *
     * @param packages
     */
    public Warehouse(Package[] packages){    
        this.packages=new ArrayList <> ();
        if(packages==null){
            throw new IllegalArgumentException("List of Packages cannot be null.");
        }else{
            for (int i=0; i<packages.length; i++){
                this.packages.add(packages[i]);
            }

            for (int ii = 0 ; ii < packages.length ; ii++)
            {
            for (int jj = 0 ; jj < packages.length ; jj++)
            {
            if ((ii != jj) && (packages[ii].getTrackingCode() == packages[jj].getTrackingCode())){

            throw new IllegalArgumentException("Duplicate Tracking Code found: " + packages[jj].getTrackingCode());

            }
            }
            }

        }
    }

    /**
     * Method getNumPackages
     *
     * @return The size of the Package List.
     */
    public int getNumPackages(){
        return packages.size();
    }

    /**
     * Method getTotalPackageValue
     *
     * @return The Total Price of the shipping package
     */
    public double getTotalPackageValue(){
        double totalValue=0;
        for(Package pack: packages){
            if(pack!=null){
                totalValue+=pack.getShippingPrice();
            }
        }
        return totalValue;
    }

    /**
     * Method findPackagesByPriority
     *
     * @param packagePriority
     * @return The Package filter by certain priority
     */
    public Package[] findPackagesByPriority(int packagePriority){
        Package [] findPackagesByPriority;
        int matching=0;
        int i=0;
        if(packagePriority>=1 && packagePriority<=3){
            for(Package pack: packages){
                if((pack!=null) && (pack.getPriority()==packagePriority)){
                    pack.getPriority();
                    matching++;
                }
            }
            if( matching==0){
                return null;
            } else {
                findPackagesByPriority= new Package [matching];
            }
            for(Package pack: packages){
                if((pack!=null) && (pack.getPriority()==packagePriority)){
                    pack.getPriority();
                    findPackagesByPriority[i]=pack;
                    i++;
                }
            }
        }else{
            throw new IllegalArgumentException ("Priority must be either 1, 2 or 3.");
        }
        return findPackagesByPriority;
    }

    /**
     * Method findPackagesAboveWeight
     *
     * @param packageWeight 
     * @return The Packages above certain weight
     */
    public Package[] findPackagesAboveWeight(double packageWeight){
        Package [] findPackagesAboveWeight;
        int matching=0;
        int i=0;
        if(packageWeight<0.0 ||packageWeight>100.0){
            throw new IllegalArgumentException("Weight must be between 0.0 and 100.0lbs.");
        }else{
            for(Package pack: packages){
                if((pack!=null) && (pack.getWeight()>packageWeight)){
                    pack.getWeight ();
                    matching++;
                }
            }
            if( matching==0){
                return null;
            } else {
                findPackagesAboveWeight= new Package [matching];
            }
            for(Package pack: packages){
                if((pack!=null) && (pack.getWeight()>packageWeight)){
                    pack.getWeight ();
                    findPackagesAboveWeight[i]=pack;
                    i++;
                }
            }  
        }
        return findPackagesAboveWeight;
    }

    /**
     * Method findPackagesBelowWeight
     *
     * @param packageWeight
     * @return The Packages below certain weight
     */
    public Package[] findPackagesBelowWeight(double packageWeight){
        Package [] findPackagesBelowWeight;
        int matching=0;
        int i=0;
        if(packageWeight<0.0||packageWeight>100.0){
            throw new IllegalArgumentException("Weight must be between 0.0 and 100.0lbs.");
        }else{
            for(Package pack: packages){
                if((pack!=null) && (pack.getWeight()<packageWeight)){
                    pack.getWeight ();
                    matching++;
                }
            }
            if( matching==0){
                return null;
            } else {
                findPackagesBelowWeight= new Package [matching];
            }
            for(Package pack: packages){
                if((pack!=null) && (pack.getWeight()<packageWeight)){
                    pack.getWeight ();
                    findPackagesBelowWeight[i]=pack;
                    i++;
                }
            }
        }
        return findPackagesBelowWeight;  
    } 

    /**
     * Method shipPackageByTrackingCode
     *
     * @param theTrackingCode 
     * @return The shipped Packages
     */
    public Package shipPackageByTrackingCode(int theTrackingCode){
        Package shippedPackage = null;
        if(theTrackingCode<0){
            throw new IllegalArgumentException("Sorry, tracking code " + theTrackingCode + " cannot be negative.");
        }else if(theTrackingCode>1000000000){
            throw new IllegalArgumentException("Sorry, tracking code " +theTrackingCode +" is too large.");
        }else{
            Iterator<Package> it = packages.iterator();   
            while(it.hasNext()) {
                Package currPackage = it.next();            
                if (currPackage.getTrackingCode()==theTrackingCode){
                    shippedPackage =currPackage;
                    it.remove();    
                }
            }     
        }
        return shippedPackage;    
    }

    /**
     * Method shipPackagesByDestinationCity
     *
     * @param theDestCity 
     * @return The shipped packages
     */
    public Package[] shipPackagesByDestinationCity(String theDestCity){
        Package []  shippedPackage; ;
        int matching=0;
        int i=0;
        if(theDestCity==null) {
            throw new IllegalArgumentException("The Destination City is not valid.");
        }else if(theDestCity.equals("")) {
            throw new IllegalArgumentException("The Destination City is not set.");  
        }else{
            for(Package pack: packages){
                if((pack!=null) && (pack.getDestCity().equals(theDestCity))){
                    pack.getDestCity();
                    matching++;
                }
            }
            if( matching<0){
                throw new IllegalArgumentException ("BadCity");
            } else {
                shippedPackage= new Package [matching];
            }
            for(Package pack: packages){
                if((pack!=null) && ( pack.getDestCity().equals(theDestCity))){
                    pack.getDestCity ();
                    shippedPackage[i]= pack;
                    i++;
                }
            }
        }     
        Iterator<Package> it = packages.iterator();   
        while(it.hasNext()) {
            Package currPackage = it.next();            
            if (currPackage.getDestCity()==theDestCity){  
                it.remove();    
            }
        }     
        return  shippedPackage;  
    }

    /**
     * Method addPackage
     *
     * @param newPackage 
     */
    public void addPackage(Package newPackage){
        int number;
        int packnumber= newPackage.getTrackingCode();   
        for(Package pack: packages){
            if((pack!=null) && (pack.getTrackingCode()==packnumber)){
                throw new IllegalArgumentException("Tracking Code is not unique.");                  
            }            
        }
        packages.add(newPackage);
    }
}

