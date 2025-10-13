import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        System.out.print("I love pizza"); // ust print they will be in the same line
        System.out.print("Me too");
        System.out.println("I love pizza"); // with ln they will be in new line
        System.out.println("Me too");
        System.out.println("I love pizza\n"); // even id i dont do println just \n will give in different line to but we
                                              // use both thre will be two sps-ace
        System.out.println("Me too");

        int farzia;
        farzia = 10;
        System.out.println("farzia"); // it will print farzia as string as i added in the "" evenif i put anything
                                      // else instead of farzia it will do the same as we said in top farzia is an int
                                      // an integer a number so it souldnt be in the ""
        System.out.println(farzia); // now it will print 10 as it is not in the ""
        System.out.println("Farzia is :  " + farzia); // : after space will give space


        int ahmadii = 20; // this called initialization we can do eighter inone line or two line like the top
        System.out.println(ahmadii);

        String x = "WAter";
        String y = "Juice";
        String temp; //ne only declare a variable
        //x=y; // now x will be juice as we said x = y
        //y=x; // now y would be water as we said Y=X
        System.out.println("x:  " +x); //Anything in the "" will count as a text and i¡without is calling the variable
        System.out.println("y:  "+y); // See the result to undrastand better
   
   temp= x;
   x=y;
   y=temp;
   
   // Check this later

   Scanner heoo = new Scanner(System.in); // it will give as an error if we do not import the pachage in top
   System.out.println(" Enter your name: ");
   String name= heoo.nextLine();
   System.out.println("how old are you? ");
   int age= heoo.nextInt();
   heoo.nextLine(); // to avoid skipping the next line
   System.out.println(" your fav food?");
   String food = heoo.nextLine();// it will skip this line as it will take the enter from the above line as a input so to avoid this we can add scanner.nextLine(); after int age
   System.out.println("Hello  " + name);
   System.err.println(" you are " + age + "old");
    
// look for % / in java the resut
// how math works


double X;
double Y;
double z;
Scanner hey = new Scanner(System.in);
System.out.println("Enter side x:  ");
X = hey.nextDouble();
System.out.println("Enter side y:  ");
Y = hey.nextDouble();

z= Math.sqrt((X*X)+(Y*Y));
System.out.println(" The hypotenuse is:  " + z);




}

}
