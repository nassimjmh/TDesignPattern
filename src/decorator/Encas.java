package decorator;

public class Encas extends ClassCompo implements Composite {
    private double price;
    private String name;

    public Encas(double price, String name){
        this.price = price;
        this.name = name;
    }
    public String ticket(){
        return "- " + this.name + " : " + this.price;
    }
    public double prix(){
        return price;
    }
    public String getName(){
        return this.name;
    }
}
