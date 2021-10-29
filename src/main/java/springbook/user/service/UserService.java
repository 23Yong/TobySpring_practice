package springbook.user.service;

import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import java.util.List;

public class UserService {
    UserDao userDao;
    UserLevelUpgradePolicy upgradePolicy;

    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECOMMEND_FOR_GOLD = 30;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void setUpgradePolicy(UserLevelUpgradePolicy upgradePolicy) { this.upgradePolicy = upgradePolicy; }

    public void upgradeLevels() {
        List<User> users = userDao.getAll();
        for(User user : users) {
            if(upgradePolicy.canUpgradeLevel(user)) {
                upgradePolicy.upgradeLevel(user);
            }
        }
    }

    public void add(User user) {
        if(user.getLevel() == null) user.setLevel(Level.BASIC);
        userDao.add(user);
    }
}
