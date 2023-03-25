package kyoongdev.kyoongdevspring.common;

import org.springframework.data.domain.Pageable;

import java.util.List;

public class PagingDTO<T> {

    public List<T> data;

    public Pagination paging;

    public PagingDTO(List<T> data, Pageable pageable, Long totalCount) {
        this.data = data;
        this.paging = this.getPagination(pageable, totalCount);
    }


    Pagination getPagination(Pageable pageable, Long totalCount) {
        return new Pagination(pageable, totalCount);
    }
}
