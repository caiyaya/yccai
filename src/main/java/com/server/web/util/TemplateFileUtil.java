package com.server.web.util;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

public class TemplateFileUtil {
    public static String getContent(String template, HashMap<String,Object> paramMap) throws IOException, TemplateException {
        Configuration csg = new Configuration(Configuration.VERSION_2_3_23);
        StringTemplateLoader st1 = new StringTemplateLoader();
        st1.putTemplate("mytemplate",template);
        csg.setTemplateLoader(st1);
        Template tp = csg.getTemplate("mytemplate","UTF-8");
        StringWriter sw = new StringWriter();
        tp.process(paramMap,sw);
        return sw.toString();
    }
}
