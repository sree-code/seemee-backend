package com.seemee.service;

import com.seemee.model.VendorShops;

import java.util.List;

public interface VendorService {
    List<VendorShops> getVendorsByStreetName(String streetName);
}
