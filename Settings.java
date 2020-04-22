import java.awt.*;

class Settings {

    static final Dimension SCREEN_SIZE;
    static final int SPEED = 250;
    static String[] symbols = new String[]{"-", "", "+"};
    static String[] items = new String[]{"do", "re", "mi", "fa", "so", "la", "xi"};
    static String track1;
    static String track2;

    static {
        SCREEN_SIZE = new Dimension(500, 500);
        track1 = "0-1-2-3-4-5-6-71234567+1+2+3+4+5+6+70";
        track2 = "00000000000000000000000";
        // two tigers
//        track1 += "10203010102030103040500030405000565430105654301020-50100020-501000";
//        track2 += "0000000000000000000000000000000000000000000000000000000000000000";
        // castle in the sky
        track1 += "00 00 00 67 +10 07 +10 +30 70 00 00 30 60 05 60 +10" +
                "50 00 00 43 40 03 40 +10 30 00 0+1 +1+1 70 04 40 70" +
                "70 00 00 67 +10 07 +10 +30 70 00 00 33 60 05 60 +10" +
                "50 00 00 30 40 +17 70 +10 +20 +3+1 +10 00 +17 60 70 50" +
                "60 00 00 +1+2 +30 0+2 +30 +50 +20 00 00 55 +10 07 +10 +30" +
                "+30 00 00 00 67 +10 7+1 +20 +10 05 50 00 +40 +30 +20 +10" +
                "+30 00 00 00 +30 00 00 +30 +60 00 +50 00 +30 +2+1 +10 00" +
                "+20 +1+2 +20 +50 +30 00 00 +30 +60 00 +50 00 +30 +2+1 +10 00" +
                "+20 +1+2 +20 70 60 00 00 67 +10 07 +10 +30 70 00 00 30" +
                "60 05 60 +10 50 00 00 43 40 03 40 +10 30 00 0+1 +1+1" +
                "70 04 40 70 70 00 00 67 +10 07 +10 +30 70 00 00 33" +
                "60 05 60 +10 50 00 00 30 40 +17 70 +10 +20 +3+1 +10 00" +
                "+10 70 60 00 70 00 50 00";
        track2 += "00 00 00 00 -6-3 -61 30 00 -3-7 -3-5 -70 00 -4-1 -4-6 10 00" +
                "-1-5 13 50 00 -2-6 -2-4 -60 00 -6-3 -61 30 00 -3-7 -3-5 -70 00" +
                "-3-7 -3-5 -70 00 -6-3 -61 30 00 -3-7 -3-5 -70 00 -4-1 -4-6 10 00" +
                "-1-5 13 50 00 -2-5 -2-4 -60 00 -6-3 -61 30 00 -4-1 -4-6 10 00" +
                "-6-3 -61 30 00 -1-5 13 50 00 -5-2 -5-7 20 00 -6-3 -61 30 00" +
                "-3-7 -3-5 -70 00 -4-1 -4-1 -5-2 -5-2 -1-5 13 50 00 -2-6 -2-4 -60 00" +
                "-3-7 -3-5 -70 00 -3-7 -3-5 -70 00 -6-3 -6-3 -5-2 -5-2 -4-1 -4-6 10 00" +
                "-5-2 -5-7 20 00 -1-5 13 50 00 -6-3 -6-3 -5-2 -5-2 -4-1 -4-6 10 00" +
                "-5-2 -5-7 20 00 -6-3 -61 30 00 -6-3 -61 30 00 -3-7 -3-5 -70 00" +
                "-4-1 -4-6 10 00 -1-5 13 50 00 -2-6 -2-4 -60 00 -6-3 -61 30 00" +
                "-7-4 -7-2 -40 00 -3-7 -3-5 -70 00 -6-3 -61 30 00 -3-7 -3-5 -70 00" +
                "-4-1 -4-6 10 00 -1-5 13 50 00 -2-6 -2-4 -60 00 -6-3 -61 30 00" +
                "-40 -10 -40 -10 -30 -70 -30 -70";
        // only my railgun
//        track1 += "0060 6056 0060 5056 0060 6056 0060 5056 0060 6056 0060 5056 0060 6056 0060 5056" +
//                "0060 6056 0060 5056 0060 6056 0060 5056 0060 6056 0060 5056 0060 6056 00+10 +70+50" +
//                "+50+6+6 +60+50 +50+6+6 +60+50 +50+6+6 +60+60 +60+70 +10+20 +7000 +5000 +4000 +2000 +200+2 +20+30 00+10 +70+50" +
//                "+50+6+6 +60+50 +50+6+6 +60+50 +50+6+6 +60+60 +60+70 +10+20 +6000 0000 +60+70 +10+20 +7000 +5000 +3000 +5000" +
//                "+50+6+6 +60+10 +70+5+3 +30+50 +50+6+6 +6000 +6000 0000 +6000 0000 0000 0000";
//        track2 += "-6000 0000 0000 0000 -6000 0000 0000 0000 -6000 0000 0000 0000 -6000 0000 0000 0000" +
//                "-6000 -6000 -6000 -6000 -6000 -6000 -6000 -6000 -6000 -6000 -6000 -6000 -6000 -6000 -1000 -0000" +
//                "-60-30 -60-30 -60-30 -60-30 -40-40 -40-40 -40-40 -40-40 -50-50 -20-50 -50-50 -20-50 -10-50 -30-50 -70-70 -50-70" +
//                "-60-30 -60-30 -60-30 -60-30 -40-40 -40-40 -40-40 -40-40 -20-20 -60-20 -20-20 -60-20 -30-30 -70-30 -30-30 -70-30" +
//                "-40-10 -40-60 -50-50 -20-50 -6000 0000 0000 3000 1000 0000 0000 0000";
    }

    private Settings() {}
}