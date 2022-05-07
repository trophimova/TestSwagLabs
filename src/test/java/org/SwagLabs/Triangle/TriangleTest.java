package org.SwagLabs.Triangle;

import org.SwagLabs.AuthTest;
import org.SwagLabs.triangle.NegativeSide;
import org.SwagLabs.triangle.NotTriangle;
import org.SwagLabs.triangle.NullSide;
import org.SwagLabs.triangle.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.qameta.allure.*;

@Story("Тестирование расчета площади треугольника")
public class TriangleTest {
    static Logger logger = LoggerFactory.getLogger(AuthTest.class);

    @ParameterizedTest
    @CsvSource({ "3, 4, 5, 6", "28, 23, 16, 183.99983016296508","5, 3, 6, 7.483314773547883"})
    @DisplayName("Проверка расчета площади треугольника")
    void testArea(int a, int b, int c, double area) throws NegativeSide, NullSide, NotTriangle {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(area,triangle.someMethod(a, b, c));

        logger.info("Площадь рассчитана верно");

    }

    @ParameterizedTest
    @CsvSource({ "-9, 20, 5","100, -200, 5","1, 2, -5"})
    @DisplayName("Проверка расчета площади треугольника, если одна из сторон отрицательная")
    void testNegativeSide(int a, int b, int c) throws NegativeSide {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(NegativeSide.class,()-> triangle.someMethod(a, b, c));

        logger.info("Одна из сторон треугольника отрицательная");
    }

    @ParameterizedTest
    @CsvSource({ "0, 20, 5","100, 0, 5","1, 2, 0"})
    @DisplayName("Проверка расчета площади треугольника, если одна из сторон равна 0")
    void testNullSide(int a, int b, int c) throws NullSide {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(NullSide.class,()-> triangle.someMethod(a, b, c));

        logger.info("Одна из сторон треугольника равна 0");

    }

    @ParameterizedTest
    @CsvSource({ "6, 20, 5","100, 51, 5","1, 2, 15"})
    @DisplayName("Проверка расчета площади треугольника, если сумма двух сторон меньше третьей стороны")
    void testNotTriangle(int a, int b, int c) throws NotTriangle {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(NotTriangle.class,()-> triangle.someMethod(a, b, c));

        logger.info("Не треугольник");
    }
}
