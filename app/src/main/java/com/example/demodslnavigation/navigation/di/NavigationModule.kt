package com.example.demodslnavigation.navigation.di

import androidx.navigation.NavController
import com.example.bottomnavigation.BottomNavigationScreenNavigationManager
import com.example.demodslnavigation.MainActivity
import com.example.demodslnavigation.navigation.managers.BottomNavigationScreenNavigationManagerImpl
import com.example.demodslnavigation.navigation.managers.FirstScreenNavigationManagerImpl
import com.example.demodslnavigation.navigation.managers.SecondScreenNavigationManagerImpl
import com.example.demodslnavigation.navigation.managers.ThirdScreenNavigationManagerImpl
import com.example.firstscreen.FirstScreenNavigationManager
import com.example.seconscreen.SecondScreenNavigationManager
import com.example.thirdscreen.ThirdScreenNavigationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    fun provideFirstScreenNavigationManager(): FirstScreenNavigationManager {
        return FirstScreenNavigationManagerImpl()
    }

    @Provides
    @Singleton
    fun provideSecondScreenNavigationManager(): SecondScreenNavigationManager {
        return SecondScreenNavigationManagerImpl()
    }

    @Provides
    @Singleton
    fun provideThirdScreenNavigationManager(): ThirdScreenNavigationManager {
        return ThirdScreenNavigationManagerImpl()
    }

    @Provides
    @Singleton
    fun provideBottomNavigationScreenNavigationManager(): BottomNavigationScreenNavigationManager {
        return BottomNavigationScreenNavigationManagerImpl()
    }
}