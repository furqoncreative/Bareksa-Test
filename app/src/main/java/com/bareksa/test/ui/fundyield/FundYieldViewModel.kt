package com.bareksa.test.ui.fundyield

import androidx.lifecycle.ViewModel
import com.bareksa.test.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FundYieldViewModel @Inject constructor(
    repository: Repository
) : ViewModel() {

    val getFundList = repository.getFundList()
}