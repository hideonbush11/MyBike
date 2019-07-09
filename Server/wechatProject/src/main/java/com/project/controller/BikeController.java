package com.project.controller;

import com.project.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.pojo.Bike;

import java.util.List;

@Controller
public class BikeController {

    //到spring容器中查找BikeService类型的实例对象，然后注入到BikeController实例中
    @Autowired
    private BikeService bikeService;

    @RequestMapping("/bike/add")
    @ResponseBody
    public String add(@RequestBody Bike bike) {
        // 调用service, 将数据保存到mongodb中
        bikeService.save(bike);
        return "success!!";
    }

    @RequestMapping("/bike/findNear")
    @ResponseBody
    public List<GeoResult<Bike>> findNear(double longitude, double latitude) {
        //调用service，将数据保存到MongoDB中
        List<GeoResult<Bike>> bikes = bikeService.findNear(longitude, latitude);
        return bikes;
    }
}
