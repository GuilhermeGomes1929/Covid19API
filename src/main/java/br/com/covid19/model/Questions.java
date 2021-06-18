package br.com.covid19.model;

import javax.persistence.*;

@Entity
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String sentence;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Category category;


    public Questions() {}

    public Questions(Integer id, String sentence, Category category) {
        this.id = id;
        this.sentence = sentence;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
