package com.zkpt.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.zkpt.middleware.entity.CombinationIndex;
import com.zkpt.middleware.entity.MyConstant;

public class TrickUitl {
    public static String reply_resp_combination(Object obj) {
        StringBuffer sb = new StringBuffer();
        Map<Integer, Field> oldMap = new HashMap<Integer, Field>();
        Field[] fields = obj.getClass().getDeclaredFields();

        // 1.获得类的每个属性放到临时map中
        for (Field field : fields) {
            if (field.isAnnotationPresent(CombinationIndex.class)) {
                CombinationIndex name = (CombinationIndex) field.getAnnotation(CombinationIndex.class);
                oldMap.put(name.index(), field);
            }
        }

        // 2.排序得到TreeMap
        Map<Integer, Field> newMap = sortMapByKey(oldMap);


        // 3.根据反射和注解组装数据
        try {
            Iterator<Entry<Integer, Field>> titer = newMap.entrySet().iterator();
            while (titer.hasNext()) {
                Map.Entry<Integer, Field> ent = (Map.Entry<Integer, Field>) titer.next();
                Field field = (Field) ent.getValue();

                Method method = obj.getClass().getDeclaredMethod("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
                String fieldCanonicalName = field.getType().getCanonicalName();

                Object val = method.invoke(obj);
                if (fieldCanonicalName.equals("java.lang.Integer") || fieldCanonicalName.equals("java.lang.Double") || fieldCanonicalName.equals("java.lang.Float")
                        || fieldCanonicalName.equals("java.lang.String")) {
                    if (val != null)
                        sb.append(val);
                    sb.append(MyConstant.SPLIT);
                } else if (fieldCanonicalName.equals("java.util.List")) {
                    for (Object o : (List) val) {
                        sb.append(reply_resp_combination(o));
                    }
                }
            }
        } catch (Exception e) {
            return "";
        }

        return sb.toString();
    }

    /**
     * 使用 Map按key进行排序
     * 
     * @param map
     * @return
     */
    public static Map<Integer, Field> sortMapByKey(Map<Integer, Field> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<Integer, Field> sortMap = new TreeMap<Integer, Field>(new ReplyRespCombinationMapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }
}


class ReplyRespCombinationMapKeyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer str1, Integer str2) {
        return str1.compareTo(str2);
    }
}

