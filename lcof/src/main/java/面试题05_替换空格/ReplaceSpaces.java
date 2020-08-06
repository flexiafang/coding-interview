package 面试题05_替换空格;

/**
 * @Author hustffx
 * @Date 2020/8/6
 */
public class ReplaceSpaces {

    /**
     * 解法1：使用字符数组
     */
    public String replaceSpaces1(String s) {
        int length = s.length();
        char[] arr = new char[length * 3];
        // 替换后的字符串的长度
        int size = 0;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                arr[size++] = '%';
                arr[size++] = '2';
                arr[size++] = '0';
            } else {
                arr[size++] = c;
            }
        }

        return new String(arr, 0, size);
    }

    /**
     * 解法2：使用StringBuilder
     */
    public String replaceSpaces2(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
