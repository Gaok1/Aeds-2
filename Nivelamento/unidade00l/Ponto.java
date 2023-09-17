package unidade00l;

public class Ponto {
    private double x;
    private double y;
    private int id;
    private static int NextID = 0;

    Ponto(int id) {

        this.id = id;
        NextID++;
        
    }

    Ponto() {
        this.x = 0;
        this.y = 0;
        id = NextID;
        NextID++;
    }

    Ponto(double x, double y) {
        this.x = x;
        this.y = y;
        id = NextID;
        NextID++;
    }

    void setX(double x) {
        this.x = x;
    }

    void sety(double y) {
        this.y = y;
    }

    void setID(int id){
        this.id = id;
    }

    int getID(){
        return this.id;
    }

    double getx() {
        return x;
    }

    double gety() {
        return y;
    }

    public static int getNextID(){
        return NextID;
    }

    public double getAreaRetangulo(Ponto a){
        Retangulo x = new Retangulo(a.getx(), a.gety());
        return x.getAreaRetangulo();

    }

    public static boolean isTriangulo(Ponto a, Ponto b, Ponto c){
        return false;

    }

    public double dist(Ponto a){
        double soma = this.x + this.y;

        double soma2 = a.getx() + a.gety();
        return soma -soma2;
    }

    public double dist(int a, int b){
        double soma = this.x + this.y;

        double soma2 = a + b;
        return soma -soma2;
    }

    public static double dist(int a, int b, int c, int d){
        double soma = a + b;

        double soma2 = c + d;
        return soma -soma2;
    }
    

}
