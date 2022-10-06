package uz.master.session;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uz.master.spring.UserDetails;

@Service
public class SessionUser {
    private Long Id;
    private Long orgId;
    private String code;

    public UserDetails getInstance() {
        return  (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    }
    public Long getId() {
        return getInstance().getId();
    }

}
