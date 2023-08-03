package backend;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import backend.domain.post.PostMapper;
import backend.domain.post.PostRequest;
import backend.domain.post.PostResponse;

@SpringBootTest
public class PostMapperTest {
	@Autowired
	PostMapper postMapper;

	@Test
	void save() {
		PostRequest params = new PostRequest();
		params.setTitle("2번 게시글 제목");
		params.setContent("2번 게시글 내용");
		params.setWriter("Test");
		params.setNoticeYn(false);
		postMapper.save(params);

		List<PostResponse> post = postMapper.findAll();
		System.out.printf("전체 게시글 수는 %d 개입니다.\n",post.size());
	}

    @Test
    void findById() {
        PostResponse post = postMapper.findById(1L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void update() {
        // 1. 게시글 수정
        PostRequest params = new PostRequest();
        params.setId(4L);
        params.setTitle("4번 게시글 제목 수정합니다.");
        params.setContent("4번 게시글 내용 수정합니다.");
        params.setWriter("4.seokbeom");
        params.setNoticeYn(true);
        postMapper.update(params);

        // 2. 게시글 상세정보 조회
        PostResponse post = postMapper.findById(1L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void delete() {
        System.out.println("삭제 이전의 전체 게시글 개수는 : " + postMapper.findAll().size() + "개입니다.");
        postMapper.deleteById(5L);
        System.out.println("삭제 이후의 전체 게시글 개수는 : " + postMapper.findAll().size() + "개입니다.");
    }
}
