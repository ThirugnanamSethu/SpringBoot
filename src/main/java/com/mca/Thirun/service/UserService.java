package com.mca.Thirun.service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private String expression="";
    public  String calculate(int val1, int val2, String op){
        int result;

        switch (op){
            case "add":
                result=val1+val2;
                expression=val1+" + "+val2+" = "+result;
                break;
            case "sub":
                result=val1-val2;
                expression=val1+" - "+val2+" = "+result;
                break;
            case "mul":
                result=val1*val2;
                expression=val1+" * "+val2+" = "+result;
                break;
            case "div":
                if (val2==0){
               return "cont divide by zero";
                }
                result=val1/val2;
                expression=val1+" / "+val2+" = "+result;
                break;
            default:
                return "invalid operation";

        }
        return ("Value : "+expression);
    }
    public List<String>getSupportedoperations(){
        return Arrays.asList("add", "sub", "mul", "div", "Last: " );
    }

    public String getExpression() {
//        if (props.isEmpty()){
//            return expression;
//        }
//        expression=props;
        return ("Final Result : "+expression);

    }



}


