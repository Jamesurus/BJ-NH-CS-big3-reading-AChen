import java.util.Scanner;

public class TestBoolean {
    public static void main(String[] args) {
        boolean result;
        Scanner a = new Scanner(System.in);
        String str = a.nextLine();
        String str2 = a.nextLine();
        if(str.equals("fuck")){
            result=true;
        }else{
            result=false;
        }
        System.out.println(result);
        System.out.println(str2);
    }
}
