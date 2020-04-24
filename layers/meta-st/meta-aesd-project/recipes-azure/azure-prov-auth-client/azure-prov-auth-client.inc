inherit cmake

DEPENDS = "\
    azure-c-shared-utility \
"

S = "${WORKDIR}/git/provisioning_client"
B = "${WORKDIR}/build"

EXTRA_OECMAKE = "\
    -Dbuild_as_dynamic:BOOL=ON \
    -Dskip_samples:BOOL=ON \
    -Duse_installed_dependencies:BOOL=ON \
# NOTE: Added this based on looking at the CMakeLists.txt file - do refer to it if it doesn't build
    -Duse_prov_client=BOOL=ON \
"

# I think the source directories will need some work, so try to tweak it a bit.
sysroot_stage_all_append () {
    sysroot_stage_dir ${D}${exec_prefix}/cmake ${SYSROOT_DESTDIR}${exec_prefix}/cmake
}

FILES_${PN}-dev += "\
    ${exec_prefix}/cmake \
"

BBCLASSEXTEND = "native nativesdk"
