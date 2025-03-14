package com.service.servicebasedsystem.Repository;
import com.service.servicebasedsystem.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {
    List<Ad> findByCompanyId(Long companyId);
}
