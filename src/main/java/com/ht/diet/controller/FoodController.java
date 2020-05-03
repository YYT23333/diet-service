package com.ht.diet.controller;


import com.ht.diet.enums.FoodClassification;
import com.ht.diet.exception.NotExistException;
import com.ht.diet.response.FoodDetailResponse;
import com.ht.diet.response.FoodListResponse;
import com.ht.diet.response.Response;
import com.ht.diet.response.WrongResponse;
import com.ht.diet.service.FoodService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @ApiOperation(value = "获取所有食物")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, dataType = "int")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FoodListResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity<Response> getAll(@RequestParam int page, @RequestParam int pageSize) throws NotExistException {
        return new ResponseEntity<>(foodService.getAll(page, pageSize), HttpStatus.OK);
    }

    @ApiOperation(value = "通过id获取食物详情")
    @ApiImplicitParam(name = "id", value = "食物id", required = true, dataType = "long")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = FoodDetailResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> findById(@PathVariable long id) throws NotExistException {
        return new ResponseEntity<>(foodService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "通过名称搜索食物")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "食物名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, dataType = "int")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = FoodListResponse.class)})
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Response> findByName(@PathVariable String name, @RequestParam int page, @RequestParam int pageSize) {
        return new ResponseEntity<>(foodService.findByName(name, page, pageSize), HttpStatus.OK);
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
