package com.pb.kalnaus.hw7;

public class Atelier {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        Clothes[] clothes = {
                new Pants("Штаны", Size.XXS,200,"blue"),
                new Skirt("Юбка",Size.XS,250,"black"),
                new Tie("Галстук", Size.S,300,"yellow"),
                new Tshirt("Футболка", Size.XXS,400,"pink"),
                new Skirt("Юбка", Size.M,320,"white"),};

            dressMan(clothes);
            dressWomen(clothes);

    }


    static void dressMan(Clothes[] clothes) {
        for (Clothes c : clothes) {

                if( c instanceof Pants)
                    System.out.println("Это мужская одежда !!!!" + ((Pants) c).dressMan());
                else if ( c instanceof Tie)
            System.out.println("Это мужская одежда !!!!" + ((Tie) c).dressMan());
                else if( c instanceof Tshirt)
            System.out.println("Это мужская одежда !!!!" + ((Tshirt) c).dressMan());
        }
    }

    static void dressWomen(Clothes[] clothes) {
        for (Clothes c : clothes) {
            if( c instanceof Pants)
                System.out.println("Это женская одежда !!!!" + ((Pants) c).dressWomen());
            else if ( c instanceof Skirt)
                System.out.println("Это женская одежда !!!!" + ((Skirt) c).dressWomen());
            else if( c instanceof Tshirt)
                System.out.println("Это женская одежда !!!!" + ((Tshirt) c).dressWomen());
             }
        }
    }
