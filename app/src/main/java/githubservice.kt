interface githubservice {
    @GET("repositories?")
    fun getKotlinRepos(@Query("q") q : String, @Query("pushed") date: String) : Call<Repo>
}
