package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import negocio.Adicao;
import negocio.Divisao;
import negocio.Multiplicacao;
import negocio.Subtracao;

public class FormCalculadora {
    private JFrame form;
    private JLabel lblValor1, lblValor2, lblResultado;
    private JTextField txtValor1, txtValor2;
    private JButton btnSomar, btnSubtrair, btnMultiplicar, btnDividir;
    
    public FormCalculadora() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        form = new JFrame("JCalculadora");
        form.setBounds(500, 250, 500, 300);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLayout(null);
        Container painelDeConteudo = form.getContentPane();
        
        lblValor1 = new JLabel("Valor 1:");
        lblValor1.setBounds(50, 30, 60, 30);
        painelDeConteudo.add(lblValor1);
        
        txtValor1 = new JTextField();
        txtValor1.setBounds(120, 30, 60, 30);
        txtValor1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { 
                if (!validarPreenchimento(e))
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                limparResultado();
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });
        painelDeConteudo.add(txtValor1);
        
        lblValor2 = new JLabel("Valor 2:");
        lblValor2.setBounds(50, 80, 60, 30);
        painelDeConteudo.add(lblValor2);
        
        txtValor2 = new JTextField();
        txtValor2.setBounds(120, 80, 60, 30);
        txtValor2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!validarPreenchimento(e))
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                limparResultado();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        painelDeConteudo.add(txtValor2);
        
        lblResultado = new JLabelFatec("Resultado:");
        lblResultado.setBounds(160, 160, 200, 30);
        painelDeConteudo.add(lblResultado);

        btnSomar = new JButton("+");
        btnSomar.setBounds(280, 30, 60, 30);
        btnSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarPreenchimento()){
                    float v1 = Float.parseFloat(txtValor1.getText());
                    float v2 = Float.parseFloat(txtValor2.getText());

                    Adicao objCalculadora = new Adicao(v1, v2);
                    objCalculadora.calcular();
                    lblResultado.setText(String.format("Resultado: %.2f", 
                            objCalculadora.getResultado()));
                }
            }
        });
        painelDeConteudo.add(btnSomar);

        btnSubtrair = new JButton("-");
        btnSubtrair.setBounds(360, 30, 60, 30);
        btnSubtrair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarPreenchimento()){
                    float v1 = Float.parseFloat(txtValor1.getText());
                    float v2 = Float.parseFloat(txtValor2.getText());

                    Subtracao objCalculadora = new Subtracao(v1, v2);
                    objCalculadora.calcular();
                    lblResultado.setText(String.format("Resultado: %.2f", 
                            objCalculadora.getResultado()));
                }
            }
        });
        painelDeConteudo.add(btnSubtrair);
        
        btnMultiplicar = new JButton("x");
        btnMultiplicar.setBounds(280, 80, 60, 30);
        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarPreenchimento()){
                    float v1 = Float.parseFloat(txtValor1.getText());
                    float v2 = Float.parseFloat(txtValor2.getText());

                    Multiplicacao objCalculadora = new Multiplicacao(v1, v2);
                    objCalculadora.calcular();
                    lblResultado.setText(String.format("Resultado: %.2f", 
                            objCalculadora.getResultado()));
                }
            }
        });
        painelDeConteudo.add(btnMultiplicar);

        btnDividir = new JButton("/");
        btnDividir.setBounds(360, 80, 60, 30);
        btnDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarPreenchimento()){
                    float v1 = Float.parseFloat(txtValor1.getText());
                    float v2 = Float.parseFloat(txtValor2.getText());

                    Divisao objCalculadora = new Divisao(v1, v2);
                    objCalculadora.calcular();
                    lblResultado.setText(String.format("Resultado: %.2f", 
                            objCalculadora.getResultado()));
                }
            }
        });
        painelDeConteudo.add(btnDividir);
        
        form.setVisible(true);
    }
    
    private boolean validarPreenchimento(){
        return (txtValor1.getText().length() > 0 && txtValor2.getText().length() > 0);
    }
    
    private boolean validarPreenchimento(KeyEvent e){
        return Character.isDigit(e.getKeyChar());
    }

    private void limparResultado(){
        lblResultado.setText("Resultado:");
    }
    
}
