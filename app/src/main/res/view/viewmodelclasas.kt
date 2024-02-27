class GitHubViewModel : ViewModel() {
    // Create a MutableLiveData object to
    // hold the list of GitHub repositories
    private var githubLiveData = MutableLiveData<List<Item>>()
    // Fetch the list of Kotlin repositories
    // from the GitHub API using Retrofit
    fun getAllKotlinRepos(){
        RetrofitInstance.api.getKotlinRepos("language:kotlin",">2022-12-19")
            .enqueue(object : Callback<Repo>{
                override fun onResponse(call: Call<Repo>, response: Response<Repo>) {
                    // If the API call is successful and the response body is not null,
                    // set the value of githubLiveData to the list of repositories returned by the API
                    if (response.body() != null){
                        githubLiveData.value = response.body()!!.items
                    } else {
                        return
                    }
                }

                // If the API call fails, log the error message using Logcat
                override fun onFailure(call: Call<Repo>, t: Throwable) {
                    Log.d("TAG",t.message.toString())
                }
            })
    }
    // Expose the list of repositories as LiveData
    // so it can be observed by the UI
    fun observeGitHubLiveData() : LiveData<List<Item>>{
        return githubLiveData
    }
} 
