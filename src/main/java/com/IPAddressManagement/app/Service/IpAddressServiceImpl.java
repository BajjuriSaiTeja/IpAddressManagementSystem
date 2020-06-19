package com.IPAddressManagement.app.Service;

import com.IPAddressManagement.app.Models.IPModel;
import com.IPAddressManagement.app.Repo.IpRepository;
import org.apache.commons.net.util.SubnetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class IpAddressServiceImpl implements IPAddressService {

    private IpRepository ipRepository;

    @Autowired
    public IpAddressServiceImpl(IpRepository ipRepository) {
        this.ipRepository = ipRepository;
    }

    @Override
    public boolean generateIps(String CIDR) {
        SubnetUtils utils = new SubnetUtils(CIDR);
        Arrays.asList(utils.getInfo().getAllAddresses()).forEach( ip -> {
            IPModel ipModel = new IPModel(ip, false);
            ipRepository.save(ipModel);
        });
        return true;
    }

    @Override
    public IPModel getIp() {
        IPModel ipModel = ipRepository.getAllByAccquired(false).get(0);
        ipModel.setAccquired(true);
        return ipRepository.save(ipModel);
    }

    @Override
    public boolean releaseIp(String ip) {
        IPModel ipModel = ipRepository.getAllByIpAddress(ip).get(0);
        ipModel.setAccquired(false);
        ipRepository.save(ipModel);
        return true;
    }

    @Override
    public List<IPModel> getAllIP() {
        Iterable<IPModel> ipModels = ipRepository.findAll();
        List<IPModel> ipModels1 = new ArrayList<>();
        ipModels.forEach(ipModel -> ipModels1.add(ipModel));
        return ipModels1;
    }
}
