package tinder.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ServletUtil {
    public Cookie getCookiesByName(HttpServletRequest request, String name) {
        if (request.getCookies() == null) {
            return null;
        }
        for (int i = 0; i < request.getCookies().length; i++) {
            if (request.getCookies()[i].getName().equals(name)) {
                return request.getCookies()[i];
            }
        }
        return null;
    }

    public String reverseGender(String userGender){
        if (userGender.equals("male")){
            return "female";
        }
        else if (userGender.equals("female")){
            return "male";
        }
        else return null;
    }
}
