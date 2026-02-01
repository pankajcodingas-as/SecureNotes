package pk.coding.`as`.securenotes.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import pk.coding.`as`.securenotes.R
import pk.coding.`as`.securenotes.database.SecureNoteDatabase
import pk.coding.`as`.securenotes.databinding.ActivitySafeBinding
import pk.coding.`as`.securenotes.viewmodel.SafeViewModel

class SafeActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySafeBinding
    private lateinit var safeViewModel: SafeViewModel
    private var database: SecureNoteDatabase? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivitySafeBinding>(this, R.layout.activity_safe)

       





    }
}