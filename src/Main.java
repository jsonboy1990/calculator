import com.sun.xml.internal.ws.util.StringUtils;
import constant.Constants;
import constant.OperatorEnum;
import constant.PromptMessageEnum;
import entity.CalEntity;
import utils.CalculateUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println(PromptMessageEnum.START_MSG.getMsg());
            String exprssionStr= input.nextLine();
            if(Constants.REDO.equals(exprssionStr)){
                String redoResult = CalculateUtil.redo();
                if(null==redoResult){
                    System.out.println(PromptMessageEnum.RODO_FAIL_MSG.getMsg());
                }
                else {
                    System.out.printf(PromptMessageEnum.RODO_SUCCESS_MSG.getMsg(),redoResult);
                }
            }
            else if(Constants.UODO.equals(exprssionStr)){
                String undoResult = CalculateUtil.undo();
                if(null==undoResult){
                    System.out.println(PromptMessageEnum.UNDO_FAIL_MSG.getMsg());
                }
                else {
                    System.out.printf(PromptMessageEnum.UNDO_SUCCESS_MSG.getMsg(),undoResult);
                }
            }
            else {
                CalEntity calEntity = getCalEntity(exprssionStr);
                if(calEntity==null){
                    continue;
                }
                long res = CalculateUtil.cal(calEntity);
                String resutl=String.format("%s=%s",exprssionStr,res);
                CalculateUtil.saveCalResult(resutl);
                System.out.printf(PromptMessageEnum.CAL_SUCCESS.getMsg(),resutl);
            }
           System.out.printf("\n");
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
                      System.out.printf(PromptMessageEnum.ILLEGAL_INPUT.getMsg(),exprssionStr);
                      return null;
                  }
              }
           }
       }
        System.out.printf(PromptMessageEnum.ILLEGAL_INPUT.getMsg(),exprssionStr);
        return null;
    }
}