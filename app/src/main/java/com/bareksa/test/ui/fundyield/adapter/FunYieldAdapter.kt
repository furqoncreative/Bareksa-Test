package com.bareksa.test.ui.fundyield.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bareksa.test.R
import com.bareksa.test.data.model.fund.Fund
import com.bareksa.test.databinding.FundItemBinding
import com.bumptech.glide.Glide

class FunYieldAdapter(val context: Context) :
    RecyclerView.Adapter<FunYieldAdapter.TvShowViewHolder>() {


    private val items = ArrayList<Fund>()

    fun setItems(items: ArrayList<Fund>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding: FundItemBinding =
            FundItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) =
        holder.bind(items[position])

    inner class TvShowViewHolder(
        private val itemBinding: FundItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        private lateinit var item: Fund

        fun bind(item: Fund) {
            this.item = item
            itemBinding.apply {
                tvFundName.text = item.fundName
                tvFundType.text = item.fundType
                tvFundYield.text = item.fundYield
                tvLaunchDate.text = item.launchDate
                tvMinimumPurchase.text = item.minimumPurchase
                tvRiskLevel.text = item.riskLevel
                tvTimePeriod.text = item.timePeriod
                tvFundManaged.text = item.managedFund
                Glide.with(itemBinding.root).load(item.fundIcon).into(itemBinding.ivFundLogo)

                if (adapterPosition != 0) {
                    textView.visibility = View.INVISIBLE
                    textView2.visibility = View.INVISIBLE
                    textView3.visibility = View.INVISIBLE
                    textView4.visibility = View.INVISIBLE
                    textView5.visibility = View.INVISIBLE
                    textView6.visibility = View.INVISIBLE
                    textView7.visibility = View.INVISIBLE
                }

                if (adapterPosition == 1) {
                    fundName.backgroundTintList = context.getColorStateList(R.color.purple_50)
                    fundType.backgroundTintList = context.getColorStateList(R.color.purple_50)
                    fundYield.backgroundTintList = context.getColorStateList(R.color.purple_50)
                    managedFund.backgroundTintList = context.getColorStateList(R.color.purple_50)
                    minimumPurchase.backgroundTintList = context.getColorStateList(R.color.purple_50)
                    riskLevel.backgroundTintList = context.getColorStateList(R.color.purple_50)
                    launchDate.backgroundTintList = context.getColorStateList(R.color.purple_50)
                    timePeriod.backgroundTintList = context.getColorStateList(R.color.purple_50)
                }

                if (adapterPosition == 2) {
                    fundName.backgroundTintList = context.getColorStateList(R.color.navy_50)
                    fundType.backgroundTintList = context.getColorStateList(R.color.navy_50)
                    fundYield.backgroundTintList = context.getColorStateList(R.color.navy_50)
                    managedFund.backgroundTintList = context.getColorStateList(R.color.navy_50)
                    minimumPurchase.backgroundTintList = context.getColorStateList(R.color.navy_50)
                    riskLevel.backgroundTintList = context.getColorStateList(R.color.navy_50)
                    launchDate.backgroundTintList = context.getColorStateList(R.color.navy_50)
                    timePeriod.backgroundTintList = context.getColorStateList(R.color.navy_50)
                }
            }
        }

    }

}


