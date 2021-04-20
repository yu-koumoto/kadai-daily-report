package models;

import java.sql.Date;//日付データを管理するためのクラスDateは年月日
import java.sql.Timestamp;//日付データ管理クラスで秒まで情報管理

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;//テキストエリアの指定を行うアノテーション改行もデータベースに保存される
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "reports")
@NamedQueries({
        @NamedQuery(name = "getAllReports", query = "SELECT r FROM Report AS r ORDER BY r.id DESC"),
        @NamedQuery(name = "getReportsCount", query = "SELECT COUNT(r) FROM Report AS r"),
})
@Entity
public class Report {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    /*ManyToOneについて
     * 日報報告書を毎日書いたときにaが4日分の日報を出したとき
     * aは4日分の日報をもっているが日報から見たときに作成者は1人なので
     * 1対多の関係となる
     * その1対多の関係性をManyToOneでデータベースに指定する。
     * テーブルAとテーブルBがあるとします。
    このときテーブルBに、テーブルAのidを保持するカラムを追加します。
    このような方法を 外部キー（外部キー制約） と呼ばれています。*/


    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;//Employeeクラスをemployeeフィールドに格納する

    @Column(name = "report_date", nullable = false)
    private Date report_date;//日付管理

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

}