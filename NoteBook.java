import java.util.Set;
import java.util.TreeSet;

public class NoteBook extends Products{
    private int storage;
    static Set<NoteBook> noteBooks=new TreeSet<>();
    public NoteBook(int id,int price,int discountRate,int amountOfStock,String productName,Brand brand,int ram,double screenSize,int storage){
        super(id,price,discountRate,amountOfStock,productName,brand,ram,screenSize);
        this.storage=storage;
    }
    public int getStorage(){
        return storage;
    }
    public void setStorage(int storage){
        this.storage=storage;
    }
}
