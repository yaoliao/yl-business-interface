package com.yl.business.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by yaoliao on 2017/8/7.
 */
@RestController
public class FileUploadController {

    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    public void upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());

        Long start = System.currentTimeMillis();
        String filePath = request.getSession().getServletContext()
                .getRealPath("/") + "upload/" + start + file.getOriginalFilename();
        System.out.println("filePath== " + filePath);
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
