package com.ht.diet.controller;

import com.ht.diet.enums.RecipeClassification;
import com.ht.diet.parameters.RecipeParameter;
import com.ht.diet.response.*;
import com.ht.diet.service.RecipeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @ApiOperation(value = "通过id获取食谱详情")
    @ApiImplicitParam(name = "id", value = "食谱id", required = true, dataType = "long")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = RecipeDetailResponse.class)})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> findById(@PathVariable long id) {
        return new ResponseEntity<>(recipeService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "通过分类搜索食谱")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "classification", value = "食谱分类", required = true, dataType = "String"),
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, dataType = "int")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = RecipeListResponse.class)})
    @RequestMapping(value = "/classification/{classification}", method = RequestMethod.GET)
    public ResponseEntity<Response> findByClassification(@PathVariable RecipeClassification classification,@RequestParam int page,@RequestParam int pageSize) {
        return new ResponseEntity<>(recipeService.findByClassification(classification,page,pageSize), HttpStatus.OK);
    }

    @ApiOperation(value = "创建食谱")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AddResponse.class)})
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Response> create(@RequestBody @ApiParam RecipeParameter parameter) {
        return new ResponseEntity<>(recipeService.create(parameter), HttpStatus.OK);
    }

    @ApiOperation(value = "更新食谱")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Response.class)})
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<Response> pdate(@RequestBody @ApiParam RecipeParameter parameter) {
        return new ResponseEntity<>(recipeService.update(parameter), HttpStatus.OK);
    }

    @ApiOperation(value = "删除食谱")
    @ApiImplicitParam(name = "id", value = "食谱id", required = true, dataType = "long")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Response.class)})
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@PathVariable long id){
        return new ResponseEntity<>(recipeService.delete(id), HttpStatus.OK);
    }

    @ApiOperation(value = "收藏食谱")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "long"),
            @ApiImplicitParam(name = "recipeId", value = "菜谱id", required = true, dataType = "long")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AddResponse.class)})
    @RequestMapping(value = "/{userId}/collection/{recipeId}", method = RequestMethod.POST)
    public ResponseEntity<Response> collect(@PathVariable long userId, @PathVariable long recipeId){
        return new ResponseEntity<>(recipeService.collect(userId, recipeId), HttpStatus.OK);
    }

    @ApiOperation(value = "取消收藏食谱")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "long"),
            @ApiImplicitParam(name = "recipeId", value = "菜谱id", required = true, dataType = "long")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Response.class)})
    @RequestMapping(value = "/{userId}/collection/{recipeId}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> deleteCollection(@PathVariable long userId, @PathVariable long recipeId){
        return new ResponseEntity<>(recipeService.deleteCollection(userId, recipeId), HttpStatus.OK);
    }

    @ApiOperation(value = "根据用户id获取收藏的食谱")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "long")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = RecipeListResponse.class)})
    @RequestMapping(value = "/{userId}/collection", method = RequestMethod.GET)
    public RecipeListResponse findCollectionByUserId(@PathVariable long userId){
        return recipeService.findCollectionRecipeByUserId(userId);
    }

    @ApiOperation(value = "获取每个食谱分类下有多少食谱")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = RecipeClassificationCountResponse.class)})
    @RequestMapping(value = "/classification/count", method = RequestMethod.GET)
    public ResponseEntity<Response> countByRecipeClassification() {
        return new ResponseEntity<>(recipeService.countByRecipeClassification(), HttpStatus.OK);
    }

    @ApiOperation(value = "获取某个食谱是否被某个用户收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "long"),
            @ApiImplicitParam(name = "recipeId", value = "菜谱id", required = true, dataType = "long")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = BooleanResponse.class)})
    @RequestMapping(value = "/{userId}/{recipeId}", method = RequestMethod.GET)
    public ResponseEntity<Response> IsUserCollectRecipe(@PathVariable long userId,@PathVariable long recipeId ) {
        return new ResponseEntity<>(recipeService.isUserCollectRecipe(userId,recipeId), HttpStatus.OK);
    }
}
