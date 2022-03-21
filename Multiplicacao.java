package negocio;

public class Multiplicacao extends Calculo{

    public Multiplicacao(float valor1, float valor2) {
        super(valor1, valor2);
    }
    
    @Override
    public void calcular() {
        resultado = valor1 * valor2;
    }
    
}
