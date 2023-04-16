package constant;

import java.util.HashMap;
import java.util.Map;

public enum OperatorEnum {
    ADD(1, "+"), SUB(2, "-"), MUL(3, "*"), DIV(4, "/");

    private int code;

    private String operator;

    private static final Map<String, OperatorEnum> map;

    static {
        map = new HashMap<>();
        for (OperatorEnum season : values()) {
            map.put(season.operator, season);
        }
    }

    public static OperatorEnum valueOfName(String name) {
        return map.get(name);
    }

    private OperatorEnum(int code, String name) {
        this.code = code;
        this.operator = name;
    }

    public int getCode() {
        return code;
    }

    public String getOperator() {
        return operator;
    }

}
