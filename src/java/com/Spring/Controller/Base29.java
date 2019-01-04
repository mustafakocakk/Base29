package com.Spring.Controller;
import java.util.ArrayList;

/**
 * @author mustafaakocak
 * @version 1.0.0
 * @since  2019-29-12
 */

public class Base29 {

    /**
     * @param text base29 karakterleri içeren metni belirtir.
     * @param gelen gonderilen methoda göre gönderilen metin encode yada decode işlemine tabi tutulur.
     */
    private String text;
    private String gelen;

    public Base29(String gelen){
        this("abcdefghijklmnopqrstuvwxyzABCDEF",gelen);

    }
    public Base29(String text, String gelen) {
        this.text = text;
        this.gelen = gelen;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public String getGelen() {
        return gelen;
    }

    public void setGelen(String gelen) {
        this.gelen = gelen;
    }

    /**
     * getEncode methodu kendisine verilmiş olan metni base29  karakterlerine göre encode eder
     * @param  encode encode edilmiş metni tutar
     * @param  binaryList verilen metnin binary karşılığı tutulur
     * @param liste binarylist değişkenin 5'er 5'er bölerek decimal karşılığını bulur.
     * @param  sayi liste değişkeninde bulunan binary dizinin onluk tabanda karşılığını tutar.
     * @param kalan binaryList uzunluğunun 5'in katı olup olmadığını belirler.
     * @param  binary gelen her karakterin binary olarak tutulacagı belirler.
     * @param decimal gelen karakterlerin ascı tablosundaki sayısal değerini tutar.
     * */
    public String getEncode(){
        ArrayList<Integer> liste = new ArrayList<Integer>();
        ArrayList<Integer> binaryList = new ArrayList<Integer>();
        String encode="";
        int kalan=0;
        /**
         Bu döngü  gelen değişkenin uzunluğu kadar döner. Bu sırada her karakterin ascı karşılığını alıp
         binary olarak cevirir.
         * */
        for (int j=0;j<this.gelen.length();j++)
        {   int binary[] = new int[7];
            int index = 0;
            int decimal = (int) this.gelen.charAt(j);

            while (decimal > 0) {
                binary[index++] = decimal % 2;
                decimal = decimal / 2;
            }


            for (int i = binary.length - 1; i >= 0; i--) {
                binaryList.add(binary[i]);

            }


        }
/**
 binaryList dizisinin uzunluğu kontrol edilir eğer 5'in katı değilse  5'in katı  olacak şekilde ekleme yapılır.
 ***/
        kalan=binaryList.size()%5;
        if (kalan!=0){
            for (int i=0;i<5-kalan;i++){
                binaryList.add(binaryList.size(),0);
            }}
/**
 binarList dizisi 5'er 5'er olacak şekilde  liste dizisine atılır.Ardından liste binary dizisi decimal tabana cevrilip
 sayi değişkeninde tutulur. Bu çevrilen değer base29  metinde karşılık gelen indisdeki karakterle eşlenerek  encode değişkenine ekleme yapılır.
 * */
        for (int i=1;i<=binaryList.size();i++){
            if(i%5==0){
                int sayi=0;
                liste.add((Integer) binaryList.get(i-1));
                for(int j=liste.size()-1;j>=0;j--){
                    sayi= (int) (sayi+ (Math.pow(2,j))*liste.get(liste.size()-j-1));

                }
                encode=encode+this.text.charAt(sayi);
                liste.clear();
            }
            else {
                liste.add((Integer) binaryList.get(i-1));
            }

        }

        /*
         * encode edilmiş metni döndürür.
         * */
        return encode;


    }

    /**
     * getDecode methodu kendisine verilmiş olan  base29 metni  geriye decode eder
     * @param  decode methoda encode edilmiş olarak verilen metnin eski haline gelmiş durumunu tutar.
     * @param decodeBinary encode edilmiş metinde deki karakterin metne göre decimal karşılığını tutar.
     * @param retBinary  kendise encode edilmiş olarak verilen metnin binary halini tutan dize.
     * @param decodeBinarylist decode binarye  karşılık gelen decimal değerin binary olarak  tutar.
     * @param   kalan  retBinary list uzunluğunun 7 'nin katı olup oladığını tutar.
     * @param  sayi 7 bit 7 bit olacak sekilde karakterlerin asci  tablosundaki numarasının tutar.
     * */
    public   String getDecode(){

        String decode="";
        ArrayList<Integer> decodeBinaryList = new ArrayList<Integer>();
        ArrayList<Integer> retBinary = new ArrayList<Integer>();
        ArrayList<Integer> liste = new ArrayList<Integer>();

        /*
         * encode edilmiş metnin karakterleri  arasında gezilerek  her karakterin base29  indis karşılığı bulunur. Ardından binary çevrilir.
         * */
        for (int len=0;len<this.gelen.length();len++)
        {   int decodeIndex = 0;
            int decodeBinary[] = new int[5];
            int decodeDecimal = this.text.indexOf(this.gelen.charAt(len));
            if (decodeDecimal == 0) {
                for (int i = 0; i < 5; i++) {
                    decodeBinaryList.add(0);
                }
            }
            while (decodeDecimal > 0) {
                decodeBinary[decodeIndex++] = decodeDecimal % 2;
                decodeDecimal = decodeDecimal / 2;
            }
            for (int i = decodeIndex - 1; i >= 0; i--) {
                decodeBinaryList.add(decodeBinary[i]);
            }
            if (decodeBinaryList.size()<5){
                for (int i=0;i<5-decodeBinaryList.size();i++){
                    decodeBinaryList.add(i,0);
                    i--;
                }
            }
            for (int i=0;i<decodeBinaryList.size();i++){
                retBinary.add(decodeBinaryList.get(i));
            }
            decodeBinaryList.clear();
        }

        /*
         * retBinary list uzunuğu kontrol edilir 7'nin katı olmaz ise sonundaki fazla elamanlar çıkarılır.
         * */
        int kalan=retBinary.size()%7;
        if (kalan>0){
            for (int i = 0; i < kalan; i++) {
                retBinary.remove(retBinary.size()-1);
            }
        }

        /*
         * retBinary list içerisinde gezilerek  7 bit 7 bit olacak şekilde liste dizesine atılır.Atılan bu dize her seferinde
         * decimal taban çevrilip sayi değişkeninde tutulur.Sayi değişkenin ascı karşılığı bulunarak decode değişkeninin sonuna ekleme yapar.
         * */
        for (int i=1;i<=retBinary.size();i++){
            if(i%7==0){
                int sayi=0;
                liste.add((Integer) retBinary.get(i-1));
                for(int j=liste.size()-1;j>=0;j--){
                    sayi= (int) (sayi+ (Math.pow(2,j))*liste.get(liste.size()-j-1));

                }
                decode=decode+(char)sayi;
                liste.clear();

            }
            else {
                liste.add((Integer) retBinary.get(i-1));
            }

        }


        /*
         * decode edilmiş metni döndürür.
         * */
        return decode;

    }


}
