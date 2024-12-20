package com.seemee.controller;

import com.seemee.model.VendorShops;
import com.seemee.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorShopController {

    @Autowired
    VendorService vendorService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/vendorsList/{location}")
    public ResponseEntity<List<VendorShops>> getVendorsList(@PathVariable String location) {
        List<VendorShops> vendorShops = vendorService.getVendorsByStreetName(location);
        return ResponseEntity.ok(vendorShops);
    }
}