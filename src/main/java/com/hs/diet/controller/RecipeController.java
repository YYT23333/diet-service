package com.hs.diet.controller;

import com.hs.diet.enums.RecipeClassification;
import com.hs.diet.exception.NotExistException;
import com.hs.diet.response.*;
import com.hs.diet.service.RecipeService;
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
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @ApiOperation(value = "通过id获取食谱详情")
    @ApiImplicitParam(name = "id", value = "食谱id", required = true, dataType = "Long")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = RecipeDetailResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> findById(@PathVariable Long id) throws NotExistException {
        return new ResponseEntity<>(recipeService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "通过分类搜索食谱")
    @ApiImplicitParam(name = "classification", value = "食谱分类", required = true, dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = RecipeListResponse.class)})
    @RequestMapping(value = "/classification/{classification}", method = RequestMethod.GET)
    public ResponseEntity<Response> findByClassification(@PathVariable RecipeClassification classification) {
        return new ResponseEntity<>(recipeService.findByClassification(classification), HttpStatus.OK);
    }
}
