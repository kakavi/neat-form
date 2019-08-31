package com.nerdstone.neatformcore.views.controls

import android.content.Context
import android.support.v7.widget.AppCompatRadioButton
import android.util.AttributeSet

import com.nerdstone.neatformcore.domain.model.NFormViewData
import com.nerdstone.neatformcore.domain.model.NFormViewDetails
import com.nerdstone.neatformcore.domain.model.form.NFormViewProperty
import com.nerdstone.neatformcore.domain.view.DataActionListener
import com.nerdstone.neatformcore.domain.view.NFormView
import com.nerdstone.neatformcore.domain.view.RootView
import com.nerdstone.neatformcore.views.handlers.ViewDispatcher

class RadioButtonNFormView : AppCompatRadioButton, NFormView {
    override var viewDetails: NFormViewDetails = NFormViewDetails()
        private set
    private var dataActionListener: DataActionListener? = null

    override val viewData: NFormViewData
        get() = NFormViewData()

    override val nFormRootView: RootView
        get() = this.parent as RootView

    constructor(context: Context) : super(context) {
        setupView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setupView()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setupView()
    }

    override fun initView(viewProperty: NFormViewProperty, viewDispatcher: ViewDispatcher): NFormView {
        this.viewDetails = NFormViewDetails(this)
        setOnDataPassListener(viewDispatcher)
        return this
    }

    override fun setOnDataPassListener(dataActionListener: DataActionListener) {
        if (this.dataActionListener == null) {
            this.dataActionListener = dataActionListener
        }
    }

    override fun setupView() {

    }
}
