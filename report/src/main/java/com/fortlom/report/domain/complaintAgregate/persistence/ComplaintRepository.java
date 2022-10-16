package com.fortlom.report.domain.complaintAgregate.persistence;

import com.fortlom.report.domain.complaintAgregate.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Long> {

    List<Complaint>findByUserMain(Long id);
    List<Complaint>findByUserReported(Long id);
    List<Complaint>findByForumId(Long id);
    List<Complaint>findByPublicationId(Long id);
    List<Complaint>findByCommentId(Long id);


}
