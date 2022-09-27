package com.shah.amazonclone.utilities.helpers

/**
 * Created by Monil Shah on 30/08/22.
 */

object Constants {

    object Size {
        const val userNameMinimumLength = 3
        const val passwordMinimumLength = 4
        const val ratingRange = 5
    }

    object Validation {
        const val emailPattern = "[a-zA-Z0-9.-_]+@[a-zA-Z0-9]+\\.+[a-z]+"
    }

    object API {
        object Headers {
            const val accept = "Accept"
            const val applicationJson = "application/json"
            const val contentType = "Content-Type"
            const val authorization = "Authorization"
            private const val bearer = "Bearer"

            fun getBearerToken(token: String?): String = "$bearer $token"
        }

        object Path {
            private const val api = "api"
            const val signUp = "$api/signUp"
            const val login = "$api/signIn"
            const val productByCategory = "$api/products"
            const val searchProduct = "$api/products/search/{${QueryParams.name}}"
            const val rateProduct = "$api/product/rate"
            const val getDealOfTheDay = "$api/dealOfDay"

            private const val admin = "admin"
            const val addProduct = "$admin/addProduct"
            const val allProducts = "$admin/allProducts"
            const val deleteProduct = "$admin/deleteProduct"
        }

        object QueryParams {
            const val category = "category"
            const val name = "name"
        }
    }

    object DataStore {
        const val name = "userDataStore"

        object Keys {
            const val authToken = "authToken"
            const val userName = "userName"
            const val address = "address"
            const val type = "type"
            const val userId = "userId"
        }
    }

    object BottomNavBar {
        object Route {
            const val home = "home"
            const val account = "account"
            const val cart = "cart"
            const val analytics = "analytics"
            const val orders = "orders"
        }

        object Title {
            const val home = "Home"
            const val account = "Account"
            const val cart = "Cart"
            const val analytics = "Analytics"
            const val orders = "Orders"
        }
    }

    object Screen {
        object Route {
            const val home = "home"
            const val category = "category"
        }

        object Title {
            const val home = "Home"
            const val category = "Category"
        }
    }

    object Resources {
        val carouselImages = listOf(
            "https://images-eu.ssl-images-amazon.com/images/G/31/img21/Wireless/WLA/TS/D37847648_Accessories_savingdays_Jan22_Cat_PC_1500.jpg",
            "https://images-eu.ssl-images-amazon.com/images/G/31/img2021/Vday/bwl/English.jpg",
            "https://images-eu.ssl-images-amazon.com/images/G/31/img22/Wireless/AdvantagePrime/BAU/14thJan/D37196025_IN_WL_AdvantageJustforPrime_Jan_Mob_ingress-banner_1242x450.jpg",
            "https://images-na.ssl-images-amazon.com/images/G/31/Symbol/2020/00NEW/1242_450Banners/PL31_copy._CB432483346_.jpg",
            "https://images-na.ssl-images-amazon.com/images/G/31/img21/shoes/September/SSW/pc-header._CB641971330_.jpg",
        )
    }

    object BundleKeys {
        const val category = "category"
        const val searchQuery = "searchQuery"
        const val product = "product"
    }
}
