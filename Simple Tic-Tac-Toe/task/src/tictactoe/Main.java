package tictactoe;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.abs;


public class Main {
    public static void main(String[] args) {
        char[][] state= new char[3][3];
        /*
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        int z=0;int x=0;int y=0;
        while (x!=3){
            state[x][y] = line.charAt(z);
            y++;
            z++;
            if(y==3){
                x++;
                y=0;
            }
        }*/
        for (char[] row: state)
            Arrays.fill(row, ' ');
        draw_board(state);
        int currentplayer=0;
        int[] nextMove = new int[2];
        while(true){
            nextMove=checkinput(state);
            if (currentplayer==0){
                state[nextMove[0]][nextMove[1]]='X';
                draw_board(state);
                gamestatechecks(state);
                currentplayer=1;
            }else {
                state[nextMove[0]][nextMove[1]]='O';
                draw_board(state);
                gamestatechecks(state);
                currentplayer=0;
            }

        }



        

    }
    public static int checknumberPecas(char[][] state,char cell){
        int soma=0;
        for(int y=0;y<state.length;y++){
            for(int x=0;x<state[y].length;x++){
                if(state[x][y]== cell){
                    soma++;
                }
            }
        }
        return soma;
    }
    public static int checkcolumn(char[][] state,char cell){
        int y=0;int soma=0;
        for(int i = 0; i < 3; i++){
            if(state[i][y] != cell){
                y++;
                i=-1;
                if(y>=3)break;

            }
            if(i==2) {
                soma++;
                y++;
                if(y>=3)break;
                i=-1;

            }
        }
        return soma;
    }
    public static int checkrow(char[][] state,char cell){
        int i=0;int soma=0;
        for(int y = 0; y < 3; y++){
            if(state[i][y] != cell){
                i++;
                if(i>=3)break;
                y=-1;
            }
            if(y==2) {
                soma++;
                i++;
                if(i>=3)break;
                y=-1;

            }
        }
        return soma;
    }
    public static int checkdiag(char[][] state,char cell){
        int soma=0;
        for(int y = 0; y < 3; y++){
            if(state[y][y] != cell)
                return soma;
        }
        return ++soma;
    }
    public static int checkantidiag(char[][] state,char cell){
        int soma=0;
        for(int y = 0; y < 3; y++){
            if(state[y][2-y] != cell)
                return soma;
        }
        return ++soma;
    }
    public static int check_draw_or_notfinished(char[][] state){
        for(int y=0;y<state.length;y++){
            for(int x=0;x<state[y].length;x++){
                if(state[x][y]== ' '){
                   return 0;
                }
            }
        }
        return 1;
    }
    public static void draw_board(char[][] state){
        System.out.println("---------");
        for(int y=0;y<state.length;y++){
            System.out.print("| ");
            for(int x=0;x<state[y].length;x++){
                System.out.print(state[y][x]);
                System.out.print(" ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }
    public static int[] checkinput(char[][] state){
        while(true) {
            Scanner userInput = new Scanner(System.in);
            int[] nextMove = new int[2];
            if (userInput.hasNextInt()) {
                nextMove[0] = userInput.nextInt();
                if (userInput.hasNextInt()) {
                    nextMove[1] = userInput.nextInt();
                } else {
                    System.out.println("You should enter numbers!");
                    Arrays.fill(nextMove, 0);
                    continue;
                }
            } else {
                System.out.println("You should enter numbers!");
                Arrays.fill(nextMove, 0);
                continue;
            }
            if (1>nextMove[0] || nextMove[0]>3 || 1>nextMove[1] || nextMove[1]>3){
                System.out.println("Coordinates should be from 1 to 3");
                continue;
            }
            nextMove[0]=nextMove[0]-1;
            nextMove[1]=nextMove[1]-1;
            if (state[nextMove[0]][nextMove[1]]!=' '){
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            return nextMove;
        }
    }
    public static void gamestatechecks(char[][] state){
        int testerowX =checkrow(state,'X');
        int testecolX =checkcolumn(state,'X');
        int testediagX =checkdiag(state,'X');
        int testeantidiagX =checkantidiag(state,'X');

        int testerowO =checkrow(state,'O');
        int testecolO =checkcolumn(state,'O');
        int testediagO =checkdiag(state,'O');
        int testeantidiagO =checkantidiag(state,'O');

        int numPecasX =checknumberPecas(state,'X');
        int numPecas0 =checknumberPecas(state,'O');

        if(abs(numPecasX-numPecas0) >=2){
            System.out.println("Impossible");
            System.exit(0);
        }
        if(testerowX + testecolX + testediagX + testeantidiagX!=0){
            if(testerowO + testecolO + testediagO + testeantidiagO!=0){
                System.out.println("Impossible");
                System.exit(0);
            }
        }
        if(testerowX + testecolX + testediagX + testeantidiagX + testerowO +testecolO + testediagO + testeantidiagO==0){
            int teste_draw_or_notfinished= check_draw_or_notfinished(state);
            if(teste_draw_or_notfinished==0){

            }
            else {
                System.out.println("Draw");
                System.exit(0);
            }
        }
        if(testerowX + testecolX + testediagX + testeantidiagX!=0){
            System.out.println("X wins");
            System.exit(0);
        }
        if(testerowO + testecolO + testediagO + testeantidiagO!=0){
            System.out.println("O wins");
            System.exit(0);
        }

    }
}
