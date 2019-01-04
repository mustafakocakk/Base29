package com.Spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @author mustafaakocak
 * @version 1.0.0
 * @since  2019-29-12
 */
@Controller
public class HelloController {
    /**
     * Encode yada decode yapılacak sayfanın açılmasını  arayüzün yüklenmesini sağlar
     * @param value get methodu  ile yuklenmesi  gereken kok  sayfayı yükler
     * @param mesaj sayfa açıldığı zaman mesaj olarak gösterilmesi istenen metni yükler.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        String mesaj="merhaba base29  decode  encode islemleri  için hoşgeldiniz. " +
                "Encode etmek icin Checkbox tikini işaretleyiniz" +
                "Decode etmek icin bir isaretleme yapmaya gerek yoktur.";
        model.addAttribute("message",mesaj );
        return "index";
    }

    /**
     * Post methodu ile alınan text değeri gerekli kontrollerden geçerek  base29  encode yada decode edilir.
     * @param value buton aktivitesinin ardından base29  adli dizine işlemleri aktarır
     * @param Text ön taraftan gelen checbox durumuna göre encode yada decode edilir.
     */
    @RequestMapping(value = "/base29",method = RequestMethod.POST)
    public String base29(@RequestParam(value = "Text")String Text,@RequestParam(value = "text",required = false)String[] checkboxEncode,
                         ModelMap modelMap){
        if (checkboxEncode!=null) {
            Base29 bs=new Base29(Text);
            modelMap.addAttribute("text", bs.getEncode());
        }
        else {
            Base29 bs=new Base29(Text);
            modelMap.addAttribute("text", bs.getDecode());
        }
        return "base29";
    }

}