package pk.coding.`as`.securenotes.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import pk.coding.`as`.securenotes.R
import pk.coding.`as`.securenotes.adapter.SafeAdapter
import pk.coding.`as`.securenotes.database.SecureNoteDatabase
import pk.coding.`as`.securenotes.databinding.ActivitySafeBinding
import pk.coding.`as`.securenotes.model.Safe
import pk.coding.`as`.securenotes.repository.SafeRepository
import pk.coding.`as`.securenotes.viewmodel.SafeViewModel
import pk.coding.`as`.securenotes.viewmodel.SafeViewModelFactory

class SafeActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySafeBinding
    private lateinit var safeViewModel: SafeViewModel
    var safeSelected: Safe = Safe(0,"","",0)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivitySafeBinding>(this, R.layout.activity_safe)


        supportActionBar?.title = "Safe Activity"

        val safeDao = SecureNoteDatabase.getDatabase(this).safeDao()
        val safeRepository = SafeRepository(safeDao)
        safeViewModel = ViewModelProvider(this, SafeViewModelFactory(safeRepository))[SafeViewModel::class.java]



        val safeAdapter = SafeAdapter({
            val intent = Intent(this, NoteActivity::class.java)
            intent.putExtra("safeName", it.safeName)
            if(it.passwordEnable == 1)
            {
                binding.saMsgTV.visibility = View.INVISIBLE
                binding.saSafeNameET.visibility = View.INVISIBLE
                binding.saAddBtn.visibility = View.INVISIBLE
                binding.saSafePasswordET.visibility = View.VISIBLE
                binding.saEnterBtn.visibility = View.VISIBLE
                binding.saFab.visibility = View.VISIBLE
                safeSelected = it

            }
            else{
                startActivity(intent)
            }

        },{
            val intent = Intent(this, UpdateDeleteSafeActivity::class.java)
            intent.putExtra("safeName", it.safeName)
            startActivity(intent)
            true
        })

        binding.saEnterBtn.setOnClickListener {
            val password = binding.saSafePasswordET.text.toString().trim()
            if(password == safeSelected.password)
            {
                binding.saSafePasswordET.text.clear()
                binding.saMsgTV.visibility = View.VISIBLE
                binding.saSafeNameET.visibility = View.INVISIBLE
                binding.saAddBtn.visibility = View.INVISIBLE
                binding.saSafePasswordET.visibility = View.INVISIBLE
                binding.saEnterBtn.visibility = View.INVISIBLE
                binding.saFab.visibility = View.VISIBLE

                val intent = Intent(this, NoteActivity::class.java)
                intent.putExtra("safeName", safeSelected.safeName)
                startActivity(intent)
                safeSelected = Safe(0,"","",0)

            }
            else{
                binding.saSafePasswordET.text.clear()
                binding.saMsgTV.visibility = View.VISIBLE
                binding.saSafeNameET.visibility = View.INVISIBLE
                binding.saAddBtn.visibility = View.INVISIBLE
                binding.saSafePasswordET.visibility = View.INVISIBLE
                binding.saEnterBtn.visibility = View.INVISIBLE
                binding.saFab.visibility = View.VISIBLE
                binding.saMsgTV.text = "Incorrect Password"
            }

        }


        safeViewModel.getAllSafe().observe(this) {safe->
            binding.saRV.adapter = safeAdapter
            safeAdapter.submitList(safe)
        }

        binding.saFab.setOnClickListener {
            binding.saMsgTV.visibility = View.INVISIBLE
            binding.saSafeNameET.visibility = View.VISIBLE
            binding.saAddBtn.visibility = View.VISIBLE
            binding.saSafePasswordET.visibility = View.INVISIBLE
            binding.saEnterBtn.visibility = View.INVISIBLE
            binding.saFab.visibility = View.INVISIBLE
        }

        binding.saAddBtn.setOnClickListener {
            val safeName = binding.saSafeNameET.text.toString()
            val safe = Safe(0, safeName, "1234", 0)
            safeViewModel.addSafe(safe)

            binding.saMsgTV.visibility = View.VISIBLE
            binding.saSafeNameET.visibility = View.INVISIBLE
            binding.saAddBtn.visibility = View.INVISIBLE
            binding.saSafePasswordET.visibility = View.INVISIBLE
            binding.saEnterBtn.visibility = View.INVISIBLE
            binding.saFab.visibility = View.VISIBLE

        }





    }
}