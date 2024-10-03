package model;

public class Nota {
    private double[] notas;
    private double[] pesos;

    public Nota(double[] notas, double[] pesos) {
        if (notas.length != pesos.length) {
            throw new IllegalArgumentException("A quantidade de notas deve ser igual à quantidade de pesos.");
        }
        this.notas = notas;
        this.pesos = pesos;
    }

    public double calcularMedia() {
        double soma = 0, somaPesos = 0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i] * pesos[i];
            somaPesos += pesos[i];
        }
        return soma / somaPesos;
    }

    public double[] getNotas() {
        return notas;
    }

    public double[] getPesos() {
        return pesos;
    }

    public void setNotas(double[] notas, double[] pesos) {
        this.notas = notas;
        this.pesos = pesos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Notas: ");
        for (double nota : notas) {
            sb.append(nota).append(" ");
        }
        sb.append("\nMédia: ").append(calcularMedia());
        return sb.toString();
    }
}
