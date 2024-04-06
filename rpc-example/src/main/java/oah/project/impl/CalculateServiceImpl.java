package oah.project.impl;

import oah.project.CalculateService;

/**
 * @ClassName CalculateServiceImpl
 * @Description TODO
 * @Author _oah
 * @Date 2024.04.04 14:13
 * @Version 1.0
 */
public class CalculateServiceImpl implements CalculateService {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}
