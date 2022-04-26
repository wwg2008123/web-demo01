package com.wwg.webdemo01.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.MappedByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author panjingtian
 * @description 获取对象完整性校验工具类
 * @date 2019/12/2 1:47 PM
 */
@Slf4j
public class FileFullUtil {

    /**
     * 目前只做md5
     * 需要sha校验等     引入    org.apache.commons.codec.digest.DigestUtils 包
     * 引入
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static String md5(InputStream inputStream) throws IOException {
        return DigestUtils.md5DigestAsHex(inputStream);
    }

    /**
     * 获取流大小 单位MB
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static <teArrayOutputStream> String file_sizeMB(InputStream inputStream) throws IOException {
        Class<? extends ByteArrayInputStream> aClass = ((ByteArrayInputStream) inputStream).getClass();
        Field field = null;
        Integer count = 0;
        try {
            field = aClass.getDeclaredField("count");
            field.setAccessible(true);
            count = (Integer) field.get(inputStream);
        } catch (Exception e) {
            log.warn("计算大小异常e={}", e);
        }
        BigDecimal mb = new BigDecimal(count).divide(new BigDecimal(1000 * 1000), 2, BigDecimal.ROUND_DOWN);
        return mb.toString();
    }

    /**
     * 在MappedByteBuffer释放后再对它进行读操作的话就会引发jvm crash，在并发情况下很容易发生
     * 正在释放时另一个线程正开始读取，于是crash就发生了。所以为了系统稳定性释放前一般需要检 查是否还有线程在读或写
     *
     * @param mappedByteBuffer
     */
    public static void freedMappedByteBuffer(final MappedByteBuffer mappedByteBuffer) {
        try {
            if (mappedByteBuffer == null) {
                return;
            }

            mappedByteBuffer.force();
            AccessController.doPrivileged(new PrivilegedAction<Object>() {
                @Override
                public Object run() {
                    try {
                        Method getCleanerMethod = mappedByteBuffer.getClass().getMethod("cleaner", new Class[0]);
                        getCleanerMethod.setAccessible(true);
                        sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod.invoke(mappedByteBuffer,
                                new Object[0]);
                        cleaner.clean();
                    } catch (Exception e) {
                        log.error("clean MappedByteBuffer error!!!", e);
                    }
                    return null;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
