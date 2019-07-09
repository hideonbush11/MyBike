package com.project.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

// Bike这个类，以后和MongoDB中的bikes collection关联上了
@Document(collection = "bikes")
public class Bike {

    // 主键，（唯一， 建立索引）， id -> mongodb中的_id
    @Id
    private String id;

//    private double longitude;

//    private double latitude;
    //表示经纬度的数组[经度， 维度]
    @GeoSpatialIndexed(type= GeoSpatialIndexType.GEO_2DSPHERE)
    private double[] location;

    //建立索引
    @Indexed
    private Long bikeNo;

    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double[] getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setBikeNo(Long bikeNo) {
        this.bikeNo = bikeNo;
    }

    public Long getBikeNo() {
        return bikeNo;
    }
}
