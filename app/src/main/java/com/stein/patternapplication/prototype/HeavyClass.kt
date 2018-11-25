package com.stein.patternapplication.prototype

class HeavyClass() : Cloneable {

    private lateinit var param1: String
    private lateinit var param2: String
    private var param3: Int = 0

    constructor(param1: String, param2: String, param3: Int) : this() {

    }

    public fun initialize(param1: String, param2: String, param3: Int) {
        this.param1 = param1
        this.param2 = param2
        this.param3 = param3
    }

    override public fun clone(): HeavyClass {
        return HeavyClass(param1, param2, param3)
    }

}