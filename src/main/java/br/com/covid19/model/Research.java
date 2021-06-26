package br.com.covid19.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;

@Entity
public class Research {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Timestamp research_date;
    @ManyToOne
    @JoinColumn(nullable = false)
    private District p1;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Occupation p2;
    @Column(nullable = false)
    private Integer p3;
    @Column(nullable = false)
    private Boolean p4;
    @Column(nullable = false)
    private Boolean p5;
    @Column(nullable = false)
    private Boolean p6;
    @Column(nullable = false)
    private Boolean p7;
    @Column(nullable = false)
    private Boolean p8;
    @Column(nullable = false)
    private Boolean p9;
    @Column(nullable = false)
    private Boolean p10;
    @Column(nullable = false)
    private Boolean p11;
    @Column(nullable = false)
    private Boolean p12;
    @Column(nullable = false)
    private Boolean p13;
    @Column(nullable = false)
    private Boolean p14;
    @Column(nullable = false)
    private Boolean p15;
    @Column(nullable = false)
    private Boolean p16;
    @Column(nullable = false)
    private Boolean p17;
    @Column(nullable = false)
    private Boolean p18;
    @Column(nullable = false)
    private Boolean p19;

    public Research() {
    }

    public Research(Long id,Timestamp research_date, District p1, Occupation p2, Integer p3, Boolean p4, Boolean p5, Boolean p6, Boolean p7, Boolean p8, Boolean p9, Boolean p10, Boolean p11, Boolean p12, Boolean p13, Boolean p14, Boolean p15, Boolean p16, Boolean p17, Boolean p18, Boolean p19) {
        this.id = id;
        this.research_date = research_date;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.p8 = p8;
        this.p9 = p9;
        this.p10 = p10;
        this.p11 = p11;
        this.p12 = p12;
        this.p13 = p13;
        this.p14 = p14;
        this.p15 = p15;
        this.p16 = p16;
        this.p17 = p17;
        this.p18 = p18;
        this.p19 = p19;

    }

    public HashMap getHashMap(){
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (p1 != null){
            hashMap.put("p1", this.p1);
        }
        if (p2 != null){
            hashMap.put("p2", this.p1);
        }
        if (p3 != null){
            hashMap.put("p3", this.p1);
        }
        if (p4 != null){
            hashMap.put("p4", this.p4);
        }
        if (p5 != null){
            hashMap.put("p5", this.p5);
        }
        if (p6 != null){
            hashMap.put("p6", this.p6);
        }
        if (p7 != null){
            hashMap.put("p7", this.p7);
        }
        if (p8 != null){
            hashMap.put("p8", this.p8);
        }
        if (p9 != null){
            hashMap.put("p9", this.p9);
        }
        if (p10 != null){
            hashMap.put("p10", this.p10);
        }
        if (p11 != null){
            hashMap.put("p11", this.p11);
        }
        if (p12 != null){
            hashMap.put("p12", this.p12);
        }

        if (p13 != null){
            hashMap.put("p13", this.p13);
        }

        if (p14 != null){
            hashMap.put("p14", this.p14);
        }
        if (p15 != null){
            hashMap.put("p15", this.p15);
        }
        if (p16 != null){
            hashMap.put("p16", this.p16);
        }
        if (p17 != null){
            hashMap.put("p17", this.p17);
        }
        if (p18 != null){
            hashMap.put("p18", this.p18);
        }
        if (p19 != null) {
            hashMap.put("p19", this.p19);
        }

        return hashMap;
    }


    public Long getId() {
        return id;
    }

    public Timestamp getResearch_date() {
        return research_date;
    }

    public District getP1() {
        return p1;
    }

    public Occupation getP2() {
        return p2;
    }

    public Integer getP3() {
        return p3;
    }

    public Boolean getP4() {
        return p4;
    }

    public Boolean getP5() {
        return p5;
    }

    public Boolean getP6() {
        return p6;
    }

    public Boolean getP7() {
        return p7;
    }

    public Boolean getP8() {
        return p8;
    }

    public Boolean getP9() {
        return p9;
    }

    public Boolean getP10() {
        return p10;
    }

    public Boolean getP11() {
        return p11;
    }

    public Boolean getP12() {
        return p12;
    }

    public Boolean getP13() {
        return p13;
    }

    public Boolean getP14() {
        return p14;
    }

    public Boolean getP15() {
        return p15;
    }

    public Boolean getP16() {
        return p16;
    }

    public Boolean getP17() {
        return p17;
    }

    public Boolean getP18() {
        return p18;
    }

    public Boolean getP19() {
        return p19;
    }
}
