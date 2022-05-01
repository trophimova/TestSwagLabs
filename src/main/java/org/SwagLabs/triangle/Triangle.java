package org.SwagLabs.triangle;

import org.SwagLabs.triangle.NegativeSide;
import org.SwagLabs.triangle.NotTriangle;
import org.SwagLabs.triangle.NullSide;

public class Triangle {

    public double someMethod(int a, int b, int c) throws NegativeSide, NullSide, NotTriangle {

        if(a<0 || b<0 || c<0) throw new NegativeSide("Стороны должны быть больше 0");
        if( a==0 || b==0 || c==0) throw new NullSide("Стороны не могут равняться 0");
        if( a + b < c || a + c < b || b + c < a) throw new NotTriangle("Это не треугольник");

        double s = ( a + b + c ) * 0.5;
        double area = Math.sqrt(s*(s - a)*(s - b)*(s - c));
        return area;
    }
}
