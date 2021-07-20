package MyTest;

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        byte[] bys = {97, 98, 99};
        System.out.println(getType(bys[0]));
        String s = new String(bys);
        System.out.println(s);
    }
    private static String getType(Object a) {
        return a.getClass().toString();
    }
}
