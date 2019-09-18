package com.dg.dynamiccoupoun;

import java.util.ArrayList;

/**
 * @Author: heting
 * @Date: 2019/6/26 下午2:56
 */
public class CoupounOptimization {
    /** 用户所有可用的返现券 */
    private Coupoun[] coupouns;
    /** 用户可以使用返现券的总金额 */
    private int totalCondiition;
    /** 用户所有可用的返现券的数量 */
    private int n;
    /** 前N张返现券得到的最优解的矩阵组合 */
    private int[][] optimizeValues;
    public int[][] getOptimizeValues() {
        return optimizeValues;
    }
    /** 最优返现券的返现总额 */
    private int optimizeValue;
    public int getOptimizeValue() {
        return optimizeValue;
    }
    /** 最优返现券的的组合方案 */
    private ArrayList<Coupoun> optimizeCoupounSolution;
    public ArrayList<Coupoun> getOptimizeCoupounSolution() {
        return optimizeCoupounSolution;
    }

    public CoupounOptimization(Coupoun[] coupouns, int totalCondiition){
        this.coupouns = coupouns;
        this.totalCondiition = totalCondiition;
        this.n = coupouns.length;
        if (optimizeValues == null){
            optimizeValues = new int[n+1][totalCondiition + 1];
        }
    }

    /**
     *  获取前N张返现券，使得用户的返现金额达到最大，并给出最优返现券的组合
     */
    public void optimize(){
        for (Coupoun coupoun: coupouns){
            System.out.println(coupoun);
        }
        // 优惠券最优方案
        for (int j = 0; j <= totalCondiition; j++){
            for (int i = 0; i<=n; i++){
                // 边界值约定
                if (i == 0 || j == 0){
                    optimizeValues[i][j] = 0;
                }else {
                    // 如果第 i 张返现券使用门槛不大于总金额，则最优解要么是包含第 i 张返现券的最优解，
                    // 要么是不包含第 i 张返现券的最优解， 取两者最大值
                    // 第 i 张返现券的限额 icondition 和价值 iCoupounValue
                    if (j > coupouns[i-1].getCoupounCondition()){
                        int iCondition = coupouns[i-1].getCoupounCondition();
                        int iCoupounValue = coupouns[i-1].getCoupounValue();
                        optimizeValues[i][j] = Math.max(optimizeValues[i-1][j],optimizeValues[i-1][j-iCondition] + iCoupounValue);
                    }else {
                        // 如果第 i 张返现券的使用门槛大于总金额，则最优解存在于其他 i-1 张返现券中，
                        // 注意：第 i 张返现券是 coupouns[i-1]
                        optimizeValues[i][j] = optimizeValues[i-1][j];
                    }
                }

            }
        }
        // 最优返现券组成
        if (optimizeCoupounSolution == null){
            optimizeCoupounSolution = new ArrayList<Coupoun>();
        }
        int tempCondition = totalCondiition;
        for (int i = n; i >= 1; i--){
            if (optimizeValues[i][tempCondition] > optimizeValues[i-1][tempCondition]){
                optimizeCoupounSolution.add(coupouns[i-1]);
                tempCondition -= coupouns[i-1].getCoupounCondition();
            }
            if (tempCondition == 0){
                break;
            }
        }
        //最优返现总额
        optimizeValue = optimizeValues[n][totalCondiition];
    }
}
