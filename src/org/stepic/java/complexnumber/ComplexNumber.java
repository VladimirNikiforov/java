package org.stepic.java.complexnumber;

/*
* Дан класс ComplexNumber.
* Переопределите в нем методы equals() и hashCode() так, чтобы equals() сравнивал экземпляры ComplexNumber
* по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().

Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет

Пример

ComplexNumber a = new ComplexNumber(1, 1);
ComplexNumber b = new ComplexNumber(1, 1);
// a.equals(b) must return true
// a.hashCode() must be equal to b.hashCode()

Подсказка 1. Поищите в классе java.lang.Double статический метод, который поможет в решении задачи.
Подсказка 2. Если задача никак не решается, можно позвать на помощь среду разработки, которая умеет
сама генерировать equals() и hashCode().
Если вы воспользовались помощью IDE, то разберитесь, что было сгенерировано и почему оно выглядит именно так.
Когда вас на собеседовании попросят на бумажке реализовать equals() и hashCode()
для какого-нибудь простого класса, то среда разработки помочь не сможет.

http://info.javarush.ru/translation/2014/08/15/%D0%A0%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-%D1%81-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4%D0%B0%D0%BC%D0%B8-hashCode-%D0%B8-equals-%D0%B2-%D1%8F%D0%B7%D1%8B%D0%BA%D0%B5-Java-.html
* */

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public static void main(String[] args){
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);
        // a.equals(b) must return true
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(b.hashCode()==a.hashCode());
        // a.hashCode() must be equal to b.hashCode()
    }

    @Override
    public boolean equals (Object o){//my
        if(o == null) return false;
        if(o == this) return true;
        if(getClass() != o.getClass()) return false;
        ComplexNumber cn = (ComplexNumber) o;
        return ((Double) this.getIm()).equals(((ComplexNumber) cn).getIm()) & ((Double) this.getRe()).equals(((ComplexNumber) cn).getRe());
    }
    @Override
    public int hashCode(){//my
        //return ((Double) this.getIm()).hashCode()+((Double) this.getRe()).hashCode();
        return (""+re+im).hashCode();

        /**
         * ---------- alternate
         final int PRIME = 31;
         int result = 1;
         result = PRIME * result + (int)Double.doubleToLongBits(getRe()) + (int)Double.doubleToLongBits(getIm());
         return result;
         ------------- alternate
         return (""+re+im).hashCode();
         ------------- alternate
         return Double.valueOf( Math.atan(im/re) ).hashCode();

         */

    }

    /*
    @Override
    public boolean equals(Object o) {/// generated by IDE!
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplexNumber that = (ComplexNumber) o;

        if (Double.compare(that.re, re) != 0) return false;
        return Double.compare(that.im, im) == 0;
    }

    @Override
    public int hashCode() {/// generated by IDE!
        int result;
        long temp;
        temp = Double.doubleToLongBits(re);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(im);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    */
}
