package service;

import model.UserModel;
import model.request.UserRequest;

public interface IUserService {
    UserModel findUserByUserNameAndPassword(UserRequest userRequest);
}
