package com.seowoninfo.azuredev;

import com.seowoninfo.azuredev.util.AES256;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.UnsupportedEncodingException;

/**
 * FileName    : IntelliJ IDEA
 * Author      : Seowon
 * Date        : 2025-02-24
 * Description :
 */
@Controller
public class MainController {

    @Value("${spring.profiles.active}") private String PROP;

    @GetMapping("/main")
    public String main(Model model) throws Exception {


        String plainTxt = "이거슨 한글입니다.";
        String encTxt = "";

        AES256 aes256 = new AES256("abcdefghijklmnop");


        encTxt = jasyptEncoding(plainTxt);

        System.out.println("PROP================================= " + PROP);
        System.out.println("plainTxt================================= " + plainTxt);
        System.out.println("encTxt================================= " + encTxt);

        model.addAttribute("prop", PROP);
        model.addAttribute("plainTxt", plainTxt);
        model.addAttribute("encTxt", encTxt);

        return "main";
    }

    public String jasyptEncoding(String value) {
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword("ThisIsSilFrameworkAndThisFrameworkIsBorn20250101BySil");
        return pbeEnc.encrypt(value);
    }

}
