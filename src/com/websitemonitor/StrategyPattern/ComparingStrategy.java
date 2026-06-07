package com.websitemonitor.StrategyPattern;

//Strategy interface for website comparison algorithms
public interface ComparingStrategy {
    boolean compare(String oldContent, String newContent );
}
