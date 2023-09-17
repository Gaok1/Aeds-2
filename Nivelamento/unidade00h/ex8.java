package unidade00h;

public class ex8 {
    static int recursiva(int x){
        if(x==0){
            return 1;
        }else if(x==1){
            return 2;
        }else{
            return (recursiva(x-1) * recursiva(x-2)) - recursiva(x-1);
        }

    }
    public static void main(String[] args){

        MyIO.println(recursiva(5));
    }
    
}
