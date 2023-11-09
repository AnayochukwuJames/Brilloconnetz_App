package com.Java_Developer_Test.Brilloconnetz.service;

import com.Java_Developer_Test.Brilloconnetz.entity.User;

import com.Java_Developer_Test.Brilloconnetz.util.AppUtil;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class UserServiceImpl{

    public static boolean validateUser(User requestDto) {
        LocalDate currentDate = LocalDate.now();
        Map<String,Boolean> validation= new HashMap<>();
        if(requestDto!=null){

            if(!requestDto.getUserName().equals("")&& requestDto.getUserName().length()>4) {
                validation.put("userName", true);
            }else {
                validation.put("userName", false);
            }
            if(!requestDto.getPassword().equals("")&& AppUtil.isValidPassword(requestDto.getPassword())&&requestDto.getPassword().length()>8) {
                validation.put("password", true);
            }else {
                validation.put("password", false);
            }
            if(!requestDto.getPassword().equals("")&& AppUtil.isValidEmail(requestDto.getEmail())) {
                validation.put("email", true);
            }else {
                validation.put("email", false);

            }
            if (!requestDto.getDateOfBirth().equals(null)&& (Period.between(requestDto.getDateOfBirth(), currentDate).getYears()>=16)){
                validation.put("age",true);
            }else {
                validation.put("age",false);
            }
        }else return false;

        if (!validation.containsValue(false)) {
            return true;
        }else
            writeDetails(validation);
        return false;
    }

    private static void writeDetails(Map<String, Boolean> validation){
            List<String> result= new ArrayList<>();
            for (Map.Entry<String, Boolean> entry:validation.entrySet()){
                if(entry.getValue().equals(false)){
                    String key= entry.getKey();
                    result.add(key+": is invalid");
                }
            }
            for (String s:result){
        System.out.println(s);
    }}
    public static User getUserDetail(){
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.print("Enter your date of birthday pattern = \"yyyy-MM-dd\": ");
        String dateOfBirth = scanner.nextLine();
        return User.builder()
                .userName(name)
                .email(email)
                .password(password)
                .dateOfBirth(LocalDate.parse(dateOfBirth))
                .build();
    }
}
