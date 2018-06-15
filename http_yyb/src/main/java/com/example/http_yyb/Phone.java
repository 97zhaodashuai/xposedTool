package com.example.http_yyb;

import java.util.Random;
import java.util.UUID;

public class Phone {

    public static String getAndroidId(){
        String[]  base_char = {
                "0","1","2","3",
                "4","5","6","7",
                "8","9","a","b",
                "c","d","e","f"
        };
        String  android_id = "";
        for(int i = 0; i < 16; i++){
            int index = (int)( Math.random() * 1000 )  % base_char.length;
            android_id +=base_char[index];
        }
        return android_id;
    }

    public static String getPhoneGUID(){
        String phoneGUID = "";
        for(int i = 0;i < 19; i++){
            phoneGUID +=randNum();
        }
        return phoneGUID;
    }


    public  static  String getIMSI(){
        String mIMSINO = null;
        if(mIMSINO == null){
            String a = "4600";
            String[] b = {
                    "00",
                    "02",
                    "10",
                    "03",
                    "01"
            };
            String tail = "";
            for(int i = 0;i < 9; i++){
                tail +=randNum();
            }

            mIMSINO = String.format("%s%s",a, b[(int)(Math.random()*100)%5]) + tail;
        }
        return mIMSINO;
    }




    public static String getIMEI( ){
        String imei_model = "";

        String[] is ={
                "35416005!GT-I9105P",
                "86771500!GT-I9018",
                "86080602!M040",
                "86129002!LenovoA630t",
                "86858001!GN9002",
                "86262002!MI2S",
                "86462002!R831S",
                "86552802!G750-T01",
                "86290102!HS-U980",
                "86435001!vivoS7t",
                "86232602!LenovoA820t",
                "86351702!vivoY15T",
                "86061502!Coolpad7235",
                "35652105!GT-I9200",
                "35620505!GT-N7100",
                "86031102!MI3",
                "35589605!GT-N5100",
                "86259402!G610-T11",
                "86473001!ZTEU960E",
                "35743405!SM-C101",
                "35224606!HTCD816w",
                "86296102!vivoY17T",
                "35965005!GT-I9158P",
                "35185805!HTCT328w",
                "35427305!GT-N7108",
                "86541102!MI3",
                "86062302!HUAWEI G610-U00",
                "35963105!GT-I9508",
                "86013902!MI1S",
                "86392902!Coolpad 8079",
                "35553305!GT-I9300",
                "86695901!LenovoP770",
                "86877201!Coolpad 7295",
                "86790700!DOOV D500",
                "86459002!ZTE Q505T",
                "86275602!HUAWEI MT2-L02",
                "86282302!U55GT",
                "86081302!X909T",
                "86262002!MI2S",
                "86977201!vivo S3+",
                "35752305!SM-N9008",
                "86210801!GN878",
                "86274101!Lenovo A800",
                "35978605!SM-N9006",
                "86493101!JY-G2",
                "86210802!U707T",
                "86283302!vivoY15T",
                "86381101!vivoX510t",
                "35953805!GT-I8552",
                "86031002!MI2A",
                "86918801!A789",
                "86531702!HM NOTE 1W",
                "86469102!HM1",
                "35755505!SM-N9002",
                "35224606!HTC D816w",
                "86356101!SOJA S510A",
                "35698105!GT-S5831i",
                "86085002!Coolpad 7296",
                "86942101!OPPO X909",
                "86106702!Coolpad 7295",
                "35553305!GT-I9300",
                "86409302!Coolpad 8720L",
                "86450102!ZTE U9180",
                "35885105!GT-I9500",
                "86727301!Lenovo S560",
                "86096102!K-Touch T60",
                "86218702!Lenovo A390t",
                "86501902!Lenovo A788t",
                "35340506!SM-G7106",
                "86404600!M9",
                "86094302!vivo Y19t",
                "35778405!SM-N9006",
                "35401605!GT-I9100G",
                "35651705!GT-I9082i",
                "86213602!Coolpad 8297W",
                "86365402!H30-T10",
                "35482905!GT-I8262D",
                "86284502!M351",
                "86418602!HS-X68T",
                "86098902!K-Touch T619+"
        };
        String[] tmp = is[(int)(Math.random() * 1000) % is.length].split("!");
        String  imei = makeIMEI(tmp[0] + String.valueOf((int)(Math.random() * 899999) + 100000));
        return imei;
    }



    public static String getMac(){
        return createRandomMacAddress();
    }

    public static  String getmoloDeviceId(){
        String pre = "";
        for(int i = 0; i < 13; i++){
            pre +=randNum();
        }

        String mid = "{" + UUID.randomUUID().toString() + "}";

        String tail = "";

        for(int i = 0; i < 3; i++){
            tail +=randNum();
        }
        return pre + mid + tail;
    }


    public static  String getQua(){
        //"TMA_411/040447&NA/040447&5.1.1_22_1&111_67_14&google_Nexus5&992019&NA&V3";

        String q1 = "TMA_411/040447";
        String q2 = "NA/040447";
        String q4 = "6.0.1_22_1";
        String q5 = "111_67_14";
        String q6 = "XiaoMI" + "_" + getModel();
        String q7 = "992019";
        String q8 = "NA";
        String q9 = "V3";

        return q1 + "&" +
                q2 + "&" +
                q4 + "&" +
                q5 + "&" +
                q6 + "&" +
                q7 + "&" +
                q8 + "&" +
                q9;
    }




//================================================================================================


    public static  String getModel(){
        String[] is ={
                "35416005!GT-I9105P",
                "86771500!GT-I9018",
                "86080602!M040",
                "86129002!LenovoA630t",
                "86858001!GN9002",
                "86262002!MI2S",
                "86462002!R831S",
                "86552802!G750-T01",
                "86290102!HS-U980",
                "86435001!vivoS7t",
                "86232602!LenovoA820t",
                "86351702!vivoY15T",
                "86061502!Coolpad7235",
                "35652105!GT-I9200",
                "35620505!GT-N7100",
                "86031102!MI3",
                "35589605!GT-N5100",
                "86259402!G610-T11",
                "86473001!ZTEU960E",
                "35743405!SM-C101",
                "35224606!HTCD816w",
                "86296102!vivoY17T",
                "35965005!GT-I9158P",
                "35185805!HTCT328w",
                "35427305!GT-N7108",
                "86541102!MI3",
                "86062302!HUAWEI G610-U00",
                "35963105!GT-I9508",
                "86013902!MI1S",
                "86392902!Coolpad 8079",
                "35553305!GT-I9300",
                "86695901!LenovoP770",
                "86877201!Coolpad 7295",
                "86790700!DOOV D500",
                "86459002!ZTE Q505T",
                "86275602!HUAWEI MT2-L02",
                "86282302!U55GT",
                "86081302!X909T",
                "86262002!MI2S",
                "86977201!vivo S3+",
                "35752305!SM-N9008",
                "86210801!GN878",
                "86274101!Lenovo A800",
                "35978605!SM-N9006",
                "86493101!JY-G2",
                "86210802!U707T",
                "86283302!vivoY15T",
                "86381101!vivoX510t",
                "35953805!GT-I8552",
                "86031002!MI2A",
                "86918801!A789",
                "86531702!HM NOTE 1W",
                "86469102!HM1",
                "35755505!SM-N9002",
                "35224606!HTC D816w",
                "86356101!SOJA S510A",
                "35698105!GT-S5831i",
                "86085002!Coolpad 7296",
                "86942101!OPPO X909",
                "86106702!Coolpad 7295",
                "35553305!GT-I9300",
                "86409302!Coolpad 8720L",
                "86450102!ZTE U9180",
                "35885105!GT-I9500",
                "86727301!Lenovo S560",
                "86096102!K-Touch T60",
                "86218702!Lenovo A390t",
                "86501902!Lenovo A788t",
                "35340506!SM-G7106",
                "86404600!M9",
                "86094302!vivo Y19t",
                "35778405!SM-N9006",
                "35401605!GT-I9100G",
                "35651705!GT-I9082i",
                "86213602!Coolpad 8297W",
                "86365402!H30-T10",
                "35482905!GT-I8262D",
                "86284502!M351",
                "86418602!HS-X68T",
                "86098902!K-Touch T619+"
        };
        String[] tmp = is[(int)(Math.random() * 1000) % is.length].split("!");
        return tmp[1];
    }

    private static String makeIMEI(String src){

        String imeiString=src;//前14位
        char[] imeiChar=imeiString.toCharArray();
        int resultInt=0;
        for (int i = 0; i < imeiChar.length; i++) {
            int a=Integer.parseInt(String.valueOf(imeiChar[i]));
            i++;
            final int temp=Integer.parseInt(String.valueOf(imeiChar[i]))*2;
            final int b=temp<10?temp:temp-9;
            resultInt+=a+b;
        }
        resultInt%=10;
        resultInt=resultInt==0?0:10-resultInt;
        return (imeiString+resultInt);
    }

    public static  String randNum(){
        String[]  tmp = {"0","1","2","3",
                "4","5","6","7",
                "8","9"};

        int index = (int)( Math.random() * 1000 )  % tmp.length;
        return tmp[index];
    }

    public static String randChar(){
        String[]  tmp = {
                "a","b","c","d",
                "e","f","g","h",
                "i","j","k","l",
                "m","n","o","p",
                "q","r","s","t",
                "u","v","w","x",
                "y","z"};

        int index = (int)( Math.random() * 1000 )  % tmp.length;
        return tmp[index];
    }

    private static String createRandomMacAddress(){
        String macAddress = getRandChars(6);
        return macAddress;
    }

    /**
     * 生成 2个随机的小写字母或者数字组成的串
     *
     * @return
     */
    public static String getRandChars(int len){
        String multiChars = "";
        for (int i=0;i<len;i++){
            multiChars = multiChars.concat(":");
            String chars = getRandTwoChars();
            multiChars = multiChars.concat(chars);
        }
        if (len > 0){
            multiChars = multiChars.substring(1);
        }
        return multiChars;
    }


    /**
     * 生成2个随机的小写字母或者数字
     *
     * @return
     */
    private static String getRandTwoChars(){
        String chars = createRandomChar();
        return chars.concat(createRandomChar());
    }

    /**
     * 生成随机的小写字母或者数字
     *
     * @return 随机的小写字母或者数字
     */
    private static String createRandomChar(){
        String[] chars= new String[]{
                "a","b","c","d","e","f","0",
                "1","2","3","4","5","6","7","8","9",
        };
        Random rand = new Random();
        int rInt = rand.nextInt(chars.length);
        return chars[rInt];
    }


}
