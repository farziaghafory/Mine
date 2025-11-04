public class hey {
public static void main(String[] args) {
   /*int[] farzia = {1,4,56, 34, 56, 76};
     farzia[0] = 1;
    farzia[1] = 2;
    farzia[2] = 3;

    for( int i=0; i<farzia.length; i++){ // 
    System.out.println(farzia[i]);*/
    int[] a = {1, 2, 3, 4, 6 , 7, 8};
int b = 6;
int[] nuevo = new int[b];
for (int i = 0; i < b; i++){
nuevo[i] = a[i];
System.out.println(nuevo[i]);
}
}

}

/*int[] a = Arrays.copyOfRange(original, 0, 3); // copies elements 0 to 2
int[] b = Arrays.copyOfRange(original, 3, original.length); // copies elements 3 to 5*/
/*arrayscopyof(a,3)// this will get from 0 to 3


int[] b = a.clone()*/

/*String[] nombres = {"Ana", "Luis", "Carlos"};
String[] copia = copiarConClone(nombres);

System.out.println(Arrays.toString(copia)); */



