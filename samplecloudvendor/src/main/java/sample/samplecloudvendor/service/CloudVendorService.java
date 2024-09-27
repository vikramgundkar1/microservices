package sample.samplecloudvendor.service;

import sample.samplecloudvendor.Entity.CloudVendor;
import sample.samplecloudvendor.dto.CloudVendordto;

import java.util.List;
import java.util.Optional;

public interface CloudVendorService {
    String createVendor(CloudVendordto cloudVendor);

    List<CloudVendor> getAllCloudVendors();

    CloudVendor getCloudVendor(int id);


    void deleteCloudVendor(int id);

    void updateCloudVendor(CloudVendordto cloudVendordto, int id);



    String generateOTP(String email);
}
