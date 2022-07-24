package com.alcor.tobacco.domain.query;

import com.alcor.tobacco.aspectlj.config.MyQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author guchun
 * @description query统一封装方法
 * @date 2022/7/9 00:54
 */
public abstract class BaseQuery<T> implements Serializable {
    private static final long serialVersionUID=1L;
    private static final Logger logger = LoggerFactory.getLogger(BaseQuery.class);

    public static final String eq = "eq"; //等于
    public static final String ne = "ne"; //不等于
    public static final String in = "in"; //in
    public static final String notnull = "notnull"; //不为null
    public static final String isnull = "isnull"; //为null
    public static final String like = "like";  //模糊
    public static final String leftlike = "leftlike"; //%XXX
    public static final String rightlike = "rightlike";  //XXX%
    public static final String notlike = "notlike"; //not like
    public static final String gt = "gt";  //大于
    public static final String lt = "lt";  //小于
    public static final String ge = "ge";  //大于等于
    public static final String le = "le";  //小于等于
    public static final String orderDesc = "orderDesc";
    public static final String orderAsc = "orderAsc";

    /**
     * 查询类
     */
//    @ApiModelProperty(hidden = true)
    private QueryWrapper<T> queryWrapper = new QueryWrapper<>();
    public final QueryWrapper<T> build(){
        return this.queryWrapper;
    }


    /**
     * 生成最终的查询，兼容旧版本，可重写该方法，实现自定义查询 QueryWrapper
     * @return
     */
    public QueryWrapper<T> buildQuery(){
        return annoQuery();
    }

    /**
     * 通过注解的方式注入参数
     * @return
     */
    public final QueryWrapper<T> annoQuery(){
        Class<? extends BaseQuery> cls = this.getClass();
        Field[] fields = cls.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            MyQuery mq = field.getAnnotation(MyQuery.class);
            if(mq!=null){
                field.setAccessible(true);
                // 获取属性的对应的值
                try {
                    Object val = field.get(BaseQuery.this);
                    this.addCondition(mq.value(),mq.column(),val);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        return build();
    }


    /**
     * 添加条件,值为空时会拦截
     * @param type  条件类型
     * @param column  列
     * @param val  值
     */
    public final BaseQuery<T> addCondition(String type, String column, Object val){
        return addCondition(type,column,val,true);
    }

    /**
     * 添加条件
     * @param type  条件类型
     * @param column  列
     * @param val  值
     * @param checkValNull  是否对值验证空，默认验证空
     */
    public final BaseQuery<T> addCondition(String type, String column, Object val, boolean checkValNull){
        if(checkValNull && (val==null
                || ((val instanceof String) && StringUtils.isEmpty((String)val)))
                || ((val instanceof Boolean) && !(Boolean)val)
                || ((val instanceof Collection) && ((Collection) val).size()==0)
        ){
            return this;
        }
        switch (type){
            case in: {
                if(val instanceof String){
                    queryWrapper.in(column,((String)val).split(","));
                }else if(val instanceof Collection){
                    queryWrapper.in(column,(Collection)val);
                }
                break;
            }
            case eq: queryWrapper.eq(column,val);break;
            case ne: queryWrapper.ne(column,val);break;
            case like: queryWrapper.like(column,val);break;
            case leftlike: queryWrapper.likeLeft(column,val);break;
            case rightlike: queryWrapper.likeRight(column,val);break;
            case notlike: queryWrapper.notLike(column,val);break;
            case gt: queryWrapper.gt(column,val);break;
            case lt: queryWrapper.lt(column,val);break;
            case ge: queryWrapper.ge(column,val);break;
            case le: queryWrapper.le(column,val);break;
            case notnull: queryWrapper.isNotNull(column);break;
            case isnull: queryWrapper.isNull(column);break;
            case orderDesc: queryWrapper.orderByDesc(column);break;
            case orderAsc: queryWrapper.orderByAsc(column);break;
        }
        return this;
    }

}
