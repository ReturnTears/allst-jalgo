package com.allst.jvalgo.advalgo;

import java.util.*;

/**
 * 数据转换
 * @author June 2019/04/11 下午 09:07
 * @version 1.0
 */
public class LabourDataTrans {

    public static void main(String[] args) {
//        parseData(data());
        erShuzu(parseData(data()));

//        List<String[]> list = iterMap(saveFull());
//        for (int i = 0; i < list.size(); i++) {
//            for (String str : list.get(i)) {
//                System.out.println("元素 : " + str);
//            }
//        }

//        String[] a = list.get(3);
//        for (String str : a) {
//            System.out.println("a : " + str);
//        }
    }

    /**
     * 将不全的数据添加完整
     * @return
     */
    private static List<Map<String, Object>> saveFull() {
        List<Map<String, Object>> list = data();

        // 按照工种分类将 职位及其对应的人数保存在一起
        Map<String, Object> mapPuGong = new HashMap<>();
        Map<String, Object> mapHanGong = new HashMap<>();
        Map<String, Object> mapChaChe = new HashMap<>();
        Map<String, Object> mapDianGong = new HashMap<>();
        Map<String, Object> mapDiaoGong = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> linkedHashMapRes = list.get(i);
            String nameValue = (String) linkedHashMapRes.get("name");
            String positionValue = (String) linkedHashMapRes.get("position");
            String numsValue = (String) linkedHashMapRes.get("nums");
            System.out.println("name-" + nameValue + ", position-" + positionValue + ", nums-" + numsValue);

            if ("普工".equals(nameValue)) {
                mapPuGong.put(positionValue, numsValue);
            } else if ("焊工".equals(nameValue)) {
                mapHanGong.put(positionValue, numsValue);
            } else if ("叉车工".equals(nameValue)) {
                mapChaChe.put(positionValue, numsValue);
            } else if ("电工".equals(nameValue)) {
                mapDianGong.put(positionValue, numsValue);
            } else {
                mapDiaoGong.put(positionValue, numsValue);
            }
        }
        // 判断工种集合中的数据是否完整
        Map<String, Object> pugong = isFull(mapPuGong);
        Map<String, Object> hangong = isFull(mapHanGong);
        Map<String, Object> chache = isFull(mapChaChe);
        Map<String, Object> diangong = isFull(mapDianGong);
        Map<String, Object> diaogong = isFull(mapDiaoGong);

        // 将所有的KV封装在List集合中
        List<Map<String, Object>> mapList = new LinkedList<>();
        mapList.add(pugong);
        mapList.add(hangong);
        mapList.add(chache);
        mapList.add(diangong);
        mapList.add(diaogong);
        return mapList;
    }

    /**
     * 假数据提供类
     * @return
     */
    private static List<Map<String, Object>> data() {
        List<Map<String, Object>> list = new LinkedList<>();
        Map linkedHashMap = new HashMap();
        linkedHashMap.put("name","普工");
        linkedHashMap.put("position","普通员工");
        linkedHashMap.put("nums", "10");
        list.add(linkedHashMap);
        Map linkedHashMap2 = new HashMap();
        linkedHashMap2.put("name","电工");
        linkedHashMap2.put("position","施工员");
        linkedHashMap2.put("nums", "2");
        list.add(linkedHashMap2);
        Map linkedHashMap3 = new HashMap();
        linkedHashMap3.put("name","叉车工");
        linkedHashMap3.put("position","安全员");
        linkedHashMap3.put("nums", "1");
        list.add(linkedHashMap3);
        Map linkedHashMap4 = new HashMap();
        linkedHashMap4.put("name","叉车工");
        linkedHashMap4.put("position","监理");
        linkedHashMap4.put("nums", "3");
        list.add(linkedHashMap4);
        Map linkedHashMap5 = new HashMap();
        linkedHashMap5.put("name","电工");
        linkedHashMap5.put("position","安全员");
        linkedHashMap5.put("nums", "6");
        list.add(linkedHashMap5);
        return list;
    }

    /**
     * 封装Map,返回List集合
     * @return
     */
    private static List<String[]> iterMap(List<Map<String, Object>> mapList) {
        String[] ptyg = new String[5];
        String[] sgy = new String[5];
        String[] aqy = new String[5];
        String[] jl = new String[5];
        for (int i = 0; i < mapList.size(); i++) {
            for (Map.Entry<String, Object> entry : mapList.get(i).entrySet()) {
                if (entry.getKey().contains("普通员工")) {
                    ptyg[i] = (String) entry.getValue();
                } else if (entry.getKey().contains("施工员")) {
                    sgy[i] = (String) entry.getValue();
                } else if (entry.getKey().contains("安全员")) {
                    aqy[i] = (String) entry.getValue();
                } else {
                    jl[i] = (String) entry.getValue();
                }
            }
        }
        List<String[]> list = new LinkedList<>();
        list.add(ptyg);
        list.add(sgy);
        list.add(aqy);
        list.add(jl);
        return list;
    }

    /**
     * 判断工种集合中的数据是否完整
     * @param map
     * @return
     */
    private static Map<String, Object> isFull(Map<String, Object> map) {
        if (map.size() < 4) {
            Object value1 = null, value2 = null, value3 = null, value4 = null;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                value1 = entry.getKey().contains("普通员工") ? entry.getValue() : "null";
                value2 = entry.getKey().contains("施工员") ? entry.getValue() : "null";
                value3 = entry.getKey().contains("安全员") ? entry.getValue() : "null";
                value4 = entry.getKey().contains("监理") ? entry.getValue() : "null";
            }
            map.put("普通员工", value1);
            map.put("施工员", value2);
            map.put("安全员", value3);
            map.put("监理", value4);
        }
        return map;
    }

    /**
     * 解析数据库返回的数据
     * @return
     */
    private static Map<String, String> parseData(List<Map<String, Object>> mapList) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < mapList.size(); i++) {
            Map<String, Object> linkedHashMapRes = mapList.get(i);
            String nameValue = (String) linkedHashMapRes.get("name");
            String positionValue = (String) linkedHashMapRes.get("position");
            String numsValue = (String) linkedHashMapRes.get("nums");
            String name_position = positionValue + nameValue ;
            // 保存解析数据
            map.put(name_position, numsValue);
        }
        // 循环数据
//         for (Map.Entry<String, String> entry : map.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//             System.out.println(key + " --- " + value);
//         }
        return map;
    }

    /**
     * 自定义一个二维数组
     */
    private static List<String[]> erShuzu(Map<String, String> map) {
        String gongzhong = "普工,焊工,叉车工,电工,龙门吊操作员";
        String zhiwei = "普通员工,施工员,安全员,监理";
        String[] gzArr = gongzhong.split(",");
        String[] zwArr = zhiwei.split(",");

        // 该数组用于保存各个工种下对应的职位
        String[][] labourArrs = new String[zwArr.length][gzArr.length];
        // 该数组用于保存解析数据后的职位人数
        String[][] labourNums = new String[zwArr.length][gzArr.length];

        for (int i = 0; i < zwArr.length; i++) {
            for (int j = 0; j < gzArr.length; j++) {
                labourArrs[i][j] = zwArr[i] + gzArr[j];
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey().equals(labourArrs[i][j])) {
                        labourNums[i][j] = labourArrs[i][j].equals(entry.getKey()) ? entry.getValue() : " ";
                    }
                }
            }
        }
        List<String[]> list = new ArrayList<>();
        for (String[] dataRes : labourNums) {
            list.add(dataRes);
        }
//        for (String[] strings : list) {
//            for (String s : strings) {
//                System.out.println("元素 ： " + s);
//            }
//        }
        return list;
    }
}
