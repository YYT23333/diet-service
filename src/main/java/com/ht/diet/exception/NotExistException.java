package com.ht.diet.exception;

import com.ht.diet.response.WrongResponse;

public class NotExistException extends Exception{
    private WrongResponse wrongResponse;
    public NotExistException(String type, long id){
        super(type+id+",Not Exist!");
        wrongResponse=new WrongResponse(500,this.getMessage());
    }
}
