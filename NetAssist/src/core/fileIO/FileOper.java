package core.fileIO;

import java.io.*;

public class FileOper {

    private static String lineFromFile;

    /**
     * 读入TXT文件
     */
    public static void readFile() {
        // 绝对路径或相对路径都可以
        String pathname = "res/input.txt";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                System.out.println(line);//此处可输出到输入框
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入TXT文件
     */
    public static void writeFile(String textContent) {
        try {
            File writeName = new File("res/output.txt"); // 如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                out.append(textContent)
                        .append("\r\n"); //   \r\n 为换行
                out.flush(); // 把缓存区内容压入文件
                //out.close();//关闭文件防止资源泄露
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //调用测试
    public static void main(String[] args) {
        readFile();
        writeFile("1500310223\n" +
                "typ\n" +
                "唐运鹏\n" +
                "GUET");
        //writeFile("桂林电子科技大学");
    }
}

