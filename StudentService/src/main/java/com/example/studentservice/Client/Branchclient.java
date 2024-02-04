package com.example.studentservice.Client;



import com.example.studentservice.Models.Branch;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name="BRANCH-SERVICE",url="http://branchcon:8082/")
public interface Branchclient {


    @GetMapping("/branches/{id}")

    Branch findBranchById(@PathVariable Long id);
    @GetMapping("/branches")
    List<Branch> allBranches();

    default Branch getDefaultBranch(Long id, Exception exception){
        Branch branch=new Branch();
        branch.setId(id);
        branch.setName("not valid");
        branch.setCoordinator("not valid");
        return branch;
    }

}
