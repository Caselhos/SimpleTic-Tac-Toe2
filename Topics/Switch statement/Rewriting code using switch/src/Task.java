// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) {
    int var1 = 100;
    int var2 = 0;
    switch (var1) {
      case 100:
        var2 = var1;
        System.out.println(var2);
      case 200:
        var2 += var1 / 4;
        System.out.println(var2);

        break;
      case 300:
        var2 += var1 / 10;
        System.out.println(var2);

        break;
    }
  }
}
