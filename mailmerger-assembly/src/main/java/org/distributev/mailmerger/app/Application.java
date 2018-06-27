package org.distributev.mailmerger.app;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.FileResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.PrefixFileFilter;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import javax.servlet.ServletException;

public class Application {

    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        String appBase = ".";
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(createTempDir());
        tomcat.setPort(PORT);
        tomcat.getHost().setAppBase(appBase);

        File buildDir = new File("build");
        File[] webWar = buildDir.listFiles((FileFilter) new PrefixFileFilter("mailmerger", IOCase.SENSITIVE));
        File[] rundeckWar = buildDir.listFiles((FileFilter) new PrefixFileFilter("rundeck", IOCase.SENSITIVE));

        addRundeck(rundeckWar, tomcat);
        addWebconsole(webWar, tomcat);

        tomcat.start();
        tomcat.getServer().await();
    }

    private static void addRundeck(File[] files, Tomcat tomcat) throws ServletException {
        if (files != null && files.length != 0) {
            Context context = tomcat.addWebapp("/rundeck", files[0].getAbsolutePath());

            File additionWebInfClasses = new File("properties");
            if (!additionWebInfClasses.exists()) {
                System.err.println("Missed mandatory log4j.properties for starting rundeck.");
                System.err.println("log4j.properties should be placed in the mailmerger-assembly directory.");
                return;
            }
            WebResourceRoot resources = new StandardRoot(context);
            resources.addPreResources(new FileResourceSet(resources, "/WEB-INF/classes",
                    additionWebInfClasses.getAbsolutePath(), "/"));
            context.setResources(resources);
        }
    }

    private static void addWebconsole(File[] files, Tomcat tomcat) throws ServletException {
        if (files != null && files.length != 0) {
            tomcat.addWebapp("/webconsole", files[0].getAbsolutePath());
        } else {
            System.err.println("Could not found mailmerger war");
        }
    }

    private static String createTempDir() {
        try {
            File tempDir = File.createTempFile("tomcat.", "." + PORT);
            tempDir.delete();
            tempDir.mkdir();
            tempDir.deleteOnExit();
            return tempDir.getAbsolutePath();
        } catch (IOException ex) {
            throw new RuntimeException(
                    "Unable to create tempDir. java.io.tmpdir is set to " + System.getProperty("java.io.tmpdir"),
                    ex
            );
        }
    }
}
