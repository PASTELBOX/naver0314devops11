import java.util.*;

public class Main {
    static int n = 5, k = 3;
    static int[] a = {1,2,3,4,5};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 첫번째 방법
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    System.out.println(i + " " + j + " " + k);
                }
            }
        }

        System.out.println("-------------");

        //두번째 방법
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                for(int k = 0; k < j; k++){
                    System.out.println(i + " " + j + " " + k);
                }
            }
        }

    }
}