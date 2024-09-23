package sample.samplecloudvendor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.samplecloudvendor.Entity.CloudVendor;
import sample.samplecloudvendor.repository.CloudVendorRepository;
import sample.samplecloudvendor.service.CloudVendorService;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    @Override
    public String createVendor(CloudVendor cloudVendor) {

    cloudVendorRepository.save(cloudVendor);
    return "Data Saved";

    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }
}
