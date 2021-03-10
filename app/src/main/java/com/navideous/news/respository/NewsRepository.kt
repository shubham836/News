package com.navideous.news.respository

import com.navideous.news.api.RetrofitInstance
import com.navideous.news.db.ArticleDatabase
import com.navideous.news.models.Article

class NewsRepository(val db:ArticleDatabase) {

    suspend fun getBreakingNews(countryCode:String,pageNumber:Int)=
            RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchForNews(searchQuery:String, pageNumber: Int)=
            RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article:Article){
        db.getArticleDao().upsert(article)
    }

    fun getSavedNews()=db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article)=db.getArticleDao().deleteArticle(article)

}