package com.IPAddressManagement.app.Service;

import com.IPAddressManagement.app.Models.IPModel;

import java.util.List;

public interface IPAddressService {
     public boolean generateIps(String CIDR);
     public IPModel getIp();
     public boolean releaseIp(String ip);
     public List<IPModel> getAllIP();
}
