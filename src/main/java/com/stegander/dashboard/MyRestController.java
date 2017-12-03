package com.stegander.dashboard;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;

@RestController
public class MyRestController {


    @RequestMapping("/status")
    public String greeting() throws IOException {

        ArrayList<Service> allServices = getAllServices();

        String html = getFileAsString("test.html");
        String line = getFileAsString("line.txt");

        final String[] allLines = {new String()};
        allServices.forEach(service -> {
            String newLine = line;
            MessageFormat messageFormat = new MessageFormat(newLine);
            Object[] args = {service.name, service.getStatusPrd(), service.getPrd(), service.getStatusUtb(), service.getUtb(), service.getStatusTst(), service.getTst(), service.getStatusUtv(),service.getUtv()};
            allLines[0] = allLines[0] + messageFormat.format(args)  + "\n";

        });

//        for (int i = 0 ; i < 10; i++){
//            String newLine = line;
//            MessageFormat messageFormat = new MessageFormat(newLine);
//            Object[] args = {"Service-" + i, "green", "1", "red", "1", "green", "1", "green","1"};
//            allLines[0] = allLines[0] + messageFormat.format(args)  + "\n";
//        }

        return html.replace("OUR", allLines[0]);
    }

    private ArrayList<Service> getAllServices() {
        ArrayList<Service> allServices = new ArrayList<>();
        for (int i = 0 ; i < 10; i++){
            allServices.add(new Service(2, "Service-" + i, 1, 0, 2, 2));
        }
        return  allServices;
    }

    private String getFileAsString(String name) throws IOException {
        File file = new ClassPathResource("templates/" + name).getFile();
        String content = "";
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(file.getAbsolutePath()) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return content;
    }
}
