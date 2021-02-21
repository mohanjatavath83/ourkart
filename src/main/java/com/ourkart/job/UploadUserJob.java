package com.ourkart.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class UploadUserJob
{
    @Autowired
    RestTemplate restTemplate;

    Path rootLocation = Paths.get("upload1");
    //@Scheduled(cron = "0 * 9 * * ?")
    @Scheduled(fixedRate = 10000)
    public void cronJobSch() throws Exception
    {
        File folder = new File(rootLocation.toUri());




        System.out.println( System.getProperty("user.dir"));


        /*if(files!=null && files.listFiles()!=null)
        {
            for(File file : files.listFiles())
            {
                System.out.println(file.getPath());
                System.out.println("file name  = "+file.getName());
                try {
                    Files.lines(Paths.get(file.toURI())).collect(Collectors.toList()).forEach(System.out::println);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/





    }
}


























/* final HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        String url = "http://localhost:8080/customers";

        final ResponseEntity<UserData[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, UserData[].class);
        System.out.println("########################################");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(response.getBody()));



        System.out.println("########################################");*/








