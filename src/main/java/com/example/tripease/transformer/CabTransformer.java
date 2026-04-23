package com.example.tripease.transformer;

import com.example.tripease.dto.request.CabRequest;
import com.example.tripease.dto.response.CabResponse;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Driver;
import com.example.tripease.repository.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CabTransformer {

    @Autowired
    CabRepository cabRepository;

    public static Cab CabRequestToCab(CabRequest cabRequest){
        Cab cab = Cab.builder()
                .cabModel(cabRequest.getCabModel())
                .cabNumber(cabRequest.getCabNumber())
                .perKmRate(cabRequest.getPerKmRate())
                .available(true)
                .build();
        return cab;
    }

    public static CabResponse cabToCabResponse(Cab cab, Driver driver){
        return CabResponse.builder()
                .cabModel(cab.getCabModel())
                .cabNumber(cab.getCabNumber())
                .available(cab.isAvailable())
                .perKmRate(cab.getPerKmRate())
                .driver(DriverTransformer.driverToDriverResponse(driver))
                .build();
    }
}
