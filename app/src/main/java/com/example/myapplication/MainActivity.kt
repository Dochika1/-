import android.R
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.midtermbtueasy.SecondActivity

class MainActivity : AppCompatActivity() {
    private var recipientNumberEditText: EditText? = null
    private var messageEditText: EditText? = null
    private var sendButton: Button? = null

    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Layout for MainActivity

        // Initialize views
        recipientNumberEditText = findViewById(R.id.recipientNumber)
        messageEditText = findViewById(R.id.message)
        sendButton = findViewById(R.id.sendButton)

        // Set button click listener
        sendButton!!.setOnClickListener { sendMessage() }
    }

    // Method to validate and send message
    private fun sendMessage() {
        val recipientNumber = recipientNumberEditText!!.text.toString().trim { it <= ' ' }
        val message = messageEditText!!.text.toString().trim { it <= ' ' }

        // Check if recipient number and message are entered
        if (TextUtils.isEmpty(recipientNumber)) {
            Toast.makeText(this, "Please enter recipient's number", Toast.LENGTH_SHORT).show()
            return
        }
        if (TextUtils.isEmpty(message)) {
            Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
            return
        }

        // Check if recipient number contains only digits
        if (!recipientNumber.matches("\\d+".toRegex())) {
            Toast.makeText(this, "Recipient's number must contain only digits", Toast.LENGTH_SHORT)
                .show()
            return
        }

        // Check if message length is within the limit (250 characters)
        if (message.length > 250) {
            Toast.makeText(this, "Message cannot exceed 250 characters", Toast.LENGTH_SHORT).show()
            return
        }

        // Intent to start the second activity and pass the recipient number and message
        val intent: Intent = Intent(
            this@MainActivity,
            SecondActivity::class.java
        )
        intent.putExtra("recipientNumber", recipientNumber)
        intent.putExtra("message", message)
        ContextCompat.startActivity(intent)
    }
}