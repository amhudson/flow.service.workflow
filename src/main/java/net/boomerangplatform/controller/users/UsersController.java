package net.boomerangplatform.controller.users;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import net.boomerangplatform.client.model.UserProfile;
import net.boomerangplatform.mongo.entity.FlowUserEntity;
import net.boomerangplatform.service.UserIdentityService;

@RestController
@RequestMapping("/flow/users")
@ConditionalOnProperty(value = "boomerang.standalone", havingValue = "true", matchIfMissing = false)
public class UsersController {


  @Autowired
  @Qualifier("internalRestTemplate")
  private RestTemplate restTemplate;

  @Autowired
  private UserIdentityService userIdentiyService;

  @GetMapping(value = "/profile")
  public UserProfile getUserWithEmail() {
    FlowUserEntity currentUser = userIdentiyService.getCurrentUser();
    if (currentUser != null) {
      UserProfile userProfile = new UserProfile();
      BeanUtils.copyProperties(currentUser, userProfile);
      return userProfile;
    } else {
      throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
    }
  }
}
