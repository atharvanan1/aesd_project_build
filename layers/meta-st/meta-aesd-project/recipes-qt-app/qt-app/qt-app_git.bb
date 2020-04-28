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
SRCREV = "8fd649b6790ad634aab1ed15d08847a40f5c5f19"

DEPENDS += "qtbase qtquickcontrols2"

RDEPENDS_${PN} += "qtwayland-plugins"

S = "${WORKDIR}/git/iot_sensor_gui"
B = "${WORKDIR}/build"

inherit cmake_qt5

do_install() {
  install -d ${D}${bindir_native}
  install -m 0755 ${B}/iot_sensor_gui ${D}${bindir_native}
}

FILES_${PN} += " ${bindir_native}/iot_sensor_gui"


