package com.fjnu.intelligentwardrobe.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrcUtils {
    public static String Replace(String str){
        String dest="";
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(str);
        dest = m.replaceAll("");

        return dest;
    }
}
