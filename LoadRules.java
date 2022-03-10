import java.io.FileReader;
import java.util.Scanner;

public class LoadRules {
    private TuringMachine turingmachine;
    private String file_path;
    private Move left;
    private Move right;
    private int a;

    /*1.rule-read from description file
    * number-number of set of rules
    * */
    public LoadRules(TuringMachine turingmachine, String rule, Move left, Move right){
        int number = rule.split("<>").length;
        String[] str1 = rule.split("<>");
        for(int count=0;count<number;count++){
            String strC1 = str1[count].split(",")[0];
            char c2 = str1[count].split(",")[1].charAt(0);
            String strC3 = str1[count].split(",")[2];
            char c4 = str1[count].split(",")[3].charAt(0);
            if(str1[count].split(",")[4].equals("LEFT")){
                turingmachine.addRule(strC1,c2,strC3,c4,left);
            }else{
                turingmachine.addRule(strC1,c2,strC3,c4,right);
            }
        }
    }
}
