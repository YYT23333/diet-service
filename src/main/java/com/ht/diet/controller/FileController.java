package com.ht.diet.controller;

import com.ht.diet.response.Response;
import com.ht.diet.response.UploadResponse;
import com.ht.diet.uitls.FileUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {
    @ApiOperation(value = "上传图片")
    @ApiImplicitParam(name = "img", value = "上传图片", required = true,dataType = "file")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = UploadResponse.class)})
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Response> uploadPicture(@RequestParam("img") MultipartFile img){
        String name = UUID.randomUUID().toString() + ".jpg";
        try {
            return new ResponseEntity<>(new UploadResponse(FileUtil.upload(img.getInputStream(), "image/", name)), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(new UploadResponse(500,e.getMessage()),HttpStatus.OK);
        }
    }
}
