package stomas.patrones.pruebasunitarias;

public class TarjetaCredito extends TarjetaPago{

    protected int cupo;
    protected int deuda;

    public TarjetaCredito(int deuda, int limite){
        super();
        this.cupo = limite;
        this.deuda = deuda;
    }
    @Override
    public boolean autorizaPago(int importe) {
        return deuda + importe <= cupo;
    }

    @Override
    public void elegirCuotas(int cuotas) {
        if(cuotas > 0){
            this.cuotas = cuotas;
        }
    }

    @Override
    protected void descontarSaldo(int importe) {
        deuda += importe;
    }
}
