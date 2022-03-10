import java.io.FileReader;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean isanimation=true;
        Scanner scanner = new Scanner(System.in);
        //1.关于文件绝对路径的输入
        String fileName = scanner.next();//differeces between next and nextline.
        //2.关于字符串的输入
        String str = scanner.next();
        //3.关于isAnimated的输入
        String booleannnn = scanner.next();
        if (booleannnn.equals("--animation")) {
            isanimation = true;
        }else if(booleannnn.equals("-noanimation")){
            isanimation = false;
        }
        /*up 关于boolean输入*/
        while(str.length()<20){
            str=str+"*";
        }
        if(str.length()>20){
            str=str.substring(0,19);//截取0-19
            str=str+"*";
        }
        /*关于字符串的判断*/
        String rule = new String();
        String[] states=new String[3];
        int number=0,i=0;
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while (sc.hasNextLine()) {
                String str1 = sc.nextLine();//将读取到的存到字符串数组里
                if(!str1.contains("#") && str1.contains("rules"))
                {
                    rule=str1.split("=")[1];
                    number=rule.split("<>").length;
                }
                if(!str1.contains("#") && str1.contains("State")){
                    states[i]=str1.split("=")[1];
                    i++;
                }
            }
        }catch (Exception e) {}
        UniversalTuringMachine a = new UniversalTuringMachine();
        TuringMachine tm = new TuringMachine(number,states[0],states[1],states[2]);
        Move left = MoveClassical.LEFT;
        Move right = MoveClassical.RIGHT;
        //String str = "00001111****0000000*";
        LoadRules addru = new LoadRules(tm, rule, left, right);
        if(isanimation){
            Driver car = new Driver(tm,a,str,left,right,true);
        }else{
            Driver car = new Driver(tm,a,str,left,right,false);
        }
    }
}

