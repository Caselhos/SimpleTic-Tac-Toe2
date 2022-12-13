import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var biggest_element = 0;
        Scanner scanner = new Scanner(System.in);
        var n_Elements= scanner.nextInt();
        for(var x=0;x<n_Elements;x++){
            var element= scanner.nextInt();
            if(element%4==0 && element>=biggest_element){
                biggest_element=element;
            }
        }
        scanner.close();
        System.out.printf("%d",biggest_element);
    }
}