package com.example.androidtest.repository

import androidx.lifecycle.LiveData
import com.example.androidtest.AppExecutors
import com.example.androidtest.api.JSONPlaceholderService
import com.example.androidtest.db.UserDao
import com.example.androidtest.vo.Resource
import com.example.androidtest.vo.User
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository that handles User objects.
 */
@Singleton
class UserRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val userDao: UserDao,
    private val jsonPlaceholderService: JSONPlaceholderService
) {
    fun loadUser(id: Int): LiveData<Resource<User>> {
        return object : NetworkBoundResource<User, User>(appExecutors) {
            override fun saveCallResult(item: User) {
                userDao.insert(item)
            }
            override fun shouldFetch(data: User?) = data == null

            override fun loadFromDb() = userDao.findById(id)

            override fun createCall() = jsonPlaceholderService.getUser(id)
        }.asLiveData()
    }
}
