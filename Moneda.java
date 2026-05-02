abstract class Moneda{
    public Moneda(){
    }

    public Moneda getSerie(){
        return this;
    }
    public abstract int getValor();
}

interface Comparable<Moneda> {
    abstract int compareTo(Moneda m);
}

class Moneda1500 extends Moneda {
    public Moneda1500(){
        super();
    }

    @Override
    public int getValor(){
        return 1500;
    }

    public String toString(){
        return getValor() + " " + getSerie().hashCode();
    }
}

class Moneda1000 extends Moneda {
    public Moneda1000(){
        super();
    }

    @Override
    public int getValor(){
        return 1000;
    }

    public String toString(){
        return getValor() + " " + getSerie().hashCode();
    }
}

class Moneda500 extends Moneda {
    public Moneda500(){
        super();
    }

    @Override
    public int getValor(){
        return 500;
    }

    public String toString(){
        return getValor() + " " + getSerie().hashCode();
    }
}

class Moneda100 extends Moneda {
    public Moneda100(){
        super();
    }

    @Override
    public int getValor(){
        return 100;
    }

    public String toString(){
        return getValor() + " " + getSerie().hashCode();
    }
}