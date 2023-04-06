package com.timesheet.service;

import com.timesheet.dto.UserInformationDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserInformationService {

    UserInformationDTO getTotalTimeByDay(UserInformationDTO userInformationDTO);

}
