import java.util.Stack;

public class Pila {
    private Stack<String> coleccion;
    private static final int LIMITE = 10; // Límite de 10 elementos

    public Pila() {
        coleccion = new Stack<String>();
    }

    public void insertar(String dato) {
        if (coleccion.size() >= LIMITE) {
            throw new IllegalStateException("¡Error! La pila ya tiene 10 elementos. Porfavor elimina elementos para agregar otros");
        }
        coleccion.push(dato);
    }

    public String extraer() throws Exception {
        if (coleccion.isEmpty())
            throw new Exception("Error al depilar, la pila esta vacia");
        return coleccion.pop();
    }

    public String cima() {
        return coleccion.peek();
    }

    @Override
    public String toString() {
        StringBuilder lista = new StringBuilder();
        for (int i = coleccion.size() - 1; i >= 0; i--) {
            lista.append(coleccion.get(i) + "\n");
        }
        return lista.toString();
    }
}