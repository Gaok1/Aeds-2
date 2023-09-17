package unidade00l;

public class Retangulo {
    private double base;
    private double altura;

    public Retangulo() {
        this.base = 0;
        this.altura = 0;
    }

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getArea() {
        return base * altura;
    }

    public double getPerimetro() {
        return 2 * (base + altura);
    }

    public double getAreaRetangulo(){
        return base*altura;
    }

    public double getDiagonal() {
        return Math.sqrt(base * base + altura * altura);
    } 

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}
