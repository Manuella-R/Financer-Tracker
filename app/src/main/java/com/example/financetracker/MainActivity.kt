import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.financetracker.databinding.ActivityMainBinding
import com.example.financetracker.Expense

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ExpenseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView and set its LayoutManager
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize Adapter for the RecyclerView
        val adapter = ExpenseAdapter { expense ->
            // Handle deleting the expense
            viewModel.deleteExpense(expense)
        }
        binding.recyclerView.adapter = adapter

        // Observe LiveData and update the RecyclerView whenever data changes
        viewModel.allExpenses.observe(this, Observer { expenses ->
            expenses?.let {
                adapter.setExpenses(it)
            }
        })

        // Save Button Click Listener to insert an expense
        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val amount = binding.amountEditText.text.toString().toDoubleOrNull()
            val date = binding.dateEditText.text.toString()

            if (title.isNotEmpty() && amount != null && date.isNotEmpty()) {
                // Create an Expense object and insert it into the database
                val expense = Expense(title = title, amount = amount, date = date)
                viewModel.insertExpense(expense)

                // Optionally, clear the EditTexts after saving
                binding.titleEditText.text.clear()
                binding.amountEditText.text.clear()
                binding.dateEditText.text.clear()
            }
        }
    }
}
