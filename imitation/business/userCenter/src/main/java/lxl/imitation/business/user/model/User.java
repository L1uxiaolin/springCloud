package lxl.imitation.business.user.model;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lxl
 * @date 2020/3/16  18:10
 */
@Data
@TableName("user")
public class User extends SuperEntity{
    private String userNickname;
    private byte userSex;
    private long userHeadPortraitId;
}
