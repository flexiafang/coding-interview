# [面试题05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)

## 题目描述

请实现一个函数，把字符串 `s` 中的每个空格替换成 `"%20"`。

**示例：**

```
输入：s = "We are happy."
输出："We%20are%20happy."
```

**限制：**

```
0 <= s 的长度 <= 10000
```

## 解法 1 使用字符数组

```java
public class ReplaceSpaces {
    
    public String replaceSpaces1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

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
}
```

## 解法 2 使用StringBuilder

```java
public class ReplaceSpaces {
    
    public String replaceSpaces2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

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
```

