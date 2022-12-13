import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var size=scanner.nextInt();
        int[] elements = new int[size];
        for(int x=0;x<size;x++){
            elements[x]=scanner.nextInt();
        }
        var numbertocompare=scanner.nextInt();
        int total=0;
        for(int number: elements){
            if(number>numbertocompare){
                total = total + number;
            }
        }
        System.out.print(total);
    }
}