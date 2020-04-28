# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=96acd7c558849eaf93c9c522f1a2f334"

SRC_URI = "git://git@github.com/atharvanan1/aesd_linux_app.git;protocol=ssh;branch=gui-cmake"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "13ac30765aeeda60df03d66a59675ed761a8c1a4"

DEPENDS += "qtbase qtquickcontrols2"

S = "${WORKDIR}/git/iot_sensor_gui"

inherit cmake

do_configue () {
	cmake ..
}

do_install_append() {
  install -d ${D}${bindir_native}
  install -m 0755 ${S}/iot_sensor_gui/iot_sensor_gui ${D}${bindir_native}
}

FILES_${PN} += " ${bindir_native}/iot_sensor_gui"


