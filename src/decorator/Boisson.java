package decorator;

public class Boisson extends ClassCompo implements Composite {
    private double price;
    private String name;

    public Boisson(double price, String name){
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
