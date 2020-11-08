package com.zhicheng.service;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AlgoTest {

    @Test
    public void algo1() throws Exception {
        ArrayList<Integer> numbers = Lists.newArrayList(9,10,8,6,5,1,4);
        for(int j = 0; j<numbers.size();j++) {
            int minIndex = j;
            for(int i=j+1; i<numbers.size(); i++) {
                if( numbers.get(i).compareTo(numbers.get(minIndex)) == -1 ) {
                    minIndex = i;
                }
            }
            int temp = numbers.get(j);
            numbers.set(j, numbers.get(minIndex));
            numbers.set(minIndex, temp);
        }

        for(int x : numbers) {
            System.out.print(x+ " ");
        }


    }
}
