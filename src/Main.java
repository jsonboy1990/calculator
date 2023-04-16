import com.sun.xml.internal.ws.util.StringUtils;
import constant.Constants;
import constant.OperatorEnum;
import entity.CalEntity;
import utils.CalculateUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("计算器开始运行，请输入计算表达式或者R(重算),U(撤销)：");
            String exprssionStr= input.nextLine();
            if(Constants.REDO.equals(exprssionStr)){
                String redoResult = CalculateUtil.redo();
                if(null==redoResult){
                    System.err.println("没有撤销的计算数据，无法重算");
                }
                else {
                    System.out.println("重算结果为："+redoResult);
                }
            }
            else if(Constants.UODO.equals(exprssionStr)){
                String undoResult = CalculateUtil.undo();
                if(null==undoResult){
                    System.err.println("没有历史计算数据，无法撤销");
                }
                else {
                    System.out.println("撤销此次计算结果："+undoResult);
                }
            }
            else {
                CalEntity calEntity = getCalEntity(exprssionStr);
                if(calEntity==null){
                    return;
                }
                long res = CalculateUtil.cal(calEntity);
                String resutl=String.format("%s=%s",exprssionStr,res);
                CalculateUtil.saveCalResult(resutl);
                System.out.println("此次计算结果："+resutl);
            }
        }
    }

    public static CalEntity getCalEntity(String exprssionStr){
       for(int i=0;i<exprssionStr.length();i++){
           char c = exprssionStr.charAt(i);
           if(c=='-'&& i==0){
               continue;
           }

          else if(c>='0'&&c<='9'){
               continue;
           }
           else {
               String s = String.valueOf(c);
               System.out.println("operate:"+s);
               OperatorEnum operatorEnum = OperatorEnum.valueOfName(s);
               if(operatorEnum!=null){
                  String firstNumStr=exprssionStr.substring(0,i);
                  String secondNumStr=exprssionStr.substring(i+1,exprssionStr.length());
                  try{
                      int firstNum=Integer.valueOf(firstNumStr);
                      int secondNum=Integer.valueOf(secondNumStr);
                      return new CalEntity(firstNum,secondNum,s);
                  }
                  catch (Exception ex){
                      System.err.println(exprssionStr+"计算表达式非法，请重新输入");
                      return null;
                  }
              }
           }
       }
       System.err.println(exprssionStr+"没有包含+-*/运算符中的一个，请重新输入");
        return null;
    }
}