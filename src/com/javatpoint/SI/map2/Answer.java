package com.javatpoint.SI.map2;

import java.util.Date;

/**
 * Created by Ionela on 11/21/2016.
 */
public class Answer {
    private int id;
    private String answer;
    private Date postedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", postedDate=" + postedDate +
                '}';
    }
}
