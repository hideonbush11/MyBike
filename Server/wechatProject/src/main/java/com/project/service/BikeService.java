package com.project.service;

import com.project.pojo.Bike;
import org.springframework.data.geo.GeoResult;

import java.util.List;

public interface BikeService {
    public void save(Bike bike);

    public List<GeoResult<Bike>> findNear(double logitude, double latitude);
}
