# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=96acd7c558849eaf93c9c522f1a2f334"

SRC_URI = "git://git@github.com/atharvanan1/aesd_linux_app.git;protocol=ssh;branch=master \
		   "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "630ee1317911891f3d461d3aaf84324313803006"

S = "${WORKDIR}"

DEPENDS_append += " \
	azure-iot-sdk-c \
	"

RDEPENDS_${PN} += " \
	iotedge-cli \
	iotedge-daemon \
	"

inherit cmake

do_configue () {
	cmake ..
}

do_install () {
	# Specify install commands here
	install -d ${D}${bindir_native}
	install -m 0755 ${S}/azure/azure_app ${D}${bindir_native}
}

