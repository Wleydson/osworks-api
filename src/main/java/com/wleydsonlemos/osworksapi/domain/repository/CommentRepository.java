package com.wleydsonlemos.osworksapi.domain.repository;

import com.wleydsonlemos.osworksapi.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository  extends JpaRepository<Comment, Long> {
}
