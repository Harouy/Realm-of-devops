package com.example.branch.Services;

import com.example.branch.entities.Branch;
import com.example.branch.repositories.BranchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;
    public List<Branch> getbranches(){
        return branchRepository.findAll();
    }
    public void addbranch(Branch branch){
        branchRepository.save(branch);
    }
    public Branch getbranch(Long id){
        return branchRepository.findById(id).get();

    }

}
