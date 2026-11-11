package composite;

public class Menu extends ClassCompo implements Composite{
    Boisson b;
    Encas e;

    public Menu(Boisson b, Encas e){
        this.b = b;
        this.e = e;
    }

    public String ticket(){
        double total =  (b.prix() + e.prix()) * 0.90;

        return "menu (" + b.getName() + " + " + e.getName() + " ) : " + total;
    }

    public double prix() {
        return (b.prix() + e.prix()) * 0.90;
    }
}
