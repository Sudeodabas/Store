import java.util.Set;
import java.util.TreeSet;

public class Products implements Comparable<Products> {
    private int id;
    private int price;
    private int discountRate;
    private int amountOfStock;
    private String productName;
    Brand brand;
    private int ram;
    private double screenSize;
    private static int count;
    static Set<Products> products=new TreeSet<>();

    public Products(int id,int price,int discountRate,int amountOfStock,String productName,Brand brand,int ram,double screenSize){
        count++;
        this.id=count;
        this.price=price;
        this.discountRate=discountRate;
        this.amountOfStock=amountOfStock;
        this.productName=productName;
        this.brand=brand;
        this.ram=ram;
        this.screenSize=screenSize;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getPrice(){
        double tempdiscountRate;
        tempdiscountRate=this.discountRate/100;
        tempdiscountRate=this.price*tempdiscountRate;
        this.price-=tempdiscountRate;
        return  price;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public int getDiscountRate(){
        return discountRate;
    }
    public void setDiscountRate(int discountRate){
        this.discountRate=discountRate;
    }
    public int getAmountOfStock(){
        return amountOfStock;
    }
    public void setAmountOfStock(int amountOfStock){
        this.amountOfStock=amountOfStock;
    }
    public String getProductName(){
        return productName;
    }
    public void setProductName(String productName){
        this.productName=productName;
    }
    public Brand getBrand(){
        return brand;
    }
    public void setBrand(Brand brand){
        this.brand=brand;
    }
    public int getRam(){
        return ram;
    }
    public void setRam(int ram){
        this.ram=ram;
    }
    public  double getScreenSize(){
        return screenSize;
    }
    public void setScreenSize(int screenSize){
        this.screenSize=screenSize;
    }
    @Override
    public int compareTo(Products o){
        if (this.getId()>o.getId()){
            return 1;
        } else if (o.getId()>this.getId()) {
            return -1;
        }
        else
            return 0;
    }

}
