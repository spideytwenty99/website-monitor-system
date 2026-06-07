package com.websitemonitor.StrategyPattern;

//Concrete Strategy that compares visible text content
public class ComparingContentSize implements ComparingStrategy{
    @Override
    public boolean compare(String oldContent, String newContent) {
       int oldSize= oldContent.length();
       int newSize= newContent.length();

       if (!(oldSize==newSize)){
           System.out.println("Content Size has been updated");
           return true;

       }
        System.out.println("Content Size is the same");
       return false;
    }
}
