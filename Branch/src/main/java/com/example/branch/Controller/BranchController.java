package com.example.branch.Controller;

import com.example.branch.Services.BranchService;
import com.example.branch.entities.Branch;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController

@CrossOrigin("*")
public class BranchController {
    private final BranchService branchService;
    @GetMapping("/branches")
    public ResponseEntity<List<Branch>> getbranches(){
        List<Branch> branches=branchService.getbranches();
        return  new ResponseEntity<>(branches, HttpStatus.OK);

    }
    @PostMapping("/branches")
    public ResponseEntity createbranch(@RequestBody Branch branch){
        branchService.addbranch(branch);
        return new ResponseEntity(HttpStatus.CREATED);

    }

@GetMapping("/branches/{id}")
    public ResponseEntity<Branch> getbranch(@PathVariable Long id) {
    Branch branch = branchService.getbranch(id);
    return new ResponseEntity<Branch>(branch, HttpStatus.OK);
}
}
