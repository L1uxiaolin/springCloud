package lxl.imitation.business.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author lxl
 * @date 2020/3/16  18:17
 */
@Data
public class SuperEntity {
    @TableId(value = "id", type= IdType.AUTO)
    private Long id;
}
