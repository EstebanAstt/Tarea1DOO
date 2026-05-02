public abstract class Dulce extends Producto {

    public Dulce(int serie){
        super(serie);
    }

    public abstract String comer();
}


class Super8 extends Dulce{
    public Super8 (int serie) {
        super(serie);
    }
    @Override
    public String comer(){
        return "Super8";
    }

    public int getPrecio(){
        return 100;
    }

}

class Snickers extends Dulce{
    public Snickers(int serie) {
        super(serie);
    }
    @Override
    public String comer(){
        return "Super8";
    }

    public int getPrecio(){
        return 100;
    }

}
