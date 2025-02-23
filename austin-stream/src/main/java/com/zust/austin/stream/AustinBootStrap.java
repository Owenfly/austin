package com.zust.austin.stream;

import com.zust.austin.common.domain.AnchorInfo;
import com.zust.austin.stream.constants.AustinFlinkConstant;
import com.zust.austin.stream.function.AustinFlatMapFunction;
import com.zust.austin.stream.sink.AustinSink;
import com.zust.austin.stream.utils.MessageQueueUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * flink启动类
 *
 */
@Slf4j
public class AustinBootStrap {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        /**
         * 获取KafkaConsumer
         */
        KafkaSource<String> kafkaConsumer = MessageQueueUtils.getKafkaConsumer(AustinFlinkConstant.TOPIC_NAME, AustinFlinkConstant.GROUP_ID, AustinFlinkConstant.BROKER);
        DataStreamSource<String> kafkaSource = env.fromSource(kafkaConsumer, WatermarkStrategy.noWatermarks(), AustinFlinkConstant.SOURCE_NAME);


        /**
         * 数据转换处理
         */
        SingleOutputStreamOperator<AnchorInfo> dataStream = kafkaSource.flatMap(new AustinFlatMapFunction()).name(AustinFlinkConstant.FUNCTION_NAME);

        /**
         * 将实时数据多维度写入Redis
         */
        dataStream.addSink(new AustinSink()).name(AustinFlinkConstant.SINK_NAME);
        env.execute(AustinFlinkConstant.JOB_NAME);

    }

}
