package com.IPAddressManagement.app.Repo;

import com.IPAddressManagement.app.Models.IPModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IpRepository extends CrudRepository<IPModel, Integer> {

    public List<IPModel> getAllByAccquired(boolean accquired);
    public List<IPModel> getAllByIpAddress(String IP);
}
