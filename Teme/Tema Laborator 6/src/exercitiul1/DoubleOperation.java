package exercitiul1;

import exercitiul1.exceptions.MyArithmeticException;
import exercitiul1.exceptions.NullParameterException;
import exercitiul1.exceptions.OverflowException;
import exercitiul1.exceptions.UnderflowException;

import java.util.ArrayList;

public class DoubleOperation implements Calculator {


    @Override
    public Double add(Double a, Double b) throws NullParameterException, OverflowException, UnderflowException{
        if (a == null || b == null) {
            throw new NullParameterException();
        }
        if ((a + b) == Double.POSITIVE_INFINITY) {
            throw new OverflowException();
        }
        if ((a + b) == Double.NEGATIVE_INFINITY) {
            throw new UnderflowException();
        }
        return a + b;
    }

    @Override
    public Double divide(Double a, Double b) throws NullParameterException, MyArithmeticException{
        if (a == null || b == null) {
            throw new NullParameterException();
        }
        if (b == 0) {
            throw new MyArithmeticException();
        }
        return a / b;
    }

    @Override
    public Double average(ArrayList<Double> arrayList) throws NullParameterException, OverflowException, UnderflowException, MyArithmeticException{
        if (arrayList==null) {
            throw new NullParameterException();
        }
        Double avg;
        Double sum=0.0;
        for(Double iterable:arrayList)
        {
            if(iterable==null){
                throw new NullParameterException();
            }
            sum=add(sum,iterable);
        }
        avg=divide(sum, (double) arrayList.size());
        return avg;
    }
}
