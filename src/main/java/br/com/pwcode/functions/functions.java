package br.com.pwcode.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class functions {

    public String simpleAddress(String address) {

        String[] wordsArray = address.split("\\s+");
        List<String> listOfWords = Arrays.asList(wordsArray);
        List<String> addressResponse = new ArrayList<>();

        if (isForeignAddress(listOfWords) != 0){
            addressResponse = ForeignAddress(listOfWords, isForeignAddress(listOfWords));
        }
        else if (listOfWords.size() == 2){
            addressResponse = listOfWords;
        } else {
            addressResponse = biggerAddress(listOfWords);
        }

        return String.format("{\"%s\", \"%s\"}", addressResponse.get(0), addressResponse.get(1));
    }

    public List<String> biggerAddress(List<String> listOfWords) {
        List<String> biggerAddresses = new ArrayList<>();
        String number = "";
        String name = "";
        Boolean alreadyNum = false;

        for (String word : listOfWords) {
            if (containsNumber(word) || alreadyNum) {
                number += " " + word;
                alreadyNum = true;
            } else {
                name += " " + word;
            }
        }
        name = name.strip();
        number = number.strip();
        biggerAddresses.add(name);
        biggerAddresses.add(number);
        
        return biggerAddresses;
    }

    public List<String> ForeignAddress(List<String> listOfWords, int num) {
        List<String> ForeignAddress = new ArrayList<>();
        String number = "";
        String name = "";
        int c = 0;
        switch(num){
            case 1:
                number = listOfWords.get(0).replace(",", "");
                for (int i = 1; i < listOfWords.size(); i++){
                    name += " " + listOfWords.get(i);
                }
                name = name.strip();
                ForeignAddress.add(name);
                ForeignAddress.add(number);
                break;
            case 2:
                number = listOfWords.get(0);
                for (int i = 1; i < listOfWords.size(); i++){
                    name += " " + listOfWords.get(i);
                }
                name = name.strip();
                ForeignAddress.add(name);
                ForeignAddress.add(number);
                break;
            case 3:
                for (int i = 0; i < listOfWords.size(); i++){
                    if(listOfWords.get(i).contains(",")){
                        name += " " + listOfWords.get(i);
                        c = i + 1;
                        break;
                    } else {
                        name += " " + listOfWords.get(i); 
                    }
                }
                while(c < listOfWords.size()) {
                    number += " " + listOfWords.get(c);
                    c++;
                }
                name = name.strip().replace(",", "");
                number = number.strip();
                ForeignAddress.add(name);
                ForeignAddress.add(number);
                break;
            case 4:
                for (int i = 0; i < listOfWords.size(); i++){
                    if(listOfWords.get(i).contains("No")){
                        c = i;
                        break;
                    } else {
                        name += " " + listOfWords.get(i); 
                    }
                }
                while(c < listOfWords.size()) {
                    number += " " + listOfWords.get(c);
                    c++;
                }
                name = name.strip().replace(",", "");
                number = number.strip();
                ForeignAddress.add(name);
                ForeignAddress.add(number);
                break;
            
        }
        return ForeignAddress;
    }

    public int isForeignAddress(List<String> listOfWords) {
        for (String word : listOfWords) {
            if (containsNumber(word) && listOfWords.get(0).equals(word) && listOfWords.get(0).contains(",")){
                return 1;
            }
            else if (containsNumber(word) && listOfWords.get(0).equals(word)) {
                return 2;
            }
            else if (word.contains(",")) {
                return 3;
            }
            else if (word.equals("No")) {
                return 4;
            }
        }
        return 0;
    }

    public boolean containsNumber(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    
}
