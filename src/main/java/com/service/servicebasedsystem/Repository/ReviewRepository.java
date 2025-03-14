package com.service.servicebasedsystem.Repository;

import com.service.servicebasedsystem.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByAdId(Long adId);
}