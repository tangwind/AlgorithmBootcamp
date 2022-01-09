package week02;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 子域名访问计数
 */
public class Demo1 {
    public static void main(String[] args) {
        String[] cpdomains = new String[]{
                "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
        };
        List<String> strings = subdomainVisits(cpdomains);
        System.out.println(strings.toString());
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            String domainStr = split[1];
            String[] domains = domainStr.split("\\.");
            String domain = null;
            int count = countStrConvertInt(split[0]);
            for (int j = domains.length - 1; j >= 0; j--) {
                domain = domain == null ? domains[j] : domain + "." + domains[j];
                map.compute(domain, (k, v) -> v == null ? count : count + v);
            }
        }

        return map.entrySet()
                .stream()
                .map(entry -> entry.getValue() + " " + entry.getKey())
                .collect(Collectors.toList());
    }

    private static int countStrConvertInt(String countStr) {
        try {
            return Integer.parseInt(countStr);
        } catch (NullPointerException e) {
            System.out.println("countStr convert int exception, " + "countStr: " + countStr);
            return 0;
        }
    }


}
