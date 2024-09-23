package school.hei.repository;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Pageable {
    Integer page;
    Integer pageSize;

    public String toPageableSql(String sql){
        return createPageableSql(this.page, this.pageSize, sql);
    }

    public static String createPageableSql(Integer page, Integer pageSize, String sql){
        return sql + " offset " + (page - 1) + " limit " + pageSize;
    }
}