import composite.*;

public static void main(String[] args) {
    Chocolat c = new Chocolat();
    Cafe cafe = new Cafe();
    Muffin muffin = new Muffin();

    Menu menu = new Menu(c,muffin);


    ArrayList<ClassCompo> compo = new ArrayList<>();
    compo.add(menu);
    compo.add(cafe);
    compo.add(cafe);


    Commande commande = new Commande(compo);
    System.out.println(commande.ticket());

}