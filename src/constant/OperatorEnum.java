package constant;

import java.util.HashMap;
import java.util.Map;

public enum OperatorEnum {
    ADD(1, "+"), SUB(2, "-"), MUL(3, "*"), DIV(4, "/");

    private int code;

    private String operator;

    private static final Map<String, OperatorEnum> MAP = new HashMap<>();

    static {
        for (OperatorEnum season : values()) {
            MAP.put(season.operator, season);
        }
    }

    public static OperatorEnum valueOfName(String name) {

        return MAP.get(name);
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
