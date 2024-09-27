package sample.samplecloudvendor.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sample.samplecloudvendor.Entity.CloudVendor;
import sample.samplecloudvendor.dto.CloudVendordto;
import sample.samplecloudvendor.exception.CloudVendorNotFoundException;
import sample.samplecloudvendor.repository.CloudVendorRepository;
import sample.samplecloudvendor.service.CloudVendorService;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    private  static Logger logger= LoggerFactory.getLogger(CloudVendorServiceImpl.class);
    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String createVendor(CloudVendordto cloudVendor) {
        CloudVendor entity = new CloudVendor();
        //mapper.map(cloudVendor,entity);
        BeanUtils.copyProperties(cloudVendor,entity);
        cloudVendorRepository.save(entity);


    return "Data Saved";

    }



    @Override
    @Cacheable(value="vendors")
    public List<CloudVendor> getAllCloudVendors()
    {
        return cloudVendorRepository.findAll();
    }

    @Override
    public CloudVendor getCloudVendor(int id) {
        return cloudVendorRepository.findById(id).orElseThrow(()-> new CloudVendorNotFoundException("Vendor Not Found"));
    }

    @CacheEvict(value="vendors", key="#id")
    @Override
    public void deleteCloudVendor(int id) {

        cloudVendorRepository.deleteById(id);

    }

    @Override
    @CachePut(value="vendors", key="#resut.id")
    public void updateCloudVendor(CloudVendordto cloudVendordto, int id) {

        Optional<CloudVendor> byId = cloudVendorRepository.findById(id);
        if(byId.isPresent()){
            CloudVendor cloudVendor = byId.get();
            cloudVendor.setVendorName(cloudVendordto.getVendorName());
            cloudVendorRepository.save(cloudVendor);

        }

    }

    @Override
    public String generateOTP(String email) {
        String validEmail=email.trim();

        SimpleMailMessage message=new SimpleMailMessage();
        String otp=String.format("%06d", new Random().nextInt(999999));
        message.setTo(validEmail);
        message.setSubject("CloudVendor Notification Email");
        message.setText("Your OTP is "+otp);
        try {
            mailSender.send(message);
        }
        catch(MailException e)
        {
            logger.error("Failed to send Email: "+e.getMessage());
            throw new RuntimeException("Failed to send OTP");
        }
        return otp;

    }


}
