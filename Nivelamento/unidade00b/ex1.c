#include <stdio.h>
#include <stdbool.h>

// encontrar numero no array e retornar true ou false;
bool func(int array[10], int x){

    
    for(int i = 0;i<10;i++){
        if(array[i] == x){
            return true;
        }
    }
    return false;

}



int main(){
    int array[10] = {1,21,3,6,8,10,22,9,30};
    int num;
    scanf("%d", &num);
    if(func(array,num)){
        puts("sim");
    }else{
        puts("nao");
    }




    return 0;
}