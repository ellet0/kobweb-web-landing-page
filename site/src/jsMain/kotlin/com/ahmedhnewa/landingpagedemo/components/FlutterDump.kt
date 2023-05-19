package com.ahmedhnewa.landingpagedemo.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * Just ignore it,
 * it's just me when I have no energy
 * */

class Widget

abstract class StatelessWidget {
    abstract fun build(): Widget
}

interface SetState {
    fun setState(a: () -> Unit)
}

abstract class State<T> : StatelessWidget(), SetState {
    override fun setState(a: () -> Unit) {
        build()
    }

    open fun initState() {}
}

abstract class StatefulWidget {
    abstract fun createState(): State<StatefulWidget>
}

class AdviceWidget: StatelessWidget() {
    override fun build(): Widget {
        return Widget()
    }
}

class MainSectionWidget : StatefulWidget() {
    override fun createState(): State<StatefulWidget> = MainSectionWidgetState()
}

@OptIn(DelicateCoroutinesApi::class)
private class MainSectionWidgetState : State<StatefulWidget>() {
    private var counter = 1
    private var isLoading = false

    override fun initState() {
        super.initState()
        GlobalScope.launch {
            setState { isLoading = true }
            delay(3000L)
            setState { isLoading = false }
        }
    }

    override fun build(): Widget {
        setState { counter = 2 }
        return Widget()
    }
}