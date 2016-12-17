package com.javatpoint.remoting.rmi;

import com.javatpoint.remoting.rmi.Calculation;

/**
 * Created by Asus x556 on 17-Dec-16.
 */
public class CalculationImpl implements Calculation {
    @Override
    public int cube(int number) {
        return (int)Math.pow(number,3);
    }
}
