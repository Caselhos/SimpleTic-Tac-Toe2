import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var minimum=scanner.nextInt();
        var maximum=scanner.nextInt();
        int total=1;
        for(;minimum<maximum;minimum++){
            total=total*minimum;
        }
        System.out.print(total);
    }
}