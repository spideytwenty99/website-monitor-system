package com.websitemonitor.StrategyPattern;


//Concrete Strategy that compares visible text content
public class ComparingTextContent implements ComparingStrategy{
    @Override
    public boolean compare(String oldText,
                           String newText) {

        if (!oldText.equals(newText)) {
            System.out.println(
                    "Text content has been updated"
            );
            return true;
        }

        System.out.println(
                "Text content is identical"
        );

        return false;
    }
}
