package com.project.service;

import com.project.pojo.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Bike bike) {
        //调用具体的业务
        //mongoTemplate.insert(bike, "bikes");
        mongoTemplate.insert(bike); // 在Bike的类中，添加了注解，注解中保存了映射关系

    }
    /**
     * 根据当前的经纬度，查找附近的单车
     * */
    @Override
    public List<GeoResult<Bike>> findNear(double longitude, double latitude) {
        //查找所有单车
        //return mongoTemplate.findAll(Bike.class);
        NearQuery nearQuery = NearQuery.near(longitude, latitude);
        //查找的范围和距离单位
        nearQuery.maxDistance(0.2, Metrics.KILOMETERS);
        GeoResults<Bike> geoResults = mongoTemplate.geoNear(nearQuery.query(new Query(Criteria.where("status").is(0)).limit(20)), Bike.class);
        return geoResults.getContent();
    }
}
