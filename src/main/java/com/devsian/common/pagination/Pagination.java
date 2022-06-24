package com.devsian.common.pagination;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pagination<T> {
    // 총 데이터 개수
    private Integer totalListSize;
    // 리스트
    private List<T> list;

    public Integer calcOffset(Integer page, Integer listSizePerPage) {
        return (page-1)*listSizePerPage;
    }
}
