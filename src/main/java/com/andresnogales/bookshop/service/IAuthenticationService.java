package com.andresnogales.bookshop.service;

import com.andresnogales.bookshop.model.User;

public interface IAuthenticationService {

	User signInAndReturnJWT(User signRequest);
}
