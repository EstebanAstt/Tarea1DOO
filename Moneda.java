abstract public class Moneda {
    public Moneda(){
    }

    public Moneda getSerie(){
        return this;
    }
    public abstract int getValor();
}