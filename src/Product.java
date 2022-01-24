import java.util.Calendar;

public class Product {
    String name;
    String desc;
    String ID;
    double cost;

    public Product(){
    }

    public Product(String Name, String Desc, String id, double Cost){
        this.name = Name;
        this.desc = Desc;
        this.ID = id;
        this.cost = Cost;
    }
}
