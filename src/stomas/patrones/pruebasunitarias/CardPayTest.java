package stomas.patrones.pruebasunitarias;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CardPayTest extends TestCase {

    private TarjetaDebito _debito;
    private TarjetaCredito _credito;

    public CardPayTest(String name){
        super(name);
    }

    protected void setUp(){
        this._debito = new TarjetaDebito(100);
        this._credito = new TarjetaCredito(50, 100);
    }

    protected void tearDown(){
        this._debito = null;
        this._credito = null;
    }

    public void testPagoCompraDebito(){
        assertTrue(_debito.pagaCompra(50));
    }

    public void testImporteNegativoDebito(){
        assertFalse(_debito.pagaCompra(-50));
    }

    public void testSaldoNegativoDebito(){
        _debito.cuentaAsociada = new Cuenta(-100);
        assertEquals(0, _debito.cuentaAsociada.saldo);
        assertFalse(_debito.pagaCompra(50));
    }

    public void testPagoCompraCredito(){
        assertTrue(_credito.pagaCompra(50));
    }

    public void testCupoExedido(){
        assertFalse(_credito.pagaCompra(100));
    }

    public void testCambioCuotas(){
        _credito.elegirCuotas(3);
        assertEquals(3, _credito.cuotas);
        _credito.elegirCuotas(-3);
        assertEquals(1, _credito.cuotas);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(new TestSuite(CardPayTest.class));
    }
}
