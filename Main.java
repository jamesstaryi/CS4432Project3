import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program is ready and waiting for user command."); 
        Index index = new Index();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
            while(!input.equals("QUIT")){
                if (input.equals("SELECT count(*)  FROM  A, B WHERE A.RandomV > B.RandomV")) {
                    index.count();
                }
                else if(input.startsWith("SELECT A.Col1, A.Col2, B.Col1, B.Col2  FROM  A, B WHERE A.RandomV = B.RandomV")) {
                    index.hashJoin();
                }
                System.out.println("Program is ready and waiting for user command."); 
                input = scanner.nextLine();
            }
            scanner.close();
    }
}