package ru.gk.fiveautorater.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transactions {

    @JsonProperty("count")
    private long count;
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;

    @JsonProperty("results")
    private List<Check> checks = null;


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Check> getChecks() {
        return checks;
    }

    public void setChecks(List<Check> checks) {
        this.checks = checks;
    }
}
