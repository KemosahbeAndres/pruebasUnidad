package stomas.patrones.pruebasunitarias;

public class TarjetaDebito extends TarjetaPago{
    protected Cuenta cuentaAsociada;

    public TarjetaDebito(int saldo){
        super();
        cuentaAsociada = new Cuenta(saldo);
    }
    @Override
    public boolean autorizaPago(int importe) {
        return cuentaAsociada.saldo >= importe;
    }

    @Override
    public void elegirCuotas(int cuotas) {
        this.cuotas = 1;
    }

    @Override
    protected void descontarSaldo(int importe) {
        cuentaAsociada.saldo -= importe;
    }
}
