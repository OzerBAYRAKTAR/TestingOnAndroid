package com.bayraktar.shopapp.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bayraktar.shopapp.MainCoroutineRule
import com.bayraktar.shopapp.getOrAwaitValue
import com.bayraktar.shopapp.other.Constants
import com.bayraktar.shopapp.other.Status
import com.bayraktar.shopapp.repositories.FakeShoppingRepository
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ShoppingViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var  viewModel : ShoppingViewModel

    @get:Rule
    var mainCoroutineRule= MainCoroutineRule()

    @Before
    fun setup() {
        viewModel = ShoppingViewModel(FakeShoppingRepository())
    }

    @Test
    fun `insert shopping item with empty field ,returns error`() {

        viewModel.insertShoppingItem("string","","3.0")

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        Truth.assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }


    @Test
    fun `insert shopping item with empty field,returns error`() {
        val string = buildString {
            for (i in 1..Constants.MAX_NAME_LENGTH + 1) {
                append(1)
            }
        }
        viewModel.insertShoppingItem(string,"5","3.0")

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        Truth.assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert shopping item with too long name,returns error`() {
        val string = buildString {
            for (i in 1..Constants.MAX_PRICE_LENGTH + 1) {
                append(1)
            }
        }
        viewModel.insertShoppingItem(string,"5","3.0")

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        Truth.assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }


    @Test
    fun `insert shopping item with too long price,returns error`() {
        val string = buildString {
            for (i in 1..Constants.MAX_NAME_LENGTH + 1) {
                append(1)
            }
        }
        viewModel.insertShoppingItem(string,"5",string)

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        Truth.assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }
    @Test
    fun `insert shopping item with too high amount,returns error`() {

        viewModel.insertShoppingItem("name","55555555555555555555555","3.0")

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        Truth.assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }
    @Test
    fun `insert shopping item with valid input,returns success`() {

        viewModel.insertShoppingItem("name","5","3.0")

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        Truth.assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.SUCCESS)
    }
}