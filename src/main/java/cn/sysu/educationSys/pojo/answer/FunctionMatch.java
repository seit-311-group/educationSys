package cn.sysu.educationSys.pojo.answer;

public class FunctionMatch {
    private String function1;

    private String function2;

    public String getFunction1() {
        return function1;
    }

    public void setFunction1(String function1) {
        this.function1 = function1;
    }

    public String getFunction2() {
        return function2;
    }

    public void setFunction2(String function2) {
        this.function2 = function2;
    }

    @Override
    public String toString() {
        return "FunctionMatch{" +
                "function1='" + function1 + '\'' +
                ", function2='" + function2 + '\'' +
                '}';
    }
}
