inherit cmake

DEPENDS = "\
    azure-c-shared-utility \
    azure-iot-sdk-c \
"

S = "${WORKDIR}/git/provisioning_client"
B = "${WORKDIR}/build"

EXTRA_OECMAKE = "\
    -Dbuild_as_dynamic:BOOL=ON \
    -Dskip_samples:BOOL=ON \
    -Duse_installed_dependencies:BOOL=ON \
    -Duse_prov_client:BOOL=ON \
    -Drun_e2e_tests:BOOL=OFF \
    -Dhsm_type_x509:BOOL=OFF \
    -Dhsm_type_sastoken:BOOL=OFF \
    -Dhsm_type_symm_key:BOOL=OFF \
    -Dhsm_type_custom:BOOL=ON \
    -Dnuget_e2e_tests:BOOL=OFF \
    -Duse_prov_client_core:BOOL=ON \
"

# I think the source directories will need some work, so try to tweak it a bit.
sysroot_stage_all_append () {
    sysroot_stage_dir ${D}${exec_prefix}/cmake ${SYSROOT_DESTDIR}${exec_prefix}/cmake
}

FILES_${PN}-dev += "\
    ${exec_prefix}/cmake \
"

BBCLASSEXTEND = "native nativesdk"
