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
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

FILES_PN += "\
			${bindir_native}/hello_world \
			"

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# Specify compilation commands here
	oe_runmake
}

do_install () {
	# Specify install commands here
	install -d ${D}${bindir_native}
	install -m 0755 ${S}/hello_world ${D}${bindir_native}
}

