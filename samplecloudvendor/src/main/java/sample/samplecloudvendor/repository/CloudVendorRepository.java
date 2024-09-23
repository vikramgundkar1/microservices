package sample.samplecloudvendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.samplecloudvendor.Entity.CloudVendor;

@Repository
public interface CloudVendorRepository extends JpaRepository<CloudVendor, Integer> {
}
