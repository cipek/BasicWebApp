package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        else if (query.toLowerCase().contains("horse")) {
            return "battery";
        }
        else{
            String[] splited = query.split("\\s+");
//            System.out.println(splited);
            if(query.contains("largest")){
                int max = 0;
                for (int i = 0; i < splited.length; i++) {
                    splited[i] = splited[i].replaceAll(",","");
                    try {
                        double d = Double.parseDouble(splited[i]);
                        if(d > max)
                            max = (int) d;
                    } catch (NumberFormatException | NullPointerException nfe){}
                }
                return max+"";
            }
            else if(query.contains("plus")){
                int sum = 0;
                for (int i = 0; i < splited.length; i++) {
                    try {
                        double d = Double.parseDouble(splited[i]);

                        sum += (int) d;
                    } catch (NumberFormatException | NullPointerException nfe){}
                }
                return sum+"";
            }
            else if(query.contains("multiplied")){
                int multi = -1;
                for (int i = 0; i < splited.length; i++) {
                    try {
                        double d = Double.parseDouble(splited[i]);
                        if(multi == -1){
                            multi = (int) d;
                        }
                        else{
                            multi *= d;
                        }
                    } catch (NumberFormatException | NullPointerException nfe){}
                }
                return multi+"";
            }
        }
        return "";
    }
}
