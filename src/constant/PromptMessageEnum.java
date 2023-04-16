
package constant;
public enum PromptMessageEnum {
    START_MSG(0, "计算器开始运行，请输入合法计算表达式(1+1)或者R(重算),U(撤销)："),

    UNDO_FAIL_MSG(1,"没有撤销的计算数据,无法继续撤销"),

    UNDO_SUCCESS_MSG(2,"撤销成功，此次撤销的计算结果:%s"),

    RODO_FAIL_MSG(3,"恢复失败，没有撤销的计算数据，无法恢复"),

    RODO_SUCCESS_MSG(4,"恢复成功，恢复的计算结果为:%s"),

    ILLEGAL_INPUT(5,"计算表达式:%s,非法,只允许包含数字和+-*/操作符，请重新输入"),

    CAL_SUCCESS(6,"计算成功，此次计算结果为:%s");


    private final int code;
    private final String msg;

    private PromptMessageEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return  this.msg;
    }
}
