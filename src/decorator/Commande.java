package decorator;

import java.util.ArrayList;

public class Commande implements Composite {
    static ArrayList<ClassCompo> compo;

    public Commande(ArrayList<ClassCompo> compo){
        this.compo = compo;
    }

    public String ticket() {
        double total = 0;
        String s = new String();
        for (ClassCompo objets : compo){
            s+= objets.ticket() + "\n";
            total+=objets.prix();
        }
        return s + "Total : " + total;
    }
    public double prix() {
        return 0;
    }
}
