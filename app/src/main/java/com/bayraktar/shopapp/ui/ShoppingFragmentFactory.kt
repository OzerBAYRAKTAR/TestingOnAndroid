package com.bayraktar.shopapp.ui

class ShoppingFragmentFactory @Inject constructor(
    private val imageAdapter: ImageAdapter
): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className) {
            ImagePickFragment::class.java.name -> ImagePickFragment(imageAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}