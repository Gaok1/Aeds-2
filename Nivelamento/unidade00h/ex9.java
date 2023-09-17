package unidade00h;

public class ex9 {
    static int func(int x){
        if(x == 0){
            return 1;
        } else {
            return func(x - 1) * func(x - 1);
        }
    }

    public static void main(String[] args){
        MyIO.println(func(3));
    }
}
