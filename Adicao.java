package negocio;

public class Adicao extends Calculo{

    public Adicao(float valor1, float valor2) {
        super(valor1, valor2);
    }
    
    @Override
    public void calcular() {
        resultado = valor1 + valor2;
    }
    
}
