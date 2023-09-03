package com.example.picpay.Services.Impl.Users;

import com.example.picpay.Entity.Users.UsersEntity;
import com.example.picpay.Entity.wallet.WalletEntity;
import com.example.picpay.Repositories.Users.UsersRepository;
import com.example.picpay.Repositories.Wallet.WalletRepository;
import com.example.picpay.Services.Users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    WalletRepository walletRepository;
    @Override
    public UsersEntity saveUsers(UsersEntity usersEntity) throws Exception {
        try {
            UsersEntity userSaved = usersRepository.save(usersEntity);

            walletRepository.save(WalletEntity
                    .builder()
                    .user(userSaved)
                    .balance(BigDecimal.ZERO)
                    .build());

            return userSaved;
        }catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public List<UsersEntity> getAllUsers() throws Exception {
        try {
            return usersRepository.findAll();
        }catch(Exception e){
            throw new Exception(e);
        }
    }
}
