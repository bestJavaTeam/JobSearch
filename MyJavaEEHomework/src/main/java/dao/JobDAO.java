package dao;

import model.Job;

import java.util.HashMap;
import java.util.List;

public interface JobDAO {

    void createJob(Job job);

    Job getJobById(int id);

    List<Job> getJobList(HashMap<String, String> condition);

    boolean updateJob(Job job);

    boolean deleteJob(Job job);

}
