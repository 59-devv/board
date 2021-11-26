package com.sparta.final_project.service;

import com.sparta.final_project.dto.CommentRequestDto;
import com.sparta.final_project.model.Comment;
import com.sparta.final_project.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long update(Long id, CommentRequestDto requestDto) {
        Comment comment =commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 없습니다.")
        );
        comment.update(requestDto);
        return comment.getId();
    }
}
