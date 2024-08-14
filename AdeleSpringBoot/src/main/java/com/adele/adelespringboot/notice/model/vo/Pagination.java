package com.adele.adelespringboot.notice.model.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {
    private int currentPage; // 현재 페이지 번호
    private int totalCount; // 전체 게시물의 개수

    private int boardLimit = 10; // 한 페이지당 보여줄 게시물의 수
    private int naviLimit = 10; // 한 페이지당 보여 줄 페이지 번호

    private int maxPage;
    private int startNavi;
    private int endNavi;

    private int prevPage;
    private int nextPage;

    public Pagination() {

    }

    public Pagination(int totalCount, int currentPage) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        makePagination();
    }

    private void makePagination() {
        maxPage = (int)Math.ceil((double) totalCount / boardLimit);
        startNavi = ((currentPage - 1) / naviLimit) * naviLimit + 1;
        endNavi = (startNavi - 1) + naviLimit;
        endNavi = Math.min(endNavi, maxPage);
        if(currentPage <= 10) prevPage = 1;
        else prevPage = startNavi - 1;
        if(endNavi == maxPage) nextPage = maxPage;
        else nextPage = endNavi + 1;
    }
}
