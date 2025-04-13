public class Auto {
    private String marca;
    private int anio;

    public Auto(String marca, int anio) {
        this.marca = marca;
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double calcularMontoMatricula() {
        int anioActual = 2025;
        int diferencia = anioActual - this.anio;

        if (diferencia < 0) {
            return 0;
        }
        return 50 + (diferencia * 50);
    }
    @Override
    public String toString() {
        return "\n---Auto---\n"+
                "Marca: "+marca+
                "\t Año: "+anio +
                "\t Matrícula: $"+calcularMontoMatricula();
    }
}
