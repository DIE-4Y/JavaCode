package com.tank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 记录击毁坦克数
 * 和文件交互
 */
public class Recorder {
    private static int allEnemyTankCount = 0;
    private static BufferedWriter bufferedWriter = null;
    private static String filePath = "d:\\桌面\\myRecord.txt";

    public static int getAllEnemyTankCount() {
        return allEnemyTankCount;
    }

    public static void storeRecord() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write(allEnemyTankCount+"");
            bufferedWriter.newLine();
            System.out.println("文件写入成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void addEnemyTankCount() {
        allEnemyTankCount++;
    }
}
