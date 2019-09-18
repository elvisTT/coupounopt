package com.dg.dynamiccoupoun;

/**
 * @Author: heting
 * @Date: 2019/6/26 下午2:37
 */
public class Coupoun {

    /** 返现券ID */
    private int coupounId;

    /** 返现券条件 */
    private int coupounCondition;

    /** 返现券价值 */
    private int coupounValue;

    /**
     * 构造器
     */
    public Coupoun(int coupounId, int coupounCondition, int coupounValue){
        this.coupounId = coupounId;
        this.coupounCondition = coupounCondition;
        this.coupounValue = coupounValue;
    }

    public int getCoupounId(){
        return coupounId;
    }


    public int getCoupounCondition(){
        return coupounCondition;
    }


    public int getCoupounValue(){
        return coupounValue;
    }

    @Override
    public String toString() {
        return  "[返现券ID为: " + coupounId + "；" + "返现券限额为: " + coupounCondition + "；"+
                "返现金额是：" + coupounValue  +     "]";
    }
}
