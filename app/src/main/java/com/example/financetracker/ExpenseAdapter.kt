import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.financetracker.R
import com.example.financetracker.Expense

class ExpenseAdapter(private val onDeleteClick: (Expense) -> Unit) :
    RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    private var expenses = emptyList<Expense>()  // Holds the list of expenses

    // ViewHolder class that holds references to the views in the layout
    class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val amountTextView: TextView = itemView.findViewById(R.id.textAmount)
        val titleTextView: TextView = itemView.findViewById(R.id.textTitle)
        val dateTextView: TextView = itemView.findViewById(R.id.textDate)
    }

    // Creates a new ViewHolder when there is no existing one to reuse
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expense, parent, false)
        return ExpenseViewHolder(view)
    }

    // Binds data to the views in the ViewHolder
    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expenses[position]

        // Bind the expense data to the views
        holder.titleTextView.text = "Title: ${expense.title}"
        holder.amountTextView.text = "Amount: $${expense.amount}"
        holder.dateTextView.text = "Date: ${expense.date}"

        // Handle long click to delete the expense
        holder.itemView.setOnLongClickListener {
            onDeleteClick(expense)  // Call delete method when item is long-clicked
            true
        }
    }

    // Returns the total number of items in the list
    override fun getItemCount(): Int = expenses.size

    // This method updates the list of expenses in the adapter
    fun setExpenses(newExpenses: List<Expense>) {
        expenses = newExpenses
        notifyDataSetChanged()  // Notify the adapter that the data set has changed
    }
}
