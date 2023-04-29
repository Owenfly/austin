package com.zust.austin.support.service;


/**
 * 读取配置服务
 *
 * @author wlp
 */
public interface ConfigService {


    String getProperty(String key, String defaultValue);

}
