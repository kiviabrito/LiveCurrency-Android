package com.example.livecurrency.utility

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.livecurrency.R
import com.example.livecurrency.model.CurrencyEntity
import java.util.*
import kotlin.collections.ArrayList

interface OnItemClickListener{
  fun onItemClicked(item: CurrencyEntity)
}

class CurrencyAdapter(private var items: ArrayList<CurrencyEntity>, var clickResponse : OnItemClickListener) :
  RecyclerView.Adapter<CurrencyAdapter.UserViewHolder>(), Filterable {

  private var filterItems = items

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_currency_list, parent, false)
    return UserViewHolder(view)
  }

  override fun getItemCount(): Int {
    return filterItems.size
  }

  fun setItemsAdapter(newList: ArrayList<CurrencyEntity>) {
    val oldList = filterItems
    val diffCallback =
      PostDiffCallback(oldList, newList)
    val diffResult = DiffUtil.calculateDiff(diffCallback)
    filterItems = newList
    if (items.isEmpty()) {
      items = newList
    }
    diffResult.dispatchUpdatesTo(this)
  }

  fun getItems(): ArrayList<CurrencyEntity> {
    return filterItems
  }

  override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
    val item = filterItems[position]
    holder.currencyTextView.text = "${item.currencyCode} - ${item.currencyName}"
    holder.currencyTextView.setOnClickListener {
      clickResponse.onItemClicked(item)
    }
  }

  class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var currencyTextView: TextView = view.findViewById(R.id.currency_text) as TextView
  }

  class PostDiffCallback(
    private val oldList: List<CurrencyEntity>,
    private val newList: List<CurrencyEntity>
  ) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
      return oldList.size
    }

    override fun getNewListSize(): Int {
      return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
      return oldList[oldItemPosition].currencyName == newList[newItemPosition].currencyName
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
      return oldList[oldItemPosition].equals(newList[newItemPosition])
    }
  }

  override fun getFilter(): Filter {
    return object : Filter() {
      override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
        filterItems = filterResults.values as ArrayList<CurrencyEntity>
        notifyDataSetChanged()
      }

      override fun performFiltering(charSequence: CharSequence?): FilterResults {
        val keyWords = charSequence?.toString()?.toLowerCase(Locale.ROOT)
        val filterResults = FilterResults()
        val suggestions = if (keyWords == null || keyWords.isEmpty())
          items
        else {
          items.filter {
            it.currencyCode.toLowerCase(Locale.ROOT).contains(keyWords) ||
                it.currencyName.toLowerCase(Locale.ROOT).contains(keyWords)
          }
        }
        filterResults.values = suggestions
        filterResults.count = suggestions.count()
        return filterResults
      }
    }
  }
}