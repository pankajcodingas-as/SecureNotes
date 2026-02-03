package pk.coding.`as`.securenotes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pk.coding.`as`.securenotes.databinding.ActivitySafeBinding
import pk.coding.`as`.securenotes.databinding.SafeLayoutBinding
import pk.coding.`as`.securenotes.model.Safe

class SafeAdapter(
    private val onSafeChick: (Safe)-> Unit,
    private val onSafeLongClick: (Safe)-> Boolean
): ListAdapter<Safe, SafeAdapter.SafeViewHolder>(diffUtil()) {

    class diffUtil : DiffUtil.ItemCallback<Safe>(){
        override fun areItemsTheSame(
            oldItem: Safe,
            newItem: Safe
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Safe,
            newItem: Safe
        ): Boolean {
            return oldItem == newItem
        }

    }
    class SafeViewHolder(val safeLayoutBinding: SafeLayoutBinding):
        RecyclerView.ViewHolder(safeLayoutBinding.root){

            fun bind(safe: Safe, onSafeChick: (Safe)-> Unit, onSafeLongClick: (Safe)-> Boolean){
                safeLayoutBinding.slSafeNameTV.text = safe.safeName

                safeLayoutBinding.slSafeLL.setOnClickListener {
                    onSafeChick(safe)
                }

                safeLayoutBinding.slSafeLL.setOnLongClickListener {
                    onSafeLongClick(safe)
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SafeViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val safeLayoutBinding = SafeLayoutBinding.inflate(layoutInflater, parent, false)
        return SafeViewHolder(safeLayoutBinding)
    }

    override fun onBindViewHolder(
        holder: SafeViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position), onSafeChick, onSafeLongClick)

    }

}