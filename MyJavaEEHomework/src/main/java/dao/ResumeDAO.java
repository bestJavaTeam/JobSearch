package dao;

import model.Resume;

import java.util.HashMap;
import java.util.List;

public interface ResumeDAO {

    void createResume(Resume resume);

    Resume getResumeById(int id);

    List<Resume> getResumeList(HashMap<String, String> condition);

    boolean updateResume(Resume resume);

    boolean deleteResume(Resume resume);
}
