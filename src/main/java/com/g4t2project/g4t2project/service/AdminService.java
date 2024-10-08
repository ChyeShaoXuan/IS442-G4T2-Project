package com.g4t2project.g4t2project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g4t2project.g4t2project.repository.*;
import com.g4t2project.g4t2project.entity.*;

import java.util.Optional;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;

    @Autowired
    private WorkerRepository workerRepository;


    public Admin addWorkerUnderAdmin(int adminId, Worker worker) {
        Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new RuntimeException("Admin not found"));
        admin.addWorker(worker);
        return adminRepository.save(admin);
    }

    
    public Admin removeWorkerUnderAdmin(int adminId, int workerId) {
        Admin admin = adminRepository.findById(adminId).orElseThrow(() -> new RuntimeException("Admin not found"));
        Worker worker = workerRepository.findById(workerId).orElseThrow(() -> new RuntimeException("Worker not found"));
        admin.removeWorker(worker);
        return adminRepository.save(admin);
    }
   
    public Worker updateWorker(int workerId, Worker updatedWorker) {
        Optional<Worker> existingWorkerOpt = workerRepository.findById(workerId);
        if (existingWorkerOpt.isPresent()) {
            Worker existingWorker = existingWorkerOpt.get();
            existingWorker.setPhoneNumber(updatedWorker.getPhoneNumber());
            existingWorker.setShortBio(updatedWorker.getShortBio());
            existingWorker.setDeployed(updatedWorker.getDeployed());
            return workerRepository.save(existingWorker);
        } else {
            throw new RuntimeException("Worker not found");
        }
    }

    public void updateLeaveApplicationStatus(int leaveApplicationId, LeaveApplication.Status status) {
        Optional<LeaveApplication> leaveApplicationOpt = leaveApplicationRepository.findById(leaveApplicationId);
        if (leaveApplicationOpt.isPresent()) {
            LeaveApplication leaveApplication = leaveApplicationOpt.get();
            leaveApplication.setStatus(status);
            leaveApplicationRepository.save(leaveApplication);
        } else {
            throw new RuntimeException("Leave Application not found");
        }
    }

    
}
