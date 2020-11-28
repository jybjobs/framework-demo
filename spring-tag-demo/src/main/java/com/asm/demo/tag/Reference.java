package com.asm.demo.tag;

import java.util.Arrays;

/**
 * 创建需要扩展的组件
 */
public class Reference {
    private String id;
    private String protocol;
    private String clazz;
    private String[] paramters;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String[] getParamters() {
        return paramters;
    }

    public void setParamters(String[] paramters) {
        this.paramters = paramters;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "id='" + id + '\'' +
                ", protocol='" + protocol + '\'' +
                ", clazz='" + clazz + '\'' +
                ", paramters=" + Arrays.toString(paramters) +
                '}';
    }
}
