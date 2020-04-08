package com.ht.diet.controller;

import com.ht.diet.exception.NotExistException;
import com.ht.diet.parameters.DietRecordParameter;
import com.ht.diet.response.*;
import com.ht.diet.service.DietRecordService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diet")
public class DietRecordController {
    @Autowired
    private DietRecordService dietRecordService;

    @ApiOperation(value = "通过id获取饮食记录详情")
    @ApiImplicitParam(name = "id", value = "饮食记录id", required = true, dataType = "long")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = DietRecordDetailResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> findById(@PathVariable long id) throws NotExistException {
        return new ResponseEntity<>(dietRecordService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "通过用户id查找饮食记录")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "long")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = DietRecordListResponse.class)
    })
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Response> findByUser(@PathVariable long userId) {
        return new ResponseEntity<>(dietRecordService.findByUser(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "创建饮食记录")
    @ApiResponse(code = 200, message = "Success", response = AddResponse.class)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Response> add(@RequestBody @ApiParam DietRecordParameter parameter) {
        return new ResponseEntity<>(dietRecordService.add(parameter), HttpStatus.OK);
    }
}