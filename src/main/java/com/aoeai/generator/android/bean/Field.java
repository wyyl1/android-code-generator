package com.aoeai.generator.android.bean;

/**
 * 自动生成的字段
 * @author aoe
 * @date 2016/3/27
 * @tags
 */
public class Field {

    /**
     * 字段类型
     */
    private String type;

    /**
     * xml中原始id值
     */
    private String original;

    /**
     * 类型合并后的变量
     */
    private String mergeValues;

    public String getType() {
        return type;
    }

    public Field setType(String type) {
        this.type = type;
        return this;
    }

    public String getOriginal() {
        return original;
    }

    public Field setOriginal(String original) {
        this.original = original;
        return this;
    }

    public String getMergeValues() {
        return mergeValues;
    }

    public Field setMergeValues(String mergeValues) {
        this.mergeValues = mergeValues;
        return this;
    }
}
