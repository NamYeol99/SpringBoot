package org.zerock.mrerview.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.mrerview.entity.Member;
import org.zerock.mrerview.entity.Movie;
import org.zerock.mrerview.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @EntityGraph(attributePaths = {"member"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Review> findByMovie(Movie movie);
    @Modifying
    @Query("delete from Review mr where mr.member = :member")
    void deleteByMember(Member member);
}
