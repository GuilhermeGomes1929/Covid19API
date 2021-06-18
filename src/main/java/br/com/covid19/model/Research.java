package br.com.covid19.model;

import javax.persistence.*;

@Entity
public class Research {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


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

    public Research(Long id, District p1, Occupation p2, Integer p3, Boolean p4, Boolean p5, Boolean p6, Boolean p7, Boolean p8, Boolean p9, Boolean p10, Boolean p11, Boolean p12, Boolean p13, Boolean p14, Boolean p15, Boolean p16, Boolean p17, Boolean p18, Boolean p19) {
        this.id = id;
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

    public Long getId() {
        return id;
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
