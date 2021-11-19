
/**
 * class Package.
 *
 * @author (Andreina Nunez)
 * @version (2019/03/19)
 */
public class Package
{
    //Variables
    private int trackingCode;
    private int priority=2;
    private double shippingPrice;
    private double weight=0.25;
    private String originCity;
    private String destCity;
    private String trackingPage="http://www.trackpackage.com";
    //Constants
    public static final int MIN_TRACKING_CODE=0;
    public static final int MAX_TRACKING_CODE=1000000000;
    public static final int MIN_PRIORITY=1;
    public static final int MAX_PRIORITY=3;
    public static final double MIN_SHIPPING_PRICE=0.0;
    public static final double MIN_WEIGHT=0.0;
    public static final double MAX_WEIGHT=100.0;

    /**
     * Package Constructor
     *
     * @param trackingCode 
     * @param shippingPrice 
     * @param originCity 
     * @param destinationCity 
     */
    public Package(int trackingCode, double shippingPrice,
    String originCity, String destCity){             
        setTrackingCode(trackingCode);
        setShippingPrice(shippingPrice);
        setOriginCity(originCity);
        setDestCity(destCity);
    }   

    /**
     * Package Constructor
     *
     * @param trackingCode 
     * @param priority
     * @param shippingPrice
     * @param weight
     * @param originCity 
     * @param destinationCity 
     * @param trackingPage
     */
    public Package(int trackingCode, int priority,  double shippingPrice, double weight,
    String originCity, String destCity , String trackingPage){             
        setTrackingCode(trackingCode);
        setPriority (priority);
        setShippingPrice(shippingPrice);
        setWeight (weight);
        setOriginCity(originCity);
        setDestCity(destCity);
        setTrackingPage(trackingPage);
    }  

    /**
     * Method setTrackingCode
     *
     * @param trackingCode
     */
    public void setTrackingCode(int trackingCode){
        if ((trackingCode>=MIN_TRACKING_CODE) && (trackingCode<=MAX_TRACKING_CODE)){
            this.trackingCode=  trackingCode;
        } else if(trackingCode<MIN_TRACKING_CODE){
            throw new IllegalArgumentException("Sorry, tracking code cannot be negative.");    
        }else if ( trackingCode>MAX_TRACKING_CODE){
            throw new IllegalArgumentException ("Sorry, tracking code " + trackingCode + " is too large.");
        }
    }
    /**
     * Method getTrackingCode
     *
     * @return The tracking Code Number
     */
    public int getTrackingCode(){
        return trackingCode;
    }

    /**
     * Method setPriority
     *
     * @param priority 
     */
    public void setPriority (int priority){
        if((priority>=MIN_PRIORITY) && (priority<=MAX_PRIORITY)){
            this.priority=priority;
        } else if(priority<0){
            throw new IllegalArgumentException ("Priority must be either 1, 2 or 3.");
        }else if(priority>MAX_PRIORITY){
            throw new IllegalArgumentException ("Priority must be either 1, 2 or 3.");
        }
    }
    /**
     * Method getPriority
     *
     * @return The priority Number
     */
    public int getPriority(){
        return priority;
    }

    /**
     * Method setShippingPrice
     *
     * @param shippingPrice 
     */
    public void setShippingPrice(double shippingPrice){
        if(shippingPrice>MIN_SHIPPING_PRICE){
            this.shippingPrice=shippingPrice;
        } else if(shippingPrice<MIN_SHIPPING_PRICE){
            throw new IllegalArgumentException ("Shipping Price cannot be negative.");
        }
    }
    /**
     * Method getShippingPrice
     *
     * @return The Shipping Price
     */
    public double getShippingPrice(){
        return shippingPrice;
    }

    /**
     * Method setWeight
     *
     * @param weight 
     */
    public void setWeight (double weight){
        if((weight>=MIN_WEIGHT) && (weight<=MAX_WEIGHT)){
            this.weight=weight;
        }else if(weight<MIN_WEIGHT){
            throw new IllegalArgumentException ("Weight must be between 0.0 and 100.0lbs.");
        }else if(weight>MAX_WEIGHT){
            throw new IllegalArgumentException ("Weight must be between 0.0 and 100.0lbs.");
        }
    }
    /**
     * Method getWeight
     *
     * @return The Weigth 
     */
    public double getWeight (){
        return weight;
    }

    /**
     * Method setOriginCity
     *
     * @param originCity 
     */
    public void setOriginCity (String originCity){
        if (originCity!=null){
             this.trackingPage=trackingPage;
            }else{
                 
            throw new IllegalArgumentException("The Origin City is not valid.");
        }
        if (!originCity.equals("")){    
            this.originCity=originCity;     
        }else{
            throw new IllegalArgumentException("The Origin City is not set.");
        } 
    }
    /**
     * Method getOriginCity
     *
     * @return the Origin City
     */
    public String getOriginCity (){
        return originCity;
    }

    /**
     * Method setDestCity
     *
     * @param destCity 
     */
    public void setDestCity (String destCity){
        if (destCity == null) {
            throw new IllegalArgumentException("The Destination City is not valid.");
        }
        if (destCity.equals("")) {
            throw new IllegalArgumentException("The Destination City is not set.");
        }
        this.destCity = destCity;
    }
    /**
     * Method getDestCity
     *
     * @return The Destination City
     */
    public String getDestCity (){
        return destCity;
    }

    /**
     * Method setTrackingPage
     *
     * @param trackingPage 
     */
    public void setTrackingPage (String trackingPage){
        if(trackingPage!=null){
            this.trackingPage=trackingPage;
        } else{
            throw new IllegalArgumentException("The Tracking Page is not valid.");
        }   
        if(!trackingPage.equals("")){
            this.trackingPage=trackingPage;
        } else{
            throw new IllegalArgumentException("The Tracking Page is not set.");
        } 
    }
    /**
     * Method getTrackingPage
     *
     * @return The Tracking Web Page
     */
    public String getTrackingPage (){
        return trackingPage;
    }

    /**
     * Method getPackageDetails
     *
     * @return The Details of the Package
     */
    public String getPackageDetails(){
        String details= ("Package " + getTrackingCode() + " ships from " + getOriginCity () + " to " + getDestCity ()
                + " for $" + getShippingPrice() + " with priority " + getPriority() + " and weight of " + getWeight () +
                "lbs. Tracking details at " + getTrackingPage() + ".");

        return details;
    } 
}