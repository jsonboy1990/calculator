package utils;

import constant.OperatorEnum;
import entity.CalEntity;


import java.util.Stack;

public class CalculateUtil {

    private static Stack<String> historyCalResults;
    private static Stack<String> RedoCalResults;

    static {
        historyCalResults=new Stack<>();
        RedoCalResults=new Stack<>();
    }
    public static String redo(){
        if(RedoCalResults.size()>0){
            String redoCalResult = RedoCalResults.pop();
            historyCalResults.push(redoCalResult);
            return redoCalResult;
        }

        return null;
    }

    public static   String undo(){
        if(historyCalResults.size()>0){
            String lastCalResult = historyCalResults.pop();
            RedoCalResults.push(lastCalResult);
            return lastCalResult;
        }

        return null;

    }

    public static   void saveCalResult(String calRes){
        historyCalResults.push(calRes);
    }

    public static  long cal(CalEntity entity){
        OperatorEnum operatorEnum = OperatorEnum.valueOfName(entity.getOperator());
        long res=0;
        switch (operatorEnum){
            case ADD:
                res= add(entity.getFirstNum(),entity.getSecondNum());
                break;
            case SUB:
                res= sub(entity.getFirstNum(),entity.getSecondNum());
                break;
            case MUL:
                res= multiply(entity.getFirstNum(),entity.getSecondNum());
                break;
            case DIV:
                res= div(entity.getFirstNum(),entity.getSecondNum());
                break;
            default:
                break;
        }
        return res;
    }


    private static  int add(int firstNum, int secondNum){
        return  firstNum+secondNum;

    }
    private static  int sub(int firstNum,int secondNum){
        return  firstNum-secondNum;
    }
    private static  long multiply(int firstNum,int secondNum){
            long res=firstNum*secondNum;
            return res;
    }

    private static  int div(int firstNum,int secondNum){
        return  firstNum/secondNum;
    }
}
