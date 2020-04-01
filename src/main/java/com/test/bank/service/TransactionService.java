package com.test.bank.service;

import com.test.bank.initializer.DataSourceInitializer;
import com.test.bank.model.TransferResponse;
import org.jooq.impl.DefaultConfiguration;

import javax.inject.Inject;
import javax.inject.Singleton;
import org.jooq.impl.DSL;
import static com.test.bank.db.Tables.USER;
import org.jooq.Record1;
import com.test.bank.model.User;

@Singleton
public class TransactionService {

    DefaultConfiguration jooqConfiguration;

    @Inject
    public TransactionService(DataSourceInitializer dataSourceInitializer) {
        this.jooqConfiguration = dataSourceInitializer.getJooqConfiguration();
    }

    public TransferResponse transfer(int fromUserId, int toUserId, int amount) {
         Record1<Integer> fromUserWallet = DSL.using(jooqConfiguration).select(USER.WALLET)
                .from(USER)
                .where(USER.ID.eq(org.jooq.types.UInteger.valueOf(fromUserId)))
                .fetchAny();
         Record1<Integer> toUserWallet = DSL.using(jooqConfiguration).select(USER.WALLET)
                .from(USER)
                .where(USER.ID.eq(org.jooq.types.UInteger.valueOf(toUserId)))
                .fetchAny();
         Integer _fromUserWallet = fromUserWallet.value1();
         Integer _toUserWallet = toUserWallet.value1();
         Integer _amount = amount;
         if (_fromUserWallet >= _amount){
             _fromUserWallet -= _amount;
             _toUserWallet += _amount;
             DSL.using(jooqConfiguration).update(USER)
                     .set(USER.WALLET, _fromUserWallet)
                     .where(USER.ID.eq(org.jooq.types.UInteger.valueOf(fromUserId)))
                     .execute();
             DSL.using(jooqConfiguration).update(USER)
                     .set(USER.WALLET, _toUserWallet)
                     .where(USER.ID.eq(org.jooq.types.UInteger.valueOf(toUserId)))
                     .execute();

             User fromUser = new User();
             fromUser.setId(Integer.valueOf(fromUserId));
             fromUser.setWallet(_fromUserWallet);
             User toUser = new User();
             toUser.setId(Integer.valueOf(toUserId));
             toUser.setWallet(_toUserWallet);
             TransferResponse response= new TransferResponse();
             response.setFromUser(fromUser);
             response.setToUser(toUser);
             return response;
         }
        return null;
    }
}
