object RetrofitInstance {
    val api : GithubApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/search/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubApi::class.java)
    }
}

class Retrofit {

}
