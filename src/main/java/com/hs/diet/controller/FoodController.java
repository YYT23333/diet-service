package com.hs.diet.controller;


import com.hs.diet.enums.FoodClassification;
import com.hs.diet.exception.NotExistException;
import com.hs.diet.response.FoodDetailResponse;
import com.hs.diet.response.FoodListResponse;
import com.hs.diet.response.Response;
import com.hs.diet.response.WrongResponse;
import com.hs.diet.service.FoodService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @ApiOperation(value = "通过id获取食物详情")
    @ApiImplicitParam(name = "id", value = "食物id", required = true, dataType = "Long")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FoodDetailResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> findById(@PathVariable Long id) throws NotExistException {
        return new ResponseEntity<>(foodService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "通过名称搜索食物")
    @ApiImplicitParam(name = "name", value = "食物名称", required = true, dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = FoodListResponse.class)})
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Response> findByName(@PathVariable String name) {
        return new ResponseEntity<>(foodService.findByName(name), HttpStatus.OK);
    }

    @ApiOperation(value = "通过类型搜索食物")
    @ApiImplicitParam(name = "classification", value = "食物类型", required = true, dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = FoodListResponse.class)})
    @RequestMapping(value = "/classification/{classification}", method = RequestMethod.GET)
    public ResponseEntity<Response> findByClassification(@PathVariable FoodClassification classification) {
        return new ResponseEntity<>(foodService.findByClassification(classification), HttpStatus.OK);
    }

}
