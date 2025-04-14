import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana{
    private JPanel principal;
    private JTextArea txtCodigo;
    private JButton btnComprobar;
    private JTextArea txtPila;

    public Ventana() {
        btnComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pila p = new Pila();
                    String codigo = txtCodigo.getText();
                    boolean error = false;
                    txtPila.setText("");
                    for (int i = 0; i < codigo.length(); i++) {
                        char c = codigo.charAt(i);

                        if (c == '(' || c == '{' || c == '[') {
                            p.insertar(String.valueOf(c));
                            JOptionPane.showMessageDialog(null, "Se insertó: " + c);
                        } else if (c == ')' || c == '}' || c == ']') {
                            if (p.esVacia()) {
                                error = true;
                                break;
                            }

                            char salida = p.extraer().charAt(0);
                            JOptionPane.showMessageDialog(null, "Se extrajo: " + salida);

                            if (!coincide(salida, c)) {
                                error = true;
                                break;
                            }
                        }

                        txtPila.setText(p.toString());
                    }

                    if (!error && p.esVacia()) {
                        JOptionPane.showMessageDialog(null, "Código correcto");
                    } else {
                        JOptionPane.showMessageDialog(null, "Código incorrecto");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
    }

    private boolean coincide(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
                (apertura == '[' && cierre == ']') ||
                (apertura == '{' && cierre == '}');
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Verificador de Código");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

