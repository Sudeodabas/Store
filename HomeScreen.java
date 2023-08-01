import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HomeScreen {

    Scanner input=new Scanner(System.in);
    static {
        Brand.brands.add(new Brand("Samsung"));
        Brand.brands.add(new Brand("Apple"));
        Brand.brands.add(new Brand("Lenovo"));
        Brand.brands.add(new Brand("Huawei"));
        Brand.brands.add(new Brand("Casper"));
        Brand.brands.add(new Brand("Asus"));
        Brand.brands.add(new Brand("HP"));
        Brand.brands.add(new Brand("Xiaomi"));
        Brand.brands.add(new Brand("Monster"));

        MobilePhone.mobilePhones.add(new MobilePhone(1,3199,15,5,"Samsung Galaxy A51",new Brand("Samsung"),6,6.5,128,4000,"siyah",32));
        MobilePhone.mobilePhones.add(new MobilePhone(2,7379,15,6,"Iphone 11",new Brand("Apple"),12,6.1,64,4100,"beyaz",5));
        MobilePhone.mobilePhones.add(new MobilePhone(3,4012,15,5,"Redmi Note 10 Pro",new Brand("Xiaomi"),6,6.5,128,5000,"pembe",35));

        NoteBook.noteBooks.add(new NoteBook(1,7000,15,5,"Huawei Matebook 14",new Brand("Huawei"),16,14,512));
        NoteBook.noteBooks.add(new NoteBook(2,3699,15,5,"Lenovo V14 IGL",new Brand("Lenovo"),8,14,1024));
        NoteBook.noteBooks.add(new NoteBook(3,8199,15,4,"Asus Tuf Gaming",new Brand("Asus"),32,15.6,2048));

        Products.products.addAll(MobilePhone.mobilePhones);
        Products.products.addAll(NoteBook.noteBooks);
    }
    public void run() {
        while (true) {
            System.out.println("Patika Store Ürün Yönetim Paneli! ");
            System.out.println("1- Notebook İşlemleri");
            System.out.println("2- Cep Telefonu İşlemleri");
            System.out.println("3- Marka Listele");
            System.out.println("4- Yeni Ürün Ekleme");
            System.out.println("5- Ürün Silme");
            System.out.println("0- Çıkış Yap");
            System.out.print("Seçim: ");
            int select;
            try {
                select = input.nextInt();
            } catch (Exception e) {
                System.out.println("Geçersiz veri girişi yaptınız.");
                break;
            }
            if (select==0){
                break;
            }
            switch (select){
                case 1:
                    System.out.println("1- Notebook Listesi");
                    try {
                        Integer.parseInt(input.next());
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Çıkış yapıldı.");
                    }
                    if (select==1){
                        printListNotebook();
                    }
                    break;
                case 2:
                    System.out.println("2- Cep Telefonu Listesi");
                    try{
                        Integer.parseInt(input.next());
                    }
                    catch (NumberFormatException e){
                        System.out.println("Çıkış yapıldı");
                    }
                    if (select==2){
                        printListMobilePhone();
                    }
                    break;
                case 3:
                    printListBrand();
                    break;
                case 4:
                    addProduct();
                    break;
                case 5:
                    productDeletion();
                    break;

            }

        }

    }
    public void productDeletion(){
        System.out.println("Silmek istediğiniz ürünün ID numarasını giriniz: ");
        int id=input.nextInt();

        Set<Products> extraction=new TreeSet<>();
        for (Products p:Products.products) {
            if (p.getId()==id){
                extraction.add(p);
            }
        }
        Products.products.removeAll(extraction);
        NoteBook.noteBooks.removeAll(extraction);
        MobilePhone.mobilePhones.removeAll(extraction);
    }
    public void printListBrand(){
        System.out.println("Marka: ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Brand b:Brand.brands) {
            System.out.println(b.getName());
        }
    }
    public void printListMobilePhone(){
        System.out.println("Cep Telefonu Listesi");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-11s%12s%22s%11s%18s%11s%16s%15s%16s%n",
                "ID","Ürün Adı","Fiyat","Marka","Depolama","Ekran","Pil","RAM","Renk");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (MobilePhone m:MobilePhone.mobilePhones) {
            System.out.printf("%-10s%-30s%-11s%-17s%-13s%-17s%-15s%-15s%-15s%n",
                    m.getId(),m.getProductName(),m.getPrice(),m.getBrand().getName(),m.getMemory(),
                    m.getScreenSize(),m.getBattery(),m.getRam(),m.getColor());
        }
    }
    public void printListNotebook(){
        System.out.println("Notebook Listesi");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-11s%11s%23s%14s%10s%15s%15s%15s%16s%n",
                "ID","Ürün Adı","Fiyat","İndirim Oranı","Stok","Ekran","Marka","RAM","Depolama");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (NoteBook n:NoteBook.noteBooks) {
            System.out.printf("%-10s%-30s%-11s%-15s%-13s%-15s%-15s%-15s%-15s%n",
                    n.getId(),n.getProductName(),n.getPrice(), n.getDiscountRate(),n.getAmountOfStock(),
                    n.getScreenSize(),n.getBrand().getName(),n.getRam(), n.getStorage());
        }
    }
    public void addProduct(){
        System.out.println("1- Cep Telefonu");
        System.out.println("2- Notebook");
        System.out.print("Eklemek istediğini ürünün kategorisini seçiniz: ");
        int protuctCategory= input.nextInt();
        if(protuctCategory==1){
            System.out.println("Eklemek istediğiniz cep telefonunun özelliklerini giriniz.");

            System.out.print("Ürün Adı:");
            input.nextLine();
            String protuctName=input.nextLine();


            System.out.print("Ürün Fiyatı: ");
            int price=input.nextInt();
            input.nextLine();

            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            printListBrand();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Eklemek istediğiniz ürünün markası nedir?");
            String brand=input.nextLine();
            String first;
            first=brand.substring(0,1).toUpperCase();
            brand=first+brand.substring(1);
            while (!Brand.brands.contains(new Brand(brand))){
                System.out.println("Geçersiz marka ismi! Lütfen tekrar deneyiniz.");
                brand=input.nextLine();
                first=brand.substring(0,1).toUpperCase();
                brand=first+brand.substring(1);
            }
            System.out.println("Depolama: ");
            int memory=input.nextInt();

            System.out.println("Ekran Boyutu: ");
            double screenSize=input.nextDouble();

            System.out.println("Pil: ");
            int battery=input.nextInt();

            System.out.println("Ram: ");
            int ram=input.nextInt();
            input.nextLine();

            System.out.println("Renk: ");
            String color=input.nextLine();
            input.nextLine();

            System.out.println("Ürün ekleme işlemi başarılı!");

            MobilePhone.mobilePhones.add(new MobilePhone(4,price,5,5,protuctName,new Brand(brand),ram,screenSize,memory,battery,color,32));
        }
        else if (protuctCategory==2) {
            System.out.println("Eklemek istediğiniz Notebook özelliklerini giriniz.");

            System.out.print("Ürün Adı:");
            input.nextLine();
            String protuctName=input.nextLine();


            System.out.print("Ürün Fiyatı: ");
            int price=input.nextInt();
            input.nextLine();

            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            printListBrand();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Eklemek istediğiniz ürünün markası nedir?");
            String brand=input.nextLine();
            String first;
            first=brand.substring(0,1).toUpperCase();
            brand=first+brand.substring(1);
            while (!Brand.brands.contains(new Brand(brand))){
                System.out.println("Geçersiz marka ismi! Lütfen tekrar deneyiniz.");
                brand=input.nextLine();
                first=brand.substring(0,1).toUpperCase();
                brand=first+brand.substring(1);
            }

            System.out.println("Depolama: ");
            int storage=input.nextInt();

            System.out.println("Ekran Boyutu: ");
            double screenSize=input.nextDouble();


            System.out.println("Ram: ");
            int ram=input.nextInt();

            System.out.println("Ürün ekleme işlemi başarılı!");

            NoteBook.noteBooks.add(new NoteBook(4,price,5,5,protuctName,new Brand(brand),ram,screenSize,storage));
        }
        Products.products.addAll(NoteBook.noteBooks);
        Products.products.addAll(MobilePhone.mobilePhones);

    }
}
