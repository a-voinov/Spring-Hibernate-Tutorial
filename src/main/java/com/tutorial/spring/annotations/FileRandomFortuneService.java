package com.tutorial.spring.annotations;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileRandomFortuneService implements FortuneService {

    private String[] fortunes;

    @PostConstruct
    private void initFortunes() throws IOException {
        String fileName = "fortunes.txt";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        InputStreamReader reader = new InputStreamReader(
             new FileInputStream(file)
        );
        System.out.println("[initFortunes] File loaded");
        List<String> fortuneList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine())!=null)
            fortuneList.add(line);
        fortunes = fortuneList.toArray(new String[fortuneList.size()]);
        bufferedReader.close();
    }

    @Override
    public String getFortune()  {
        Random random = new Random();
        return fortunes[random.nextInt(fortunes.length)];
    }
}
