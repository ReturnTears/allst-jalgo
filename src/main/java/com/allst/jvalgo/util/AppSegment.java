package com.allst.jvalgo.util;

/**
 * @author Hutu
 * @since 2025-03-25 下午 08:44
 */
public class AppSegment {
    public static void main(String[] args) {
        MySegmentMap<String, String> mySegmentMap = new MySegmentMap<>();
        new Thread(new MyThread(mySegmentMap, "put", "1", "2")).start();
        new Thread(new MyThread(mySegmentMap, "get", "1", "")).start();
        new Thread(new MyThread(mySegmentMap, "get", "2", "")).start();
    }

    static class MyThread implements Runnable {
        MySegmentMap<String, String> mySegmentMap = null;
        String method = "";
        String key = "";
        String value = "";

        public MyThread(MySegmentMap<String, String> mySegmentMap, String method, String key, String value) {
            this.mySegmentMap = mySegmentMap;
            this.method = method;
            this.key = key;
            this.value = value;
        }

        @Override
        public void run() {
            switch (method) {
                case "put":
                    mySegmentMap.put(key, value);
                    break;
                case "get":
                    System.out.println("value:" + mySegmentMap.get(key));
                    break;
                default:
                    System.out.println("default");
            }
        }
    }
}
