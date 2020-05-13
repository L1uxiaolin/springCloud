package lxl.imitation.business.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lxl.imitation.business.user.mapper.TicketMapper;
import lxl.imitation.business.user.model.Ticket;
import lxl.imitation.business.user.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @author lxl
 * @date 2020/3/24  16:22
 */
@Service
public class TicketServiceImpl extends ServiceImpl<TicketMapper,Ticket> implements TicketService {
}
