package com.pb.kalnaus.hw10;


import com.sun.org.apache.bcel.internal.generic.DLOAD;

public class NumBox<T extends Number > {

    private final T[] number;
    private int index =0;


    public NumBox(int size) {
        number = (T[]) new Number[size];
    }


   public void add(T num) throws ArraySizeExceededException {
        if(index == (number.length)) {
            throw new ArraySizeExceededException("Ошибка, превышен допустимый размер массива!!!");
        } else {
            this.number[index] = num;
            index++;
        }
    }

    public T get(int index) throws ArraySizeExceededException {
        if(this.index < index )
        {
            throw new ArraySizeExceededException("Ошибка, указан неверный элемент массива!!!");
        }
        return number[index];
    }

   public int length() {
        return index;
   }

    public double average() {
        double temp =0;
      for (int i = 0;i<index;i++) {
          temp +=(number[i].doubleValue());
      }
      temp = temp/number.length;
        return temp;
    }

    public double sum() {
        double temp =0;
        for (int i = 0;i<index;i++) {
            temp += (number[i].doubleValue());
        }
        return temp;
    }

    public T max() {
        T temp = number[0];
        for (int i = 0;i<index;i++) {

            ////********INTEGER*******
            if (number[i] instanceof Integer) {
                if ((Integer) temp < number[i].intValue())
                    temp = number[i];

                ////********DOUBLE*******
            } else if(number[i] instanceof Double) {
               if ((Double) temp < number[i].doubleValue())
                   temp = number[i];

                ////********LONG*******
           } else if(number[i] instanceof Long) {
                if ((Long) temp < number[i].longValue())
                    temp = number[i];

                ////********BYTE*******
            } else if(number[i] instanceof Byte) {
                if ((Byte) temp < number[i].byteValue())
                    temp = number[i];

                ////********FLOAT*******
            } else if(number[i] instanceof Float) {
                if ((Float) temp < number[i].floatValue())
                    temp = number[i];

                ////********SHORT*******
            } else if(number[i] instanceof Short) {
                if ((Short) temp < number[i].shortValue())
                    temp = number[i];
            }
        }
        return temp;
    }
}