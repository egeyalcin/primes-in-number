package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(factors(7919));
    }

    public static String factors(int n) {
        List<String> list = new ArrayList<>();
        Double doubleN = Double.valueOf(n);
        Double divisionValue = Double.valueOf(2);
        while(doubleN >= divisionValue) {
            if(doubleN % divisionValue == 0) {
                list.add(String.valueOf(divisionValue.intValue()));
                doubleN = doubleN / divisionValue;
            }else {
                divisionValue++;
            }
        }
        String keepSameValues = list.get(0);
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        if(list.size() == 1) {
            stringBuilder.append("(" + list.get(0) + ")");
        }
        for(int i = 1; i < list.size();i++) {
            if(list.get(i).equals(keepSameValues)) {
                count++;
            }else {
                if(count > 0) {
                    int totalCount = count + 1;
                    stringBuilder.append("(" + keepSameValues + "**" + totalCount +  ")");
                }
                else {
                    stringBuilder.append("(" + keepSameValues + ")");
                }
                keepSameValues = list.get(i);
                count = 0;
            }
            if (i == list.size() - 1) {
                if (count > 0) {
                    int totalCount = count + 1;
                    stringBuilder.append("(" + keepSameValues + "**" + totalCount + ")");
                } else {
                    stringBuilder.append("(" + keepSameValues + ")");
                }
            }
        }

        return stringBuilder.toString();
    }
}