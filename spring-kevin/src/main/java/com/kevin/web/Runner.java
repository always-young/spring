package com.kevin.web;

import com.kevin.web.config.WebConfig;
import lombok.val;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author kevin lau (双鹰)
 */
public class Runner {

    public static void main(String[] args) throws Exception {
        val context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        context.refresh();
        DispatcherServlet servlet = new DispatcherServlet(context);
        //设置端口 HOST
        Tomcat tomcat = new Tomcat();
        tomcat.setHostname("localhost");
        tomcat.setPort(8080);
        val resource = Thread.currentThread().getContextClassLoader().getResource("");
        val tomcatContext = tomcat.addContext("/", resource!=null? resource.getFile() :null);
        tomcat.getConnector();
        Tomcat.addServlet(tomcatContext,"httpHandlerServlet",servlet);
        tomcatContext.addServletMappingDecoded("/", "httpHandlerServlet");

        //启动Tomcat
        tomcat.start();
        tomcat.getServer().await();
    }

    protected static final File createTempDir(String prefix) {
        try {
            File tempDir = Files.createTempDirectory(prefix + "." + 8080 + ".").toFile();
            tempDir.deleteOnExit();
            return tempDir;
        }
        catch (IOException ex) {
            throw new RuntimeException(
                    "Unable to create tempDir. java.io.tmpdir is set to " + System.getProperty("java.io.tmpdir"), ex);
        }
    }
}
