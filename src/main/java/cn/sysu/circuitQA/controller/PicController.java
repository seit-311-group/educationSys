package cn.sysu.circuitQA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/qa")
public class PicController {

    @RequestMapping("/upload")
    public String uploadFile(MultipartFile mFile) throws IOException {
        String fileName = mFile.getOriginalFilename();
        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        String path = "C:\\fileUpload\\" + fileName;
        File dest = new File(path);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {

            mFile.transferTo(dest); //保存文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "留言";
    }

}
