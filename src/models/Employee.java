package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name ="employees")
@NamedQueries({//これから下記に記述する@NamedQueryをまとめるためのアノテーション
    @NamedQuery(//主キー以外の項目などで検索し、複数件の結果を取得したい場合に定義する
         name = "getAllEmployees",//すべての従業員情報を取得
         query ="SELECT e FROM Employee AS e ORDER BY e.id DESC"
         //SELECT e FROM～という命令文委getAllEmployeesという名前をつけているORDER^by^descで降順となる
            ),
    @NamedQuery(
            name = "getEmployeesCount",
            query = "SELECT COUNT(e) FROM Employee AS e"//従業員の全件数を取得
        ),
        @NamedQuery(
            name = "checkRegisteredCode",//指定された社員番号がすでにデータベースに存在しているかを調べます。
            query = "SELECT COUNT(e) FROM Employee AS e WHERE e.code = :code"
        ),
        @NamedQuery(
            name = "checkLoginCodeAndPassword",//従業員がログインするときに社員番号とパスワードが正しいかをチェックするためのものです。
            query = "SELECT e FROM Employee AS e WHERE e.delete_flag = 0 AND e.code = :code AND e.password = :pass"
        )
})
@Entity
public class Employee {
    @Id
    @Column(name = "id")//リソース内での連番
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false, unique = true)//社員番号.nullを許容しない
    private String code;//unique = true一意制約 といい、すでに存在している社員番号は登録できない旨をデータベースに教えてあげるための設定です。

    @Column(name = "name", nullable = false)//社員名
    private String name;

    @Column(name = "password", length = 64, nullable = false)//システムへのログインパスワード
    private String password;

    @Column(name = "admin_flag", nullable = false)//管理者権限があるかどうか
    private Integer admin_flag;

    @Column(name = "created_at", nullable = false)//作成日時
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)//更新日時
    private Timestamp updated_at;

    @Column(name = "delete_flag", nullable = false)//削除された従業員かどうか
    private Integer delete_flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAdmin_flag() {
        return admin_flag;
    }

    public void setAdmin_flag(Integer admin_flag) {
        this.admin_flag = admin_flag;
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

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }



}
