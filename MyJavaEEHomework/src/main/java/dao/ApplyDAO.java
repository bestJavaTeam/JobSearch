package dao;

import model.apply;

import java.util.List;

public interface ApplyDAO {

    void createapply(apply apply);

    apply getapplyById(int id);

    List<apply> getapplyByUserId(int userId);

    List<apply> getapplyByJobId(int jobId);

    boolean updateapply(apply apply);

    boolean deleteapply(apply apply);

}
