package com.thinkgem.jeesite.modules.oa.web;

import com.thinkgem.jeesite.modules.oa.entity.Idcard;
import com.thinkgem.jeesite.modules.oa.service.IdcardService;
import idcard.CLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import com.sun.jna.Pointer;

/**
 * 身份识别controller
 */

@Controller
//@RequestMapping(value = "${adminPath}/oa/idcard")
public class IdcardController {
    @Autowired
    protected IdcardService idcardService;

    @RequestMapping(value = "${adminPath}/oa/idcard")
    public String form(Idcard idcard, Model model) {
        model.addAttribute("idcard", idcard);
        return "modules/oa/idcardForm";
    }

    //上传图片
    @RequestMapping(value = "${adminPath}/oa/idcard/upload")
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request ,Model model) throws IOException {
        String fileName = file.getOriginalFilename();
        String path = request.getSession().getServletContext().getRealPath("images/");

        File tempFile = new File(path, new Date().getTime() + String.valueOf(fileName));
        String image = tempFile.toString();
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdirs();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        System.out.println("上传成功");

        Idcard card = new Idcard();
        identify(card,image);
//        card.setName("张三");
//        card.setSex("女");
//        card.setNation("汉族");
//        card.setAddress("皇后大道");
//        card.setIdcard("35220211111111111111");
//        model.addAttribute("idcards",card);
        request.setAttribute("idcards",card);
        request.setCharacterEncoding("utf-8");
        idcardService.save(card);

        return "modules/oa/idcardForm";
    }

    //图片识别方法
    public void  identify(Idcard idcard, String image ){
        String libpath = "E:/project/jeesite/bin/dll";
        Pointer[] arr = CLibrary.INSTANCE.result_test(libpath,image);
        int len = arr.length;
        System.out.println(len);
        for(int i =0 ;i<5;i++){
            try {
                String str =  arr[i].getString(0, Boolean.parseBoolean("UTF-8"));
                String newStr =  new String(str.getBytes(),"utf-8");
                if (i == 0) {
                    idcard.setName(newStr);
                }
                if (i == 1) {
                    idcard.setSex(newStr);
                }
                if (i == 2) {
                    idcard.setNation(newStr);
                }
                if (i == 3) {
                    idcard.setAddress(newStr);
                }if (i == 4) {
                    idcard.setIdcard(newStr);
                }
                System.out.println(newStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
