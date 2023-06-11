package stomas.patrones.pruebasunitarias;

public abstract class TarjetaPago {
    protected int cuotas;

    public TarjetaPago(){
        this.cuotas = 1;
    }

    public boolean pagaCompra(int importe) {
        if(autorizaPago(importe)){
            descontarSaldo(importe / cuotas);
            return true;
        }
        return false;
    }

    public abstract boolean autorizaPago(int importe);

    public abstract void elegirCuotas(int cuotas);
    protected abstract void descontarSaldo(int importe);
}
