package sample.samplecloudvendor.service;

import sample.samplecloudvendor.Entity.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    String createVendor(CloudVendor cloudVendor);

    List<CloudVendor> getAllCloudVendors();
}
