package exercitiul1;

import exercitiul1.exceptions.NullParameterException;
import exercitiul1.exceptions.OverflowException;
import exercitiul1.exceptions.UnderflowException;

import java.util.ArrayList;

public interface Calculator {
    Double add(Double a, Double b) throws NullParameterException, OverflowException, UnderflowException;
    Double divide(Double a, Double b);
    Double average(ArrayList<Double> arrayList);
}
