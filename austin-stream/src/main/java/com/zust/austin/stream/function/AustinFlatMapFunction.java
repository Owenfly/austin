package com.zust.austin.stream.function;

import com.alibaba.fastjson.JSON;
import com.zust.austin.common.domain.AnchorInfo;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;


public class AustinFlatMapFunction implements FlatMapFunction<String, AnchorInfo> {

    @Override
    public void flatMap(String value, Collector<AnchorInfo> collector) throws Exception {
        AnchorInfo anchorInfo = JSON.parseObject(value, AnchorInfo.class);
        collector.collect(anchorInfo);
    }
}
