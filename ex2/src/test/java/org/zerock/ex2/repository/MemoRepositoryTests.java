package org.zerock.ex2.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.zerock.ex2.entity.Memo;

@SpringBootTest
public class MemoRepositoryTests {
    @Autowired
    MemoRepository repository;

    @Test
    public void testClass() {
        System.out.println(repository.getClass().getName());
    }

    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Simple..." + 1).build();
            repository.save(memo);
        });
    }

    @Test
    public void testSelect() {
        Long mno = 100L;
        Optional<Memo> result = repository.findById(mno);
        System.out.println("========================================");
        if (result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    // 수정
    @Test
    public void testUpdate() {
        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
        System.out.println(repository.save(memo));
    }

    // 삭제
    @Test
    public void testDelete() {
        Long mno = 100L;
        repository.deleteById(mno);
    }

    // 페이징 처리
    @Test
    public void testPageDefault() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Memo> result = repository.findAll(pageable);
        System.out.println(result);
        System.out.println("======================================");
        System.out.println(result.getTotalPages()); // 총 페이지 수
        System.out.println(result.getTotalElements()); // 전체 개수
        System.out.println(result.getNumber()); // 현재페이지 번호
        System.out.println(result.getSize()); // 페이지당 데이터 개수
        System.out.println(result.hasNext()); // 다음페이지 존재여부
        System.out.println(result.isFirst()); // 시작페이지 여부
    }

    // 정렬 조건
    @Test
    public void testSort() {
        Sort sort1 = Sort.by("mno").descending();
        Pageable pageable = PageRequest.of(0, 10, sort1);
        Page<Memo> result = repository.findAll(pageable);

        result.get().forEach(memo -> {
            System.out.println(memo);
        });
    }

    // 쿼리 메서드
    @Test
    public void testQueryMethos() {
        List<Memo> list = repository.findByMnoBetweenOrderByMnoDesc(70L, 80L);

        for (Memo memo : list) {
            System.out.println(memo);
        }
    }

    // 쿼리 메서드와 Pageable 결합
    @Test
    public void testQueryMethosWithPageable() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
        Page<Memo> result = repository.findByMnoBetween(10L, 50L, pageable);
        result.get().forEach(memo -> System.out.println(memo));
    }

    // deleteBy로 시작하는삭제처리
    @Commit
    @Transactional // 없을 시 에러
    @Test
    public void testDeleteQueryMethods() {
        repository.deleteMemoByMnoLessThan(20L);
    }

    // Query 어노테이션
    @Test
    public void testQuery() {
        List<Memo> list = repository.getListDesc();
        for (var m : list) {
            System.out.println(m);
        }
    }

}
