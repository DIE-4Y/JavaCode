package com.tank;


import java.io.*;
import java.util.Vector;

/**
 * 记录击毁坦克数
 * 和文件交互
 */
public class Recorder {
    private static int allEnemyTankCount = 0;
    private static BufferedWriter bufferedWriter = null;
    private static BufferedReader bufferedReader = null;
    private static String filePath = "d:\\桌面\\myRecord.txt";
    //用于保存敌人坦克位置的向量
    private static Vector<EnemyTank> enemyTanks = null;
    //用于文件读入的节点
    private static Vector<Node> nodes = new Vector<>();

    public static Vector<Node> getNodes() {
        return nodes;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static void setNodes(Vector<Node> nodes) {
        Recorder.nodes = nodes;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static int getAllEnemyTankCount() {
        return allEnemyTankCount;
    }

    //读取文件到Node的方法
    public static Vector<Node> getAllEnemyTank() {
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            allEnemyTankCount = Integer.parseInt(bufferedReader.readLine());
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String[] s = line.split(" ");
                Node node = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return nodes;
    }

    public static void storeRecord() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            //保存记录直接写入数字可能会发生异常出现乱码
            bufferedWriter.write(allEnemyTankCount + "");
            bufferedWriter.newLine();
            //保存剩余坦克的坐标
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.getLive()) {
                    bufferedWriter.write(enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection());
                    bufferedWriter.newLine();
                }
            }
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
