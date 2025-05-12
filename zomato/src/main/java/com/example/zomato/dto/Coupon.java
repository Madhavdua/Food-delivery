package com.example.zomato.dto;

public class Coupon {
    private String code[];
    private String description[];

    public Coupon() {
        code=new String[]{"T20","GET200", "Fifty50"};
        description=new String[]{"20% Off upto Rs100","30% Off upto Rs200","50% Off upto Rs300",};
    }
    public int getDiscount(int amt){
        if(amt<500){
            return Math.min(100,(int)Math.floor(.2*amt));
        }
        else if(amt<1000){
            return Math.min(200,(int)Math.floor(.3*amt));
        }
        return Math.min(300,(int)Math.floor(.5*amt));
    }

    public String[] getCode() {
        return code;
    }

    public String[] getDescription() {
        return description;
    }
}
