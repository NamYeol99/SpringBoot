package org.zerock.mrerview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.mrerview.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
