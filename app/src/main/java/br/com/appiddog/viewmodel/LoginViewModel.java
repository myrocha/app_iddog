package br.com.appiddog.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import br.com.appiddog.model.Access;
import br.com.appiddog.model.User;
import br.com.appiddog.repository.LoginRepository;

/**
 * view screen login screen.
 */
public class LoginViewModel extends ViewModel {

    public final MutableLiveData<String> email = new MutableLiveData<>();

    @Inject
    public LoginRepository loginRepository;

    public LoginViewModel(LoginRepository repository){
        this.loginRepository = repository;
    }

    /**
     * access the repository to login.
     * @return
     */
    public LiveData<User> onLogin() {
        Access access = new Access();
        access.setEmail(email.getValue());
        return loginRepository.onLogin(access);


    }



}
