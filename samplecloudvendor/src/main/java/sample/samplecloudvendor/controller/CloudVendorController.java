package sample.samplecloudvendor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.samplecloudvendor.Entity.CloudVendor;
import sample.samplecloudvendor.dto.CloudVendordto;
import sample.samplecloudvendor.service.CloudVendorService;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    private static Logger logger=LoggerFactory.getLogger(CloudVendorController.class);

    @Autowired
    private CloudVendorService service;

    @PostMapping("/create")
    public String createClodVendor(@RequestBody CloudVendordto cloudVendor)

    {
        service.createVendor(cloudVendor);
        return "Vendor Created Successfully";
    }

    @PutMapping("/update/{id}")
    public String updateClodVendor(@RequestBody CloudVendordto cloudVendordto, @PathVariable("id") int id)
    {
        service.updateCloudVendor(cloudVendordto, id);
        return "Vendor Updated Successfully";
    }

    @GetMapping("/getall")
    public List<CloudVendor> getAllVendors()
    {

        return service.getAllCloudVendors();
    }

    @GetMapping("/getall/{id}")
    public CloudVendor getAllVendors(@PathVariable int id)
    {

        return service.getCloudVendor(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCloudVendor(@PathVariable int id)
    {
         service.deleteCloudVendor(id);
         return new ResponseEntity<>("Deleted CloudVendor", HttpStatus.OK);
    }

    @PostMapping("/generateotp")
    public ResponseEntity<String> emailVerification(@RequestBody String email)
    {
        logger.info("Entered in Controller");
        service.generateOTP(email);
        return new ResponseEntity<>("Otp sent", HttpStatus.OK);
    }


}
