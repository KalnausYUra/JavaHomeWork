package com.pb.kalnaus.hw10;

public class Main {



    public static void main(String[] args) throws ArraySizeExceededException {

        NumBox<Float> numberFloat = new NumBox<>(6);

        numberFloat.add(24.5f);
        numberFloat.add(34.2f);
        numberFloat.add(3.5f);
        numberFloat.add(234.7f);
        numberFloat.add(500.2f);

        System.out.println( "Float_get() = " +numberFloat.get(1));
        System.out.println( "Float_length() = " +numberFloat.length());
        System.out.println( "Float_average() = " +numberFloat.average());
        System.out.println( "Float_sum() = " +numberFloat.sum());
        System.out.println( "Float_max() = " +numberFloat.max());




        NumBox<Integer> numberInteger = new NumBox<>(8);

        numberInteger.add(45);
        numberInteger.add(600);
        numberInteger.add(20);
        numberInteger.add(15);
        numberInteger.add(95);
        numberInteger.add(5);
        numberInteger.add(-100);
        numberInteger.add(-700);

       // numberInteger.add(-700); //ArraySizeExceededException: Ошибка, превышен допустимый размер массива!!!
        System.out.println( "Integer_get() = " +numberInteger.get(4));

        //-----ArraySizeExceededException: Ошибка, указан неверный элемент массива!!!
        // System.out.println( "Integer_get() = " +numberInteger.get(12));
        System.out.println( "Integer_length() = " +numberInteger.length());
        System.out.println( "Integer_average() = " +numberInteger.average());
        System.out.println( "Integer_sum() = " +numberInteger.sum());
        System.out.println( "Integer_max() = " +numberInteger.max());

    }

}
