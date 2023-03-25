package kyoongdev.kyoongdevspring.common;

import org.springframework.data.domain.Pageable;

public class Pagination {
    boolean hasNext;
    boolean hasPrev;
    Long totalCount;
    int page;
    int size;

    Pagination(Pageable pageable, Long totalCount) {
        this.hasNext = pageable.getPageNumber() < totalCount;
        this.hasPrev = pageable.getPageNumber() > 1;
        this.totalCount = totalCount;
        this.page = pageable.getPageNumber();
        this.size = pageable.getPageSize();
    }
}
