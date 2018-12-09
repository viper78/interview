package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

    public static final int NUM_FIELDS = 9;

    public static final String logEntryLine = "123.45.67.89 - - [27/Oct/2000:09:27:09 -0400] \"GET /java/javaResources.html HTTP/1.0\" 200 10450 \"-\" \"Mozilla/4.6 [en] (X11; U; OpenBSD 2.8 i386; Nav)\"";

    public static void main(String argv[]) {


    String regex = "([\\d.]+)([\\s-]+)\\[([\\w:/]+\\s[+-]\\d{4})\\]\\s\"(.*?)\"\\s(\\d{3})\\s(\\d+)\\s\"-\"\\s\"(.*?)\""; //(.*?)
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(logEntryLine);

    if (matcher.matches()) {

        System.out.println("Ip Address :" + matcher.group(1));
        System.out.println("Date/Time :" + matcher.group(3));
        System.out.println("Date/Time :" + matcher.group(4));
        System.out.println("HTTP Code :" + matcher.group(5));
        System.out.println("HTTP Code :" + matcher.group(6));
        System.out.println("HTTP Code :" + matcher.group(7));


    } else {
        System.out.println("no match");
    }


//        String logEntryPattern = "^([\\d.]+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\d+) \"([^\"]+)\" \"([^\"]+)\"";
//
//        System.out.println("Using RE Pattern:");
//        System.out.println(logEntryPattern);
//
//        System.out.println("Input line is:");
//        System.out.println(logEntryLine);
//
//        Pattern p = Pattern.compile(logEntryPattern);
//        Matcher matcher = p.matcher(logEntryLine);
//        if (!matcher.matches() ||
//                NUM_FIELDS != matcher.groupCount()) {
//            System.err.println("Bad log entry (or problem with RE?):");
//            System.err.println(logEntryLine);
//            return;
//        }
//        System.out.println("IP Address: " + matcher.group(1));
//        System.out.println("Date&Time: " + matcher.group(4));
//        System.out.println("Request: " + matcher.group(5));
//        System.out.println("Response: " + matcher.group(6));
//        System.out.println("Bytes Sent: " + matcher.group(7));
//        if (!matcher.group(8).equals("-"))
//            System.out.println("Referer: " + matcher.group(8));
//        System.out.println("Browser: " + matcher.group(9));
    }
}
