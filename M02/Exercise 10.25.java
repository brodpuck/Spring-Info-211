import java.util.*;

public class Exercise10_25 {
    public static void main(String[] args) {
        String[] temp1 = split("ab#12#453", "#");
        for (String s : temp1) {
            System.out.print(s + " ");
        }
        System.out.println();

        String[] temp2 = split("a?b?gf#e", "[?#]");
        for (String s : temp2) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static String[] split(String s, String regex) {
        ArrayList<String> result = new ArrayList<>();
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(regex).matcher(s);

        int lastEnd = 0;
        while (matcher.find()) {
            String segment = s.substring(lastEnd, matcher.start());
            if (!segment.isEmpty()) {
                result.add(segment);
            }
            result.add(matcher.group());
            lastEnd = matcher.end();
        }

        if (lastEnd < s.length()) {
            result.add(s.substring(lastEnd));
        }

        return result.toArray(new String[0]);
    }
}