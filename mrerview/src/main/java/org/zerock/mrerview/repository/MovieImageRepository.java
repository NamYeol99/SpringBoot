package org.zerock.mrerview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.mrerview.entity.MovieImage;

public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {
}
