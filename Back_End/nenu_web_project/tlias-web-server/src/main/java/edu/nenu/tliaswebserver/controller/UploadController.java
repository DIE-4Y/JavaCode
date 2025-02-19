package edu.nenu.tliaswebserver.controller;

import edu.nenu.tliaswebserver.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {

    /**
     * 前端传过来的的参数要和定义的参数名一致
     * 不然可用@RequestParam("file") MultipartFile image
     * 指定前端的参数和方法参数对应
     *
     * @param image
     * @return
     */

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        String originalFilename = image.getOriginalFilename();
        log.info("{}文件开始上传", image);
        String newFileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        image.transferTo(new File("D/桌面/代码/Java_class/Back_End/nenu_web_project/tlias-web-server/src/main/resources/static/image" + newFileName));
        return Result.success();
    }

}
