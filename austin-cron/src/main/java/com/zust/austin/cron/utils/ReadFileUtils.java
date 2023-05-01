package com.zust.austin.cron.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.csv.*;
import com.google.common.base.Throwables;
import com.zust.austin.cron.csv.CountFileRowHandler;
import com.zust.austin.cron.vo.CrowdInfoVo;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.util.*;

/**
 * 读取人群文件 工具类
 */
@Slf4j
public class ReadFileUtils {

    /**
     * csv文件 存储 接收者 的列名
     */
    public static final String RECEIVER_KEY = "userId";

    /**
     * 读取csv文件，每读取一行都会调用 csvRowHandler 对应的方法
     *
     * @param path
     * @param csvRowHandler
     */
    public static void getCsvRow(String path, CsvRowHandler csvRowHandler) {
        try {
            CsvReader reader = CsvUtil.getReader(new FileReader(path),
                    new CsvReadConfig().setContainsHeader(true));
            reader.read(csvRowHandler);
        } catch (Exception e) {
            log.error("ReadFileUtils#getCsvRow fail!{}", Throwables.getStackTraceAsString(e));

        }
    }

    /**
     * 读取csv文件，获取文件里的行数
     *
     * @param path
     * @param countFileRowHandler
     */
    public static long countCsvRow(String path, CountFileRowHandler countFileRowHandler) {
        try {
            // 把首行当做是标题，获取reader
            CsvReader reader = CsvUtil.getReader(new FileReader(path),
                    new CsvReadConfig().setContainsHeader(true));
            reader.read(countFileRowHandler);
        } catch (Exception e) {
            log.error("ReadFileUtils#getCsvRow fail!{}", Throwables.getStackTraceAsString(e));
        }
        return countFileRowHandler.getRowSize();
    }

    /**
     * 从文件的每一行数据获取到params信息
     * [{key:value},{key:value}]
     *
     * @param fieldMap
     * @return
     */
    public static HashMap<String, String> getParamFromLine(Map<String, String> fieldMap) {
        HashMap<String, String> params = MapUtil.newHashMap();
        for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
            if (!ReadFileUtils.RECEIVER_KEY.equals(entry.getKey())) {
                params.put(entry.getKey(), entry.getValue());
            }
        }
        return params;
    }



}
