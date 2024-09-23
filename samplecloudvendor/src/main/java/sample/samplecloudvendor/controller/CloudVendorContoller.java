package sample.samplecloudvendor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.samplecloudvendor.Entity.CloudVendor;
import sample.samplecloudvendor.service.CloudVendorService;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorContoller {
    @Autowired
    private CloudVendorService service;

    @PostMapping("/create")
    public String createClodVendor(@RequestBody CloudVendor cloudVendor)

    {
        service.createVendor(cloudVendor);
        return "Vendor Created Successfully";
    }

    @GetMapping("/getall")
    public List<CloudVendor> getAllVendors()
    {
        return service.getAllCloudVendors();
    }
}
