package ua.com.danit;

public class MyXor {

    public String xor(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != '0' && a.charAt(i) != '1') return "";
        }
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) != '0' && b.charAt(i) != '1') return "";
        }

        int maxLenght = Math.max(a.length(),b.length());
        a = prepand(a, maxLenght);
        b = prepand(b, maxLenght);
        String result = "";
        for (int i = 0; i < maxLenght; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                result += "0";
            } else result += "1";

        }

        return result;
    }

    private String prepand(String a, int maxLenght) {
        int n = a.length();
        for (int i = 0; i < maxLenght - n; i++) {
            a = "0" + a;

        }
        return a;
    }

}
