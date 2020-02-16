package com.allst.jvalgo.sparse;

import java.io.*;

/**
 * 将稀疏数组的结果保存在磁盘Disk map.data上
 * @author YiYa
 * @since 2020-02-16 下午 07:19
 */
public class StoreArrToDisk {

    final static String filePath = "E:\\TestData\\map.txt";

    /**
     * 保存数据到磁盘
     */
    public static void storeToDisk(int[][] data) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }

            // FileOutputStream fos = new FileOutputStream(file);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            StringBuilder str = new StringBuilder();
            for (int[] row : data) {
                for (int col : row) {
                    str.append(col).append("\t");
                }

                str.append("\n");
                bw.write(str.toString());
                str = new StringBuilder();
            }

            System.out.println("写入文件完成~~~");
            // fos.close();
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 从磁盘获取数据并写入到内存中
     */
    public static void obtainFromDisk (String filePath) {
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int row = 0;
            int col = 0;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line.trim()).append(",");
                String[] temp = line.split("\t");
                col = temp.length;
                row++;

            }
            // System.out.printf("%d, %d", row, col);
            // 创建稀疏数组
            int[][] sparseArr = new int[row][col];
            // 赋值稀疏数组
            String[] rowStr = sb.toString().split(",");
            for (int i = 0; i < rowStr.length; i++) {
                String[] colStr = rowStr[i].split("\t");
                for (int j = 0; j < colStr.length; j++) {
                    sparseArr[i][j] = Integer.parseInt(colStr[j]);
                }
            }

            //显示读取出的数组
            for(int i = 0; i < row; i++){
                for(int j = 0; j<col; j++){
                    System.out.print(sparseArr[i][j]+"\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        obtainFromDisk("E:\\TestData\\map.txt");
    }

}
