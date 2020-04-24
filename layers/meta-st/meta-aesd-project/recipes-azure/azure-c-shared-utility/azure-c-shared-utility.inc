inherit cmake

DEPENDS = "\
    curl \
    util-linux \
    openssl \
"

RDEPENDS_${PN} = "\
    util-linux-libuuid \
"

SRC_URI += "\
    file://Fix-packaging-issues.patch \
    file://Use-pkg-config-to-find-libs.patch \
"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

EXTRA_OECMAKE = "\
    -Dbuild_as_dynamic:BOOL=ON \
    -Dskip_samples:BOOL=ON \
    -Duse_installed_dependencies:BOOL=ON \
    -Drun_unittests:BOOL=OFF \
"

# See solution at https://stackoverflow.com/a/59029698/1446624
do_configure_prepend() {
	cd ${S}
	git submodule update --init --recursive
}

sysroot_stage_all_append () {
    sysroot_stage_dir ${D}${exec_prefix}/cmake ${SYSROOT_DESTDIR}${exec_prefix}/cmake
}

RDEPENDS_${PN} += "\
	azure-uamqp-c \
"

FILES_${PN}-dev += "\
    ${exec_prefix}/cmake \
"

BBCLASSEXTEND = "native nativesdk"
