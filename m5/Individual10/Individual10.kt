open class Phone(var isScreenLightOn: Boolean = false) {
    
    open fun switchOn() {
        isScreenLightOn = true
    }
    fun switchOff() {
        isScreenLightOn = false
    }
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}
class FoldablePhone(isThePhoneFolded: Boolean = false) : Phone() {
    private var isFolded = isThePhoneFolded

    override fun switchOn() {
        if (!isFolded) {
            super.switchOn()
        } else {
            isScreenLightOn = false
        }
    }

    fun foldPhone() {
        isFolded = true
        switchOff()
    }

    fun unfoldPhone() {
        isFolded = false
    }

    fun isThePhoneFolded(): Boolean {
        return isFolded
    }
}

fun main() {
    
    val telefononormal = Phone()
    telefononormal.switchOn()
    telefononormal.checkPhoneScreenLight()

    val telefonoplegable = FoldablePhone()
    telefonoplegable.switchOn()
    telefonoplegable.checkPhoneScreenLight()
    
    telefonoplegable.foldPhone()
    telefonoplegable.switchOn()
    telefonoplegable.checkPhoneScreenLight()

    telefonoplegable.unfoldPhone()
    telefonoplegable.switchOn()
    telefonoplegable.checkPhoneScreenLight()
}
