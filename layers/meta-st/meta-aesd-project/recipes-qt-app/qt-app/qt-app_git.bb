# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=96acd7c558849eaf93c9c522f1a2f334"

SRC_URI = "git://git@github.com/atharvanan1/aesd_linux_app.git;protocol=ssh"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "65ea96f0f7bb7003d68aa9a2407b6827fcf69340"

DEPENDS_append += " \
  qtbase \
  qtquickcontrols2 \
  azure-c-shared-utility \
  azure-iot-sdk-c \
  "

RDEPENDS_${PN} += " \
  qtwayland-plugins \
  iotedge-cli \
  iotedge-daemon \
  "

S = "${WORKDIR}/git/iot_sensor_gui"
B = "${WORKDIR}/build"

FILES_${PN} += " \
  ${bindir_native}/iot_sensor_gui \
  "

inherit cmake_qt5

do_install() {
  install -d ${D}${bindir_native}
  install -m 0755 ${B}/iot_sensor_gui ${D}${bindir_native}
}



