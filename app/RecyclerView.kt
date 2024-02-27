class GitHubAdapter() : RecyclerView.Adapter<GitHubAdapter.ViewHolder>() {

    // ArrayList of data items to be
    // displayed in the RecyclerView
    var data = ArrayList<Item>()

    // Interface to handle click events on the RecyclerView items
    private lateinit var setOnGitHubRepoClickListener: SetOnGitHubRepoClickListener

    // Function to set the click listener on the RecyclerView items
    fun setOnGitHubRepoClickListener(setOnGitHubRepoClickListener: SetOnGitHubRepoClickListener) {
        this.setOnGitHubRepoClickListener = setOnGitHubRepoClickListener
    }

    // Function to update the data items in the RecyclerView
    // and notify the adapter of changes
    fun setData(data : List<Item>){
        this.data = data as ArrayList<Item>
        notifyDataSetChanged()
    }

    // ViewHolder class for a single item in the RecyclerView
    class ViewHolder(val binding: RecyclerLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    // Called when a new ViewHolder is needed, inflates the layout
    // for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerLayoutBinding.inflate(LayoutInflater.from(parent.context) ,parent,false)
        )
    }

    // Called for each item in the list, sets the values for
    // the various UI elements in the ViewHolder layout
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Set the name of the repository in the ViewHolder layout
        holder.binding.repoName.text = data[position].name

        // Set the number of stars for the
        // repository in the ViewHolder layout
        var max = 0
        if (data[position].stargazers_count> max){
            max = data[position].stargazers_count
            holder.binding.noOfStars.text = max.toString()
        }

        // Set the description of the repository in the ViewHolder layout
        holder.binding.description.text = data[position].description

        // Set an OnClickListener on the ViewHolder item view,
        // which triggers the setOnClickListener() function
        // on the setOnGitHubRepoClickListener interface
        // when the item is clicked
        holder.itemView.setOnClickListener{
            setOnGitHubRepoClickListener.setOnClickListener(data[position])
        }
    }

    // Returns the number of items
    // in the data ArrayList
    override fun getItemCount(): Int {
        return data.size
    }

    // Interface to handle click events
    // on the RecyclerView items
    interface SetOnGitHubRepoClickListener{
        fun setOnClickListener(item : Item)
    }
}
