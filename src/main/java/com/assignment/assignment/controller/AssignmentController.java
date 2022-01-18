package com.assignment.assignment.controller;

import com.assignment.assignment.Pojo;
import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class AssignmentController {

    private static final Logger logger = getLogger(AssignmentController.class);

    Pojo requiredPojo ;

    @GetMapping(value ="/getStoreDetailsById",produces = MediaType.APPLICATION_JSON_VALUE)
    public Pojo getStoreById(@RequestParam("id") String id) throws IOException {
          List<Pojo> pojos=getAllStoreDetails();

          pojos.stream().forEach(pojo -> {
              if(pojo!=null && pojo.getStoreId().equals(id))
              {
                   this.requiredPojo=pojo;

              }

          });
          return requiredPojo;
    }

    @GetMapping(value = "/getStoresByCityName",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pojo> getAllStoresByCityName(String cityName) throws IOException {
        List<Pojo> pojos=getAllStoreDetails();
        List<Pojo> pojoList = new ArrayList<>();

        pojos.stream().forEach(pojo -> {
            if(pojo!=null && pojo.getCity().equals(cityName))
            {
               pojoList.add(pojo);

            }

        });
       return pojoList;
    }

    public List<Pojo> getAllStoreDetails() throws IOException {

        BufferedReader stream = null;
        String line = null;
        List<Pojo> datas = new ArrayList<Pojo>();
        try {
            stream = new BufferedReader(new FileReader("/src/stores.csv"));
            while ((line = stream.readLine()) != null) {
                String[] splitted = line.split(",");
                Pojo data = new Pojo();
                data.setStoreId(splitted[0]);
                data.setPostCode(splitted[1]);
                data.setCity(splitted[2]);
                data.setAddress(splitted[3]);
                data.setAddress(splitted[4]);
                datas.add(data);
            }
        }catch(Exception e)
        {
          logger.info("Exception occured while fetching");
        }
        return datas;
    }
}
