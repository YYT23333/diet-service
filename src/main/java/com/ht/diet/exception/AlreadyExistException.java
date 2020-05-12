package com.ht.diet.exception;

import com.ht.diet.response.WrongResponse;

public class AlreadyExistException extends Exception{
    private WrongResponse wrongResponse;
    public AlreadyExistException(){
        super("Already exist！");
        wrongResponse=new WrongResponse(500,this.getMessage());
    }
}
