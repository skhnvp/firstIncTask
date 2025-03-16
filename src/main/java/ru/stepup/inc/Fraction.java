package ru.stepup.inc;

import java.util.ArrayList;
import java.util.List;

public class Fraction {
    private final int numerator;
    private final int denominator;


    public Fraction(int numerator, int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("Для знаменателя отрицательное значение недопустимо");
        }
        if (numerator == 0) {
            this.numerator = 0;
            this.denominator = 0;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        System.out.println("Конструктором создана новая дробь: " + this);
    }

    public Fraction sum(Fraction f) {
        return sumFractions(f);
    }

    public Fraction sum(int n) {
        return sumInt(n);
    }

    public Fraction minus(Fraction f) {
        return minusFractions(f);
    }

    public Fraction minus(int n) {
        return minusInt(n);
    }

    private Fraction sumFractions(Fraction f) {
        if (this.denominator == f.denominator) {
            System.out.println("Знаменатели равны");
            return new Fraction(this.numerator + f.numerator, this.denominator);
        }

        List<Integer> fractionsList = toCommonDenominator(f);

        return reductionOfValue(fractionsList.get(1) + fractionsList.get(2), fractionsList.get(0));
    }

    private Fraction sumInt(int n) {
        Fraction f = new Fraction(denominator * n, denominator);
        return sumFractions(f);
    }

    private Fraction minusFractions(Fraction f) {
        if (this.denominator == f.denominator) {
            System.out.println("Знаменатели равны");
            return new Fraction(this.numerator - f.numerator, this.denominator);
        }

        List<Integer> fractionsList = toCommonDenominator(f);

        return reductionOfValue(fractionsList.get(1) - fractionsList.get(2), fractionsList.get(0));
    }

    private Fraction minusInt(int n) {
        Fraction f = new Fraction(denominator * n, denominator);
        return minusFractions(f);
    }

    private Fraction reductionOfValue(int num, int denom){
        boolean isNegative = false;

        if (num < 0) {
            isNegative = true;
            num *= -1;
        }

        if (denom % num == 0) { // если 5/15 = 1/3
            if (isNegative) {
                return new Fraction(-1, denom / num);
            }
            return new Fraction(1, denom / num);
        }

        if (num % denom == 0) { // если 15/5 = 3/1
            return new Fraction(num / denom, 1);
        }

        return new Fraction(num, denom);
    }

    private List<Integer> toCommonDenominator(Fraction f) {
        List<Integer> returnList = new ArrayList<>();

        returnList.add( Math.abs(this.denominator * f.denominator) / euclideAlg(this.denominator, f.denominator));
        returnList.add( this.numerator * (returnList.get(0) / this.denominator));
        returnList.add( f.numerator * (returnList.get(0) / f.denominator));

        System.out.println(
                "\nПервый числитель: " + returnList.get(1)
                        + "\nВторой числитель: " + returnList.get(2)
                        + "\nЗнаменатели не равны. Наименьшее общее кратное: " + returnList.get(0)
        );
        return returnList;
    }

    private int euclideAlg(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
