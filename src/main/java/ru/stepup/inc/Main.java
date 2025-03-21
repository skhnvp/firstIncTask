package ru.stepup.inc;

/*
Создайте класс Дробь (Fraction) со следующими особенностями:

Имеет числитель (numerator): целое число
Имеет знаменатель (denominator): целое число
Дробь может быть создана с указанием числителя и знаменателя
Объекты дробей не могут изменять свое состояние
Для числителя задать отрицательное значение можно,
в этом случае вся дробь считается отрицательной
Для знаменателя отрицательное значение недопустимо
Может вернуть строковое представление вида “числитель/знаменатель” (toString)
Может выполнять операции сложения, вычитания с другой Дробью или целым числом.
Результатом операции должна быть новая Дробь
Затем необходимо выполнить следующие задачи:

Создать несколько экземпляров дробей
Посчитать f1.sum(f2).sum(f3).minus(5),
где f1 это одна треть, f2 две пятых, а f3 это семь восьмых
*/

public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 5);
        Fraction f3 = new Fraction(7, 8);

        System.out.println("Созданы дроби: \n" + f1 + "\n" + f2 + "\n" + f3);

        System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
        System.out.println(f1.sum(f2) + " + " + f3 + " = " + f1.sum(f2).sum(f3));

        System.out.println(f1.sum(f2).sum(f3) + " - 5 " + " = " + f1.sum(f2).sum(f3).minus(5));
    }
}