package com.ahmedhnewa.landingpagedemo.components

import kotlinx.coroutines.*


/**
 * Just ignore it,
 * it's just me when I have no energy
 * */

class BuildContext

class Widget

abstract class StatelessWidget {
    abstract fun build(context: BuildContext): Widget
}

interface SetState {
    fun setState(a: () -> Unit)
}

abstract class State<T> : StatelessWidget(), SetState {
    override fun setState(a: () -> Unit) {
        build(context = BuildContext())
    }

    open fun initState() {}
}

abstract class StatefulWidget {
    abstract fun createState(): State<StatefulWidget>
}

class AdviceWidget: StatelessWidget() {
    override fun build(context: BuildContext): Widget {
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

    override fun build(context: BuildContext): Widget {
        setState { counter = 2 }
        return Widget()
    }
}