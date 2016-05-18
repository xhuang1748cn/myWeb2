package cn.srn.web2.httpUtil;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Winter on 2016/4/6.
 */
@SuppressWarnings("unchecked")
public class CollectionsUtil {

    public static <K, V> K[] mapKeyToArray(Map<K, V> map, Class<K> clazz) {
        K[] array = (K[]) Array.newInstance(clazz, map.size());
        return map.keySet().toArray(array);
    }

    public static <K, V> V[] mapValueToArray(Map<K, V> map, Class<V> clazz) {
        V[] array = (V[]) Array.newInstance(clazz, map.size());
        return map.values().toArray(array);
    }

    public static <T> T[] listToArray(List<T> list, Class<T> clazz) {
        T[] array = (T[]) Array.newInstance(clazz, list.size());
        return list.toArray(array);
    }

    public static <T> T[] setToArray(Set<T> set, Class<T> clazz) {
        T[] array = (T[]) Array.newInstance(clazz, set.size());
        return set.toArray(array);
    }
}
