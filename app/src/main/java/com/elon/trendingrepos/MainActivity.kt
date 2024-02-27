package com.elon.trendingrepos

import android.os.Bundle

class RepoDetails : AppCompatActivity() {
    private lateinit var binding : ActivityRepoDetailsBinding // View binding for the activity
    private lateinit var fullName : String // The full name of the repository
    private var starCount = 0 // The number of stars that the repository has
    private var forkCount = 0 // The number of forks that the repository has
    private lateinit var image : String // The URL of the owner's avatar image
    private lateinit var description : String // The description of the repository
    private lateinit var ownerName : String // The name of the repository's owner
    private lateinit var webUrl : String // The URL of the repository's webpage

    // This function is called when the activity is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepoDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the values of the views
        setViews()

        // Initialize the views with the values
        initialViews()
    }

    // This function sets the values of the views from the intent extras
    private fun setViews() {
        fullName = intent.getStringExtra(MainActivity.FULL_NAME).toString()
        starCount = intent.getIntExtra(MainActivity.STARGAZERS_COUNT,0)
        forkCount = intent.getIntExtra(MainActivity.FORK_COUNT,0)
        image = intent.getStringExtra(MainActivity.IMG).toString()
        description = intent.getStringExtra(MainActivity.DESCRIPTION).toString()
        ownerName = intent.getStringExtra(MainActivity.OWNERNAME).toString()
        webUrl = intent.getStringExtra(MainActivity.Web_URL).toString()
    }

    // This function initializes the views with the values
    private fun initialViews() {
        binding.tvName.text = fullName
        binding.starCount.text = "$starCount Stars"
        binding.forkCount.text = "$forkCount Forks"
        binding.desc.text = description
        binding.tvName1.text = ownerName
        binding.webView.loadUrl(webUrl)
        Glide.with(applicationContext).load(image).into(binding.ownerAvatarImage)
        binding.btnBack.setOnClickListener {
            startActivity(Intent(this@RepoDetails,MainActivity::class.java))
        }
    }
}

open class AppCompatActivity {

}
}