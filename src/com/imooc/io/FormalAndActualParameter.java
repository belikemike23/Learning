package com.imooc.io;

/**
 * Created by mike.wang on 2016/11/24.
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FormalAndActualParameter {
    public void a(Map a,String b)
    {
        a.put("test", b);
    }

    public void b()
    {
        Map a = new HashMap();
        a.put("test", "a");
        String b = "b";
//printMap(a);
        a(a,b);
        printMap(a);
    }

    public void printMap(Map a)
    {
        Set set = a.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext())
        {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println("Key:"+e.getKey()+" Value:"+e.getValue());

        }
    }

    public static void main(String avgs[])
    {
        FormalAndActualParameter t = new FormalAndActualParameter();
        t.b();
    }
}
