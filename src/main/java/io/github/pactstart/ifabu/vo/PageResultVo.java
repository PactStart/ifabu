package io.github.pactstart.ifabu.vo;

import java.util.List;

public class PageResultVo<T> {

    private int pageSize;

    private int currentPage;

    private int totalPages;

    private long totalRows;

    private boolean hasNextPage;

    private boolean hasPreviousPage;

    private List<T> result;

    public PageResultVo(int pageSize, int currentPage, int totalPages, long totalRows, List<T> result) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalRows = totalRows;
        this.result = result;
        this.hasNextPage = currentPage < totalPages;
        this.hasPreviousPage = 1 < currentPage && currentPage < totalPages;
    }

    public PageResultVo() {
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalRows() {
        return this.totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public boolean isHasNextPage() {
        return this.hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPreviousPage() {
        return this.hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public List<T> getResult() {
        return this.result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PageResultVo(pageSize=" + this.getPageSize() + ", currentPage=" + this.getCurrentPage() + ", totalPages=" + this.getTotalPages() + ", totalRows=" + this.getTotalRows() + ", hasNextPage=" + this.isHasNextPage() + ", hasPreviousPage=" + this.isHasPreviousPage() + ", result=" + this.getResult() + ")";
    }
}