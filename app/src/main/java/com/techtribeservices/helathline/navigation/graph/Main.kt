package com.techtribeservices.helathline.navigation.graph

import kotlinx.serialization.Serializable

sealed class MainGraph {

    @Serializable
    data object Auth: MainGraph()

    @Serializable
    data object App: MainGraph()
}