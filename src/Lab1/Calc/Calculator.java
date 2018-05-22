package Lab1.Calc;

import java.io.Serializable;

public class Calculator implements Calculable, Serializable {

    private static final long serialVersionUID = 5950169519310163575L;

    @Override
    public double calc() {
        double a = 5.5;
        double b = 7.5;
        return Math.IEEEremainder(a, b);
    }

}
