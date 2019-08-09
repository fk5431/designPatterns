package com.fk5431.leetcode;

import java.util.*;

/**
 * @author: fengk
 * @description: *
 * @create: 2019-08-09 11:13
 **/
//设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
//
//get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
//put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，
// 它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
//
//进阶：
//你是否可以在 O(1) 时间复杂度内执行两项操作？
//
//示例：
//
//LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回 1
//cache.put(3, 3);    // 去除 key 2
//cache.get(2);       // 返回 -1 (未找到key 2)
//cache.get(3);       // 返回 3
//cache.put(4, 4);    // 去除 key 1
//cache.get(1);       // 返回 -1 (未找到 key 1)
//cache.get(3);       // 返回 3
//cache.get(4);

public class LFUCache {

    Map<Integer, Integer> cache = new HashMap<>();

    Map<Integer, HitRate> count = new HashMap<>();

    int capacity = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.get(key) == null) {
            return -1;
        }
        addHitCount(key);
       return cache.get(key);
    }

    public void put(int key, int value) {
        if(capacity <=0) {
            return;
        }
        HitRate hitRate = count.get(key);
        if (hitRate == null) {
            if (cache.size() == capacity) {
                removeElement();
            }
            count.put(key, new HitRate(key, 1, System.nanoTime()));
        } else {
            addHitCount(key);
        }
        cache.put(key, value);
    }

    private void addHitCount(int key) {
        HitRate hitRate = count.get(key);
        count.put(key, new HitRate(key, hitRate.hitCount+1, System.nanoTime()));
    }

    private void removeElement() {
        HitRate hitRate = Collections.min(count.values());
        cache.remove(hitRate.key);
        count.remove(hitRate.key);
    }

    //内部类
    class HitRate implements Comparable<HitRate> {
        private int key;
        private int hitCount;
        private long lastTime;

        private HitRate(int key, int hitCount, long lastTime) {
            this.key = key;
            this.hitCount = hitCount;
            this.lastTime = lastTime;
        }

        @Override
        public int compareTo(HitRate o) {
            int compare = Integer.compare(this.hitCount, o.hitCount);
            return compare == 0 ? Long.compare(this.lastTime, o.lastTime) : compare;
        }
    }

//    ["LFUCache","put","put","get","get","put","get","get","get"]
//      [[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(2, 1);
        lfuCache.put(3, 2);
        System.out.println(lfuCache.get( 3)); //2
        System.out.println(lfuCache.get( 2)); //1
        lfuCache.put(4, 3);
        System.out.println(lfuCache.get(2)); //1
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }
}

//[null,null,-1,null,-1,-1,-1,null,-1,null,null,null,null,null,null,280,null,null,-1,null,null,null,null,null,null,null,-1,null,null,null,null,null,null,261,null,null,-1,null,-1,null,-1,null,null,-1,null,null,null,-1,38,null,null,-1,null,-1,-1,148,-1,null,-1,null,null,null,-1,null,null,-1,-1,-1,null,null,null,null,-1,-1,136,-1,null,-1,null,-1,null,null,-1,-1,153,-1,-1,-1,null,null,-1,-1,null,-1,null,null,-1,-1,null,null,null,null,null,-1,null,-1,160,null,51,null,null,null,null,-1,null,null,null,null,218,-1,261,-1,null,null,-1,-1,null,null,null,null,null,null,null,193,null,null,-1,-1,null,null,null,null,null,null,null,null,null,null,null,220,null,-1,-1,-1,null,null,null,null,null,-1,null,null,306,null,null,219,null,-1,null,-1,null,266,193,90,-1,null,-1,147,-1,null,null,null,148,147,131,null,null,null,null,-1,291,291,null,-1,178,-1,136,null,-1,null,null,147,-1,null,null,287,-1,null,null,null,-1,null,-1,183,null,null,null,174,null,110,null,-1,null,-1,null,-1,null,null,12,null,null,-1,null,89,305,null,70,-1,94,null,-1,null,null,null,null,-1,241,null,176,null,220,null,-1,null,306,-1,183,-1,12,null,null,-1,null,95,null,null,-1,-1,null,311,111,null,190,null,null,84,null,null,-1,-1,null,null,177,157,null,-1,null,null,-1,null,null,null,174,null,null,51,183,-1,4,null,null,-1,-1,null,null,21,null,null,null,null,51,null,176,null,89,-1,null,-1,null,null,176,313,null,86,null,null,229,null,176,null,null,null,null,294,110,101,null,null,null,null,128,49,null,null,82,null,null,193,null,null,193,null,null,null,null,null,-1,85,null,null,null,101,null,126,66,null,null,-1,null,null,null,null,null,-1,null,-1,67,null,66,null,null,126,101,null,null,null,null,null,null,84,null,184,23,198,110,null,101,null,null,130,null,131,null,null,130,null,null,null,null,null,null,null,null,null,null,null,239,null,35,null,-1,null,null,null,287,null,-1,240,null,313,67,null,236,null,null,121,239,299,101,105,null,null,null,118,null,160,null,135,255,-1,null,11,null,null,null,101,258,-1,35,null,null,null,null,null,null,88,160,null,null,11,null,null,276,null,291,299,90,75,null,291,276,118,null,-1,121,null,null,252,null,null,null,null,145,null,null,191,null,null,null,null,null,-1,null,null,null,null,null,null,null,75,null,null,null,null,null,null,-1,23,null,-1,-1,177,165,311,null,null,null,null,null,null,null,184,null,null,309,null,100,null,null,151,null,null,109,null,null,-1,90,136,299,null,null,null,173,173,null,-1,null,null,null,null,-1,null,null,313,45,null,null,null,null,null,null,null,null,null,252,-1,null,null,212,null,null,null,null,132,null,94,137,null,308,null,15,null,null,null,null,-1,null,null,-1,null,null,288,null,null,82,2,null,null,22,null,null,null,null,-1,299,137,null,null,295,null,-1,null,null,null,null,13,null,null,null,null,101,-1,null,null,249,190,null,null,null,null,-1,null,null,null,136,-1,151,null,null,null,null,203,null,90,88,null,null,null,null,null,190,160,null,null,null,40,null,null,null,null,24,null,null,132,30,null,null,236,-1,null,null,67,null,null,null,null,119,-1,24,132,null,1,-1,null,null,null,236,236,null,null,-1,15,183,null,311,295,183,null,-1,188,47,null,null,null,null,311,null,null,null,53,256,null,144,null,null,268,44,null,188,233,1,191,null,null,null,null,null,null,null,null,275,-1,null,null,null,53,null,138,118,146,null,null,279,null,null,null,null,null,null,175,null,null,null,null,53,null,null,-1,null,305,null,44,null,250,null,132,null,null,null,88,null,111,301,102,-1,237,null,null,null,301,null,null,null,-1,13,null,null,null,null,-1,null,null,null,null,null,null,215,-1,null,null,null,null,null,null,233,null,null,null,311,-1,null,null,null,null,null,null,null,null,null,230,null,null,76,188,-1,264,null,null,-1,null,-1,41,-1,null,null,null,null,null,null,null,24,-1,null,null,null,null,null,47,104,null,null,287,null,24,null,null,null,93,null,-1,null,295,69,null,-1,-1,48,null,null,null,null,-1,null,290,null,null,null,null,null,null,41,null,null,283,null,null,287,null,null,null,null,-1,null,null,299,203,null,null,null,null,296,null,13,null,null,null,null,null,null,null,null,null,276,null,null,null,null,1,-1,98,null,240,250,null,null,null,null,133,null,-1,305,-1,null,175,55,null,266,null,-1,null,null,120,null,157,116,71,-1,null,null,-1,null,283,3,-1,102,null,null,null,-1,null,240,null,-1,null,286,50,null,101,299,null,null,null,null,301,-1,null,null,null,227,null,132,null,null,144,null,279,null,71,null,68,157,null,52,24,null,null,null,268,null,null,197,3,null,25,null,54,null,null,-1,271]
//[null,null,-1,null,-1,-1,-1,null,-1,null,null,null,null,null,null,280,null,null,-1,null,null,null,null,null,null,null,-1,null,null,null,null,null,null,261,null,null,-1,null,-1,null,-1,null,null,-1,null,null,null,-1,38,null,null,-1,null,-1,-1,148,-1,null,-1,null,null,null,-1,null,null,-1,-1,-1,null,null,null,null,-1,-1,136,-1,null,-1,null,-1,null,null,-1,-1,153,-1,-1,-1,null,null,-1,-1,null,-1,null,null,-1,-1,null,null,null,null,null,-1,null,-1,160,null,51,null,null,null,null,-1,null,null,null,null,218,-1,261,-1,null,null,-1,-1,null,null,null,null,null,null,null,193,null,null,-1,-1,null,null,null,null,null,null,null,null,null,null,null,220,null,-1,-1,-1,null,null,null,null,null,-1,null,null,306,null,null,219,null,-1,null,-1,null,266,193,90,-1,null,-1,147,-1,null,null,null,148,147,131,null,null,null,null,-1,291,291,null,-1,178,-1,136,null,-1,null,null,147,-1,null,null,287,-1,null,null,null,-1,null,-1,183,null,null,null,174,null,110,null,-1,null,-1,null,-1,null,null,12,null,null,-1,null,89,305,null,70,-1,94,null,-1,null,null,null,null,-1,241,null,176,null,220,null,-1,null,306,-1,183,-1,12,null,null,-1,null,95,null,null,-1,-1,null,311,111,null,190,null,null,84,null,null,-1,-1,null,null,177,157,null,-1,null,null,-1,null,null,null,174,null,null,51,183,-1,4,null,null,-1,-1,null,null,21,null,null,null,null,51,null,176,null,89,-1,null,-1,null,null,176,313,null,86,null,null,229,null,176,null,null,null,null,294,110,101,null,null,null,null,128,49,null,null,82,null,null,193,null,null,193,null,null,null,null,null,-1,85,null,null,null,101,null,126,66,null,null,-1,null,null,null,null,null,-1,null,-1,67,null,66,null,null,126,101,null,null,null,null,null,null,84,null,184,23,198,110,null,101,null,null,130,null,131,null,null,130,null,null,null,null,null,null,null,null,null,null,null,239,null,35,null,-1,null,null,null,287,null,-1,240,null,313,67,null,236,null,null,121,239,299,101,105,null,null,null,118,null,160,null,135,255,-1,null,11,null,null,null,101,258,-1,35,null,null,null,null,null,null,88,160,null,null,11,null,null,276,null,291,299,90,75,null,291,276,118,null,-1,121,null,null,252,null,null,null,null,145,null,null,191,null,null,null,null,null,-1,null,null,null,null,null,null,null,75,null,null,null,null,null,null,-1,23,null,139,-1,177,165,311,null,null,null,null,null,null,null,184,null,null,309,null,100,null,null,151,null,null,109,null,null,-1,90,136,299,null,null,null,173,173,null,-1,null,null,null,null,-1,null,null,313,45,null,null,null,null,null,null,null,null,null,252,-1,null,null,212,null,null,null,null,132,null,-1,137,null,308,null,15,null,null,null,null,-1,null,null,-1,null,null,288,null,null,-1,2,null,null,22,null,null,null,null,-1,299,137,null,null,295,null,139,null,null,null,null,13,null,null,null,null,101,-1,null,null,249,190,null,null,null,null,-1,null,null,null,136,-1,151,null,null,null,null,203,null,90,88,null,null,null,null,null,190,160,null,null,null,40,null,null,null,null,24,null,null,132,30,null,null,236,-1,null,null,67,null,null,null,null,119,-1,24,132,null,1,-1,null,null,null,236,236,null,null,-1,15,183,null,311,295,183,null,-1,188,47,null,null,null,null,311,null,null,null,53,256,null,144,null,null,268,44,null,188,233,1,191,null,null,null,null,null,null,null,null,275,-1,null,null,null,53,null,138,118,146,null,null,279,null,null,null,null,null,null,175,null,null,null,null,53,null,null,-1,null,305,null,44,null,250,null,132,null,null,null,88,null,111,301,102,-1,-1,null,null,null,301,null,null,null,-1,13,null,null,null,null,-1,null,null,null,null,null,null,215,-1,null,null,null,null,null,null,233,null,null,null,311,-1,null,null,null,null,null,null,null,null,null,230,null,null,76,188,-1,264,null,null,-1,null,-1,41,-1,null,null,null,null,null,null,null,24,-1,null,null,null,null,null,47,104,null,null,287,null,24,null,null,null,93,null,-1,null,295,69,null,-1,-1,48,null,null,null,null,-1,null,-1,null,null,null,null,null,null,41,null,null,283,null,null,287,null,null,null,null,-1,null,null,299,203,null,null,null,null,296,null,13,null,null,null,null,null,null,null,null,null,276,null,null,null,null,1,-1,98,null,240,250,null,null,null,null,133,null,-1,305,-1,null,175,55,null,266,null,-1,null,null,-1,null,157,116,71,-1,null,null,-1,null,283,3,-1,102,null,null,null,106,null,240,null,-1,null,286,50,null,101,299,null,null,null,null,301,-1,null,null,null,227,null,132,null,null,144,null,279,null,71,null,68,157,null,52,24,null,null,null,268,null,null,197,3,null,25,null,54,null,null,-1,271]