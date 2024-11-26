import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.financetracker.databinding.ActivityMainBinding
import com.example.financetracker.Expense

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ExpenseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ExpenseAdapter { expense ->
            // Handle deleting the expense
            viewModel.deleteExpense(expense)
        }

        binding.recyclerView.adapter = adapter

        viewModel.allExpenses.observe(this, Observer { expenses ->
            expenses?.let {
                adapter.setExpenses(it)
            }
        })

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val amount = binding.amountEditText.text.toString().toDoubleOrNull()
            val date = binding.dateEditText.text.toString()

            if (title.isNotEmpty() && amount != null && date.isNotEmpty()) {
                val expense = Expense(title = title, amount = amount, date = date)
                viewModel.insertExpense(expense)
            }
        }
    }
}
