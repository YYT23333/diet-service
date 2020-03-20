package com.hs.diet.exception;

import com.hs.diet.response.WrongResponse;

public class NotExistException extends Exception{
    private WrongResponse wrongResponse;
    public NotExistException(String type, Long id){
        super(type+id+",Not Exist!");
        wrongResponse=new WrongResponse(10001,this.getMessage());
    }
}