package com.dg.dynamiccoupoun;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: heting
 * @Date: 2019/6/26 下午3:48
 */
public class CoupounTest {

    public static void main(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒SSS毫秒");
        Date date = new Date();
        System.out.println("-----------最优解算法开始计时-----------"+dateFormat.format(date));

        Coupoun[] coupouns = new Coupoun[]{
                new Coupoun(201,2000, 10), new Coupoun(11,3000, 10),
                new Coupoun(123,1500, 10), new Coupoun(26,5000, 20),
                new Coupoun(24,1000, 10), new Coupoun(58,8000, 50),
                new Coupoun(31,20000, 80), new Coupoun(91, 120000, 200),
                new Coupoun(201,2000, 10), new Coupoun(11,3000, 10),
                new Coupoun(123,1500, 10), new Coupoun(26,5000, 20),
                new Coupoun(24,1000, 10), new Coupoun(58,8000, 50),
                new Coupoun(31,20000, 80), new Coupoun(91, 120000, 200),
                new Coupoun(201,2000, 10), new Coupoun(11,3000, 10),
                new Coupoun(123,1500, 10), new Coupoun(26,5000, 20),
                new Coupoun(24,1000, 10), new Coupoun(58,8000, 50),
                new Coupoun(31,20000, 80), new Coupoun(91, 120000, 200),
                new Coupoun(201,2000, 10), new Coupoun(11,3000, 10),
                new Coupoun(123,1500, 10), new Coupoun(26,5000, 20),
                new Coupoun(24,1000, 10), new Coupoun(58,8000, 50),
                new Coupoun(31,20000, 80), new Coupoun(91, 120000, 200),
                new Coupoun(201,2000, 10), new Coupoun(11,3000, 10),
                new Coupoun(123,1500, 10), new Coupoun(26,5000, 20),
                new Coupoun(24,1000, 10), new Coupoun(58,8000, 50),
                new Coupoun(31,20000, 80), new Coupoun(91, 120000, 200)
        };
        int totalCondition = 100000;

        CoupounOptimization cOpti = new CoupounOptimization(coupouns, totalCondition);
        cOpti.optimize();
        System.out.println(" -------- 该背包问题实例的解: --------- ");
        System.out.println("最优值：" + cOpti.getOptimizeValue());
        System.out.println("最优解【选取的返现券】: ");
        System.out.println(cOpti.getOptimizeCoupounSolution());
        /*System.out.println("最优值矩阵：");
        int[][] bestValues = cOpti.getOptimizeValues();
        for (int i=0; i < bestValues.length; i++) {
            for (int j=0; j < bestValues[i].length; j++) {
                System.out.printf("%-5d", bestValues[i][j]);
            }
            System.out.println();
        }*/

        Date now = new Date();
        System.out.println("-----------最优解算法结束-----------"+dateFormat.format(now));

    }

}
