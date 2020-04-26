# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@github.com/atharvanan1/aesd_linux_app.git;protocol=ssh;branch=master \
          "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "476edaa33dc560d10d201be99f49bc01c3e5c0ee"

S = "${WORKDIR}/git"

do_configue () {
    :
}

do_compile () {
    make tmp102_app
}

do_install () {
	# Specify install commands here
	install -d ${D}${bindir_native}
	install -m 0755 ${S}/tmp102_app ${D}${bindir_native}
}