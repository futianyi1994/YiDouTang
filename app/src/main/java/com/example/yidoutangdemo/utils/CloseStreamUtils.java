package com.example.yidoutangdemo.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/24.
 */

public class CloseStreamUtils {
    public static void close(Closeable closeable)
    {
        if(closeable!=null)
        {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
