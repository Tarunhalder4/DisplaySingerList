package com.example.interview1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.interview1.databinding.BottomSheetListBinding
import com.example.interview1.databinding.FilterLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetAdapter (private val tag:String,
                          private val list: MutableSet<String>,
                          private val bottomSheet:BottomSheetDialog,
                          private val layoutBinding: FilterLayoutBinding,
                          private val filterAdapter: FilterAdapter): RecyclerView.Adapter<BottomSheetAdapter.ViewHolder>() {

    private lateinit var binding: BottomSheetListBinding
    companion object{
        val filterValue1: MutableLiveData<String> = MutableLiveData()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        binding = BottomSheetListBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.binding.item.text = list[position]
        holder.binding.item.text = list.elementAt(position).toString()

        setBackGroundInFilerList(tag,list.elementAt(position).toString(),holder.binding)

        holder.binding.item.setOnClickListener {

            holder.binding.item.setBackgroundResource(R.color.select_filter_item_Back_ground)

            setValueInFilerList(tag,holder.binding.item.text.toString(), holder.binding,true)
            filterValue1.postValue(Constant.IGNORE_VALUE)

            bottomSheet.dismiss()
        }

    }

    private fun setValueInFilerList(tag: String,value:String, binding: BottomSheetListBinding,flag:Boolean) {
        when (tag) {
            Constant.CURRICULM_ALL ->{
                if (ViewAllActivity.curriculumFilter.contains(value)) {
                    ViewAllActivity.curriculumFilter.remove(value)
                    binding.item.setBackgroundResource(R.color.filter_Back_ground)
                } else {
                    ViewAllActivity.curriculumFilter.add(value)
                    binding.item.setBackgroundResource(R.color.select_filter_item_Back_ground)
                }

                if(ViewAllActivity.curriculumFilter.size == 0){
                    layoutBinding.filterTitle.setBackgroundColor(layoutBinding.root.context.getColor(R.color.filter_Back_ground))
                }else{
                    layoutBinding.filterTitle.setBackgroundColor(layoutBinding.root.context.getColor(R.color.select_filter_item_Back_ground))
                }
            }
            Constant.SERIES_ALL ->{
                if (ViewAllActivity.seriesFilter.contains(value)) {
                    ViewAllActivity.seriesFilter.remove(value)
                } else {
                    ViewAllActivity.seriesFilter.add(value)
                }

                if(ViewAllActivity.seriesFilter.size == 0){
                    layoutBinding.filterTitle.setBackgroundColor(layoutBinding.root.context.getColor(R.color.filter_Back_ground))
                }else{
                    layoutBinding.filterTitle.setBackgroundColor(layoutBinding.root.context.getColor(R.color.select_filter_item_Back_ground))
                }
            }
            Constant.STYLE_ALL ->{
                if (ViewAllActivity.styleFilter.contains(value)) {
                    ViewAllActivity.styleFilter.remove(value)
                } else {
                    ViewAllActivity.styleFilter.add(value)
                }

                if(ViewAllActivity.styleFilter.size == 0){
                    layoutBinding.filterTitle.setBackgroundColor(layoutBinding.root.context.getColor(R.color.filter_Back_ground))
                }else{
                    layoutBinding.filterTitle.setBackgroundColor(layoutBinding.root.context.getColor(R.color.select_filter_item_Back_ground))
                }
            }
            Constant.SKILL_ALL ->{
                if (ViewAllActivity.skillFilter.contains(value)) {
                    ViewAllActivity.skillFilter.remove(value)
                } else {
                    ViewAllActivity.skillFilter.add(value)
                }

                if(ViewAllActivity.skillFilter.size == 0){
                    layoutBinding.filterTitle.setBackgroundColor(layoutBinding.root.context.getColor(R.color.filter_Back_ground))
                }else{
                    layoutBinding.filterTitle.setBackgroundColor(layoutBinding.root.context.getColor(R.color.select_filter_item_Back_ground))
                }
            }
            Constant.EDUCATOR ->{
                if (ViewAllActivity.educatorFilter.contains(value)) {
                    ViewAllActivity.educatorFilter.remove(value)
                } else {
                    ViewAllActivity.educatorFilter.add(value)
                }

                if(ViewAllActivity.educatorFilter.size == 0){
                    layoutBinding.filterTitle.setBackgroundColor(layoutBinding.root.context.getColor(R.color.filter_Back_ground))
                }else{
                    layoutBinding.filterTitle.setBackgroundColor(layoutBinding.root.context.getColor(R.color.select_filter_item_Back_ground))
                }
            }

//            Constant.CLEAR->{
//                if(filterAdapter.viewAllActivity.findFilterItemCount() == 0){
//
//                    layoutBinding.filterTitle.setBackgroundColor(layoutBinding.root.context.getColor(R.color.filter_Back_ground))
//                }else{
//                    layoutBinding.filterTitle.setBackgroundColor(layoutBinding.root.context.getColor(R.color.select_filter_item_Back_ground))
//                }
//            }

        }


    }

    private fun setBackGroundInFilerList(tag: String,value:String, binding: BottomSheetListBinding){
        when(tag){
            Constant.CURRICULM_ALL ->
                if(ViewAllActivity.curriculumFilter.contains(value)){
                    binding.item.setBackgroundResource(R.color.select_filter_item_Back_ground)
                }else{
                    binding.item.setBackgroundResource(R.color.filter_Back_ground)
                }
            Constant.SERIES_ALL ->
                if(ViewAllActivity.seriesFilter.contains(value)){
                    binding.item.setBackgroundResource(R.color.select_filter_item_Back_ground)
                }else{
                    binding.item.setBackgroundResource(R.color.filter_Back_ground)
                }
            Constant.STYLE_ALL ->
                if(ViewAllActivity.styleFilter.contains(value)){
                    binding.item.setBackgroundResource(R.color.select_filter_item_Back_ground)
                }else{
                    binding.item.setBackgroundResource(R.color.filter_Back_ground)
                }
            Constant.SKILL_ALL ->
                if(ViewAllActivity.skillFilter.contains(value)){
                    binding.item.setBackgroundResource(R.color.select_filter_item_Back_ground)
                }else{
                    binding.item.setBackgroundResource(R.color.filter_Back_ground)
                }
            Constant.EDUCATOR ->
                if(ViewAllActivity.educatorFilter.contains(value)){
                    binding.item.setBackgroundResource(R.color.select_filter_item_Back_ground)
                }else{
                    binding.item.setBackgroundResource(R.color.filter_Back_ground)
                }
        }

//        if(filterAdapter.viewAllActivity.findFilterItemCount() > 0){
//            layoutBinding.filterTitle.setBackgroundColor(layoutBinding.root.context.getColor(R.color.filter_Back_ground))
//        }else{
//            layoutBinding.filterTitle.setBackgroundColor(layoutBinding.root.context.getColor(R.color.select_filter_item_Back_ground))
//        }
    }


    inner class ViewHolder(val binding: BottomSheetListBinding): RecyclerView.ViewHolder(binding.root){}
}