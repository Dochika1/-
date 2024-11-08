import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private var displayedNumberTextView: TextView? = null
    private var displayedMessageTextView: TextView? = null
    private var clearButton: Button? = null

    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second) // Layout for SecondActivity

        // Initialize views
        displayedNumberTextView = findViewById(R.id.displayedNumber)
        displayedMessageTextView = findViewById(R.id.displayedMessage)
        clearButton = findViewById(R.id.clearButton)

        // Retrieve the recipient number and message passed from MainActivity
        val recipientNumber = Intent.getIntent().getStringExtra("recipientNumber")
        val message = Intent.getIntent().getStringExtra("message")

        // Set the recipient number and message to TextViews
        displayedNumberTextView!!.text = recipientNumber
        displayedMessageTextView!!.text = message

        // Set up the clear button functionality
        clearButton!!.setOnClickListener { v: View? ->
            displayedNumberTextView!!.text = ""
            displayedMessageTextView!!.text = ""
        }
    }
}