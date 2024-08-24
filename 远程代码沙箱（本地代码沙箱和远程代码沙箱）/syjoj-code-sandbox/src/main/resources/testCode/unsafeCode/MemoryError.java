/**
 * @author syj
 * @date 2024/8/4 19:38
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 无限占用空间（浪费系统内存）
 */
public class Main {
    public static void main(String[] args) {
        List<byte[]> bytes = new ArrayList<>();
        while (true) {
            bytes.add(new byte[10000]);
        }
    }
}