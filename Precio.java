public enum Precio {
    COCA(1000),
    SPRITE(1000),
    FANTA(1000),
    SUPER8(500),
    SNICKERS(1100);

    private int valor;

    Precio(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }
}
