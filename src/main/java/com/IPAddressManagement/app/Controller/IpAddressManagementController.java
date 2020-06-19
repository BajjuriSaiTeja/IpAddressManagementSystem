package com.IPAddressManagement.app.Controller;

import com.IPAddressManagement.app.Models.IPModel;
import com.IPAddressManagement.app.Service.IPAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class IpAddressManagementController {

    private IPAddressService ipAddressService;

    @Autowired
    public IpAddressManagementController(IPAddressService ipAddressService) {
        this.ipAddressService = ipAddressService;
    }

    @PostMapping("generateIp")
    public ResponseEntity saveTicket(@RequestParam String CIDR) {
        ipAddressService.generateIps(CIDR);
        return new ResponseEntity<String>("Generated Ips", HttpStatus.OK);
    }

    @GetMapping("getIp")
    public ResponseEntity getIp() {
        IPModel ipModel = ipAddressService.getIp();
        return new ResponseEntity<IPModel>(ipModel, HttpStatus.OK);
    }

    @PatchMapping("releaseIp")
    public ResponseEntity getIp(@RequestParam String IP) {
        ipAddressService.releaseIp(IP);
        return new ResponseEntity<String>("Realesed" + IP, HttpStatus.OK);
    }

    @GetMapping("getAllIp")
    public ResponseEntity getAllIp() {
        return new ResponseEntity<List<IPModel>>(ipAddressService.getAllIP(), HttpStatus.OK);
    }
}
