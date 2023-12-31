package backend.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import backend.dto.BoardResponseDto;
import backend.paging.CommonParams;

@Mapper
public interface BoardMapper {

	// 게시글 수 조회
	int count(final CommonParams params);

	// 게시글 리스트 조회
	List<BoardResponseDto> findAll(final CommonParams params);
}
