package br.senai.sp.jandira.tcc.model.troussea

import br.senai.sp.jandira.tcc.model.article.articleList
import br.senai.sp.jandira.tcc.model.consultData.consultDataList
import br.senai.sp.jandira.tcc.model.medicalRecord.MedicalRecordListDataConsult
import br.senai.sp.jandira.tcc.model.timeLine.timeLineList
import br.senai.sp.jandira.tcc.model.timeLine.timeLineSemanaList
import br.senai.sp.jandira.tcc.model.troussea.trousseauBody.TrousseauBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TrousseauService {

    @GET("enxoval")
    fun getTrousseau(): retrofit2.Call<TrousseauList2>

    @GET("enxoval/categoria")
    fun getTrousseauCategory(@Query("categoria") categoria: String): retrofit2.Call<TrousseauList2>

    @GET("enxoval/favorito/{id}")
    fun getTrousseauFavorite(@Path("id") id: Int): retrofit2.Call<TrousseauListFavorite2>

    @POST("enxoval/favorito")
    fun insertTrousseau(@Body trousseauBody: TrousseauBody): retrofit2.Call<TrousseauListFavorite2>
    @DELETE("enxoval/favorito")
    fun deleteTrousseau(@Query("idEnxoval") enxoval: Int, @Query("idGestante") gestante: Int): retrofit2.Call<TrousseauListFavorite2>

    @GET("timeline")

    fun getTimeLine(): Call<timeLineList>
    @GET("artigos")
    fun getArticle(): Call<articleList>

    @GET("artigos/{id}")
    fun getArticleId(@Path("id") id: Int): Call<articleList>

    @GET("timeline/{id}")
    fun getTimeLineID(@Path("id") id: Int): Call<timeLineSemanaList>

    // obter dados de uma consulta
    @GET("consulta/{id}")
    fun getConsultData(@Path("id") id: Int): Call<consultDataList>
}