package proxy;

public class Proxy implements Provider {
    Provider p;
    private int x = 0;

    public Proxy(P1 p1){
        p=p1;
    }


    @Override
    public void service1() {
        x++;
        p.service1();
    }

    @Override
    public void service2() {
        x++;
        p.service2();
    }
}

