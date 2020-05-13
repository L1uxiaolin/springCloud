package lxl.imitation.business.user.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lxl
 * @date 2020/3/24  16:20
 */
@Data
@TableName("ticket")
public class Ticket extends SuperEntity{
    private String ticketTrack;
    private Long payerId;
}
