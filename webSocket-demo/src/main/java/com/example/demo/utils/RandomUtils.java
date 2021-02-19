package com.example.demo.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数工具
 *
 *
 */
public class RandomUtils {

    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(RandomUtils.class);

//    private static Random random = new Random();
//
//    static {
//        RandomUtils.random.setSeed(System.currentTimeMillis() * RandomUtils.random.hashCode() * RandomUtils.random.getClass().hashCode());
//    }

    public static int random(int max) {
        return ThreadLocalRandom.current().nextInt(max);
    }

    public static <T> T randomList(List<T> list) {
        if(list==null||list.isEmpty())return null;
        return list.get(random(list.size()));
    }

    public static <T> T randomArray(T[] arr) {
        if(arr==null||arr.length==0)return null;
        return arr[random(arr.length)];
    }

    /**
     * 包含最大最小值
     *
     * @param min
     * @param max
     * @return
     */
    public static int random(int min, int max) {
        if (max - min <= 0) {
            return min;
        }
        return min + ThreadLocalRandom.current().nextInt(max - min + 1);
    }

    /**
     * 包含最大最小值
     *
     * @param min
     * @param max
     * @return
     */
    public static long random(long min, long max) {
        if (max - min <= 0) {
            return min;
        }
        return min + ThreadLocalRandom.current().nextLong(max - min + 1);
    }

    /**
     * gailv/probability 比率形式
     *
     * @param probability
     * @param gailv
     * @return
     */
    public static boolean isGenerate2(int probability, int gailv) {
        if (probability == gailv) {
            return true;
        }
        if (gailv == 0) {
            return false;
        }
        int random_seed = ThreadLocalRandom.current().nextInt(probability);
        return random_seed + 1 <= gailv;
    }

    /**
     * 从 min 和 max 中间随机一个值
     *
     * @param max
     * @param min
     * @return 包含min max
     */
    public static int randomValue(int max, int min) {
        int temp = max - min;
        temp = ThreadLocalRandom.current().nextInt(temp + 1);
        temp = temp + min;
        return temp;
    }

    /**
     * 返回在0-maxcout之间产生的随机数时候小于num
     *
     * @param num
     * @return
     */
    public static boolean isGenerateToBoolean(float num, int maxcout) {
        double count = Math.random() * maxcout;

        return count < num;
    }

    /**
     * 返回在0-maxcout之间产生的随机数时候小于num
     *
     * @param num
     * @return
     */
    public static boolean isGenerateToBoolean(int num, int maxcout) {
        double count = Math.random() * maxcout;

//    	BaseLogger.getMe().error("计算========"+ count);
//    	BaseLogger.getMe().error("传入========"+ num);
//    	BaseLogger.getMe().error("计算<传入");
//    	BaseLogger.getMe().error(count<num);
        return count < num;
    }

    /**
     * 随机产生min到max之间的整数值 包括min max
     *
     * @param min
     * @param max
     * @return
     */
    public static int randomIntValue(int min, int max) {
        return (int) (Math.random() * (double) (max - min + 1)) + min;
    }

    public static float randomFloatValue(float min, float max) {
        return (float) (Math.random() * (double) (max - min)) + min;
    }

    public static <T> List<T> randomElements(Collection<T> collection, int num) {
        List<T> list = new ArrayList<>();
        List<T> allList = new ArrayList<>();
        if (collection == null || collection.isEmpty() || collection.size() < num) {
            return list;
        }
        allList.addAll(collection);
        while (list.size() < num && !allList.isEmpty()) {
            int index = random(allList.size());
            list.add(allList.get(index));
            allList.remove(index);
        }
        return list;
    }

    public static <T> T randomElement(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        int t = (int) (collection.size() * Math.random());
        int i = 0;
        for (Iterator<T> item = collection.iterator(); i <= t && item.hasNext(); ) {
            T next = item.next();
            if (i == t) {
                return next;
            }
            i++;
        }
        return null;
    }

    /**
     * @return
     */
    public static int randomIndexByProb(List<? extends Number> probs) {
//        try {
//            LinkedList<Integer> newprobs = new LinkedList<Integer>();
//            //[0,0,0,0,0,0,0,0,10000]
//            for (int i = 0; i < probs.size(); i++) {
////				if (probs.get(i) > 0) {
//                if (i == 0) {
//                    newprobs.add(probs.get(i));
//                } else {
//                    newprobs.add(newprobs.get(i - 1) + probs.get(i));
//                }
////				}
//            }
//            if (newprobs.size() <= 0) {
//                return -1;
//            }
//            int last = newprobs.getLast();
//            if (last == 0) {
//                return -1;
//            }
////			String[] split = last.split(Symbol.XIAHUAXIAN_REG);
//            int random = random(last);
//            for (int i = 0; i < newprobs.size(); i++) {
//                int value = newprobs.get(i);
////				String[] split2 = string.split(Symbol.XIAHUAXIAN_REG);
////				if(Integer.parseInt(split2[1])>random){
//                if (value > random) {
//                    return i;
//                }
//            }
//        } catch (Exception e) {
//            logger.error("计算机率错误" + probs.toString(), e);
//        }
//        return -1;
        int len = probs.size();
        if (len == 0) return -1;

        TreeMap<Double, Integer> weightMap = new TreeMap<>();

        for (int i = 0; i < len; i++) {
            double value = probs.get(i).doubleValue();
            if (value <= 0) continue;
            double lastWeight = weightMap.size() == 0 ? 0 : weightMap.lastKey().doubleValue();//统一转为double
            weightMap.put(value + lastWeight, i);//权重累加
        }

        if (weightMap.isEmpty()) return -1;
        double randomWeight = weightMap.lastKey() * Math.random();
        NavigableMap<Double, Integer> tailMap = weightMap.tailMap(randomWeight, false);
        return weightMap.get(tailMap.firstKey());
    }

    public static int randomIndexByProb(Number... probs) {
        int len = probs.length;
        if (len == 0) return -1;

        TreeMap<Double, Integer> weightMap = new TreeMap<>();

        for (int i = 0; i < len; i++) {
            double value = probs[i].doubleValue();
            if (value <= 0) continue;
            double lastWeight = weightMap.size() == 0 ? 0 : weightMap.lastKey().doubleValue();//统一转为double
            weightMap.put(value + lastWeight, i);//权重累加
        }

        if (weightMap.isEmpty()) return -1;
        double randomWeight = weightMap.lastKey() * Math.random();
        NavigableMap<Double, Integer> tailMap = weightMap.tailMap(randomWeight, false);
        return weightMap.get(tailMap.firstKey());
    }

    /**
     * @return
     */
    public static int randomIndexByProb(int[] probs) {
        try {
            LinkedList<Integer> newprobs = new LinkedList<Integer>();
            for (int i = 0; i < probs.length; i++) {
                if (i == 0) {
                    newprobs.add(probs[i]);
                } else {
                    newprobs.add(newprobs.get(i - 1) + probs[i]);
                }
            }
            if (newprobs.size() <= 0) {
                return -1;
            }
            int last = newprobs.getLast();
            if (last == 0) {
                return -1;
            }
            int random = random(last);
            for (int i = 0; i < newprobs.size(); i++) {
                int value = newprobs.get(i);
                if (value > random) {
                    return i;
                }
            }
        } catch (Exception e) {
            logger.error("计算机率错误" + probs.toString(), e);
        }
        return -1;
    }

    /**
     *
     * @param param 根据总机率返回 一组技能
     * @return
     */
//    public static int[] randomIndexByProb(List<Integer> p, int num) {
//        List<Integer> probs = new ArrayList<>();
//        int[] t = new int[num];
//        try {
//            probs.addAll(p);
//            if (probs.size() < num) {
//                return null;
//            }
//
//            for (int i = 0; i < t.length; i++) {
//                int r = randomIndexByProb(probs);
//                if (r == -1) {
//                    return null;
//                }
//
//                t[i] = r;
//                probs.set(r, 0);
//            }
//        } catch (Exception e) {
//            logger.error("计算机率错误" + probs.toString(), e);
//        }
//        return t;
//    }

    /**
     * @return
     */
    public static Integer[] randomRetIntegerArrByProb(List<Integer[]> probs) {
        try {
            LinkedList<Integer> newprobs = new LinkedList<Integer>();
            //[0,0,0,0,0,0,0,0,10000]
            for (int i = 0; i < probs.size(); i++) {
//				if (probs.get(i) > 0) {
                if (i == 0) {
                    newprobs.add(probs.get(i)[0]);
                } else {
                    newprobs.add(newprobs.get(i - 1) + probs.get(i)[0]);
                }
//				}
            }
            if (newprobs.size() <= 0) {
                return null;
            }
            int last = newprobs.getLast();
            if (last == 0) {
                return null;
            }
//			String[] split = last.split(Symbol.XIAHUAXIAN_REG);
            int random = random(last);
            for (int i = 0; i < newprobs.size(); i++) {
                int value = newprobs.get(i);
//				String[] split2 = string.split(Symbol.XIAHUAXIAN_REG);
//				if(Integer.parseInt(split2[1])>random){
                if (value > random) {
                    return probs.get(i);
                }
            }
        } catch (Exception e) {
            logger.error("计算机率错误" + probs.toString(), e);
        }
        return null;
    }

    /**
     * 根据配置的几率map，随机出来指定数量随机数据
     *
     * @param probs <obj,prob>
     * @param num
     * @return
     */
    public static <T> List<T> randomListByProb(Map<T, Integer> probs, int num) {
        List<T> results = new ArrayList<>();
        if (probs.size() >= num) {
            try {
                List<T> objectList = new ArrayList<>();
                List<Integer> probList = new ArrayList<>();
                for (Map.Entry<T,Integer> entry : probs.entrySet()) {
                    if ( entry.getValue() > 0) {
                        objectList.add(entry.getKey());
                        probList.add(entry.getValue());
                    }
                }
                int randomNum = 0;
                while (!probList.isEmpty() && results.size() < num && randomNum < num) {
                    int index = randomIndexByProb(probList);
                    if (index >= 0) {
                        results.add(objectList.remove(index));
                        probList.remove(index);
                    }
                }
            } catch (Exception e) {
                logger.error("计算机率错误" + probs.toString(), e);
            }
        }
        return results;
    }

    /**
     * 根据配置的几率map，随机出来指定数量随机数据
     *
     * @param probs <obj,prob>
     * @param num
     * @return
     */
    public static List<Object> randomObjectListByProb(Map<Object, Integer> probs, int num) {
        List<Object> results = new ArrayList<>();
        if (probs.size() >= num) {
            try {
                List<Object> objectList = new ArrayList<>();
                List<Integer> probList = new ArrayList<>();
                for (Map.Entry entry : probs.entrySet()) {
                    objectList.add(entry.getKey());
                    probList.add((Integer) entry.getValue());
                }
                int randomNum = 0;
                while (!probList.isEmpty() && results.size() < num && randomNum < num) {
                    int index = randomIndexByProb(probList);
                    if (index >= 0) {
                        results.add(objectList.remove(index));
                        probList.remove(index);
                    }
                }
            } catch (Exception e) {
                logger.error("计算机率错误" + probs.toString(), e);
            }
        }
        if (results.size() != num) {
            results.clear();
        }
        return results;
    }

    public static boolean randomBool(){
        return ThreadLocalRandom.current().nextBoolean();
    }

}
