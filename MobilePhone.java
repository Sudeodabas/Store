import java.util.Set;
import java.util.TreeSet;

public class MobilePhone extends Products{
    private int memory;
    private int battery;
    private String color;
    private int camera;
    static Set<MobilePhone> mobilePhones=new TreeSet<>();
    public MobilePhone(int id,int price,int discountRate,int amountOfStock,String productName,Brand brand,int ram,double screenSize,int memory,int battery,String color,int camera){
        super(id,price, discountRate, amountOfStock, productName,brand, ram, screenSize);
        this.memory=memory;
        this.battery=battery;
        this.color=color;
        this.camera=camera;
    }
    public int getMemory(){
        return memory;
    }
    public void setMemory(int memory){
        this.memory=memory;
    }
    public int getBattery(){
        return battery;
    }
    public void setBattery(int battery){
        this.battery=battery;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color=color;
    }
    public int getCamera(){
        return camera;
    }
    public void setCamera(int camera){
        this.camera=camera;
    }
}
