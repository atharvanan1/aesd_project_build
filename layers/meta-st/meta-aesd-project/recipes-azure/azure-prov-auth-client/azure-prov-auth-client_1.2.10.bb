DESCRIPTION = "Microsoft Azure IoT SDKs and libraries for C"
AUTHOR = "Microsoft Corporation"
HOMEPAGE = "https://github.com/Azure/azure-iot-sdk-c"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=4283671594edec4c13aeb073c219237a"

SRC_URI = "git://github.com/Azure/azure-iot-sdk-c.git;rev=7851827648785b666648b2e52caf5075e89a5605 \
           file://0001-add-compileAsC99-macro.patch \
           file://0001-include-azure_iot_sdksFunctions-cmake-file.patch \
           file://0002-get-prov-sdk-version.patch \
           file://0003-updating-path-for-config-file.patch \
           "

# NOTE - We are trying to get azure-iot-sdk-c, however we are gonna try to
# install only provisioning_client part of the repository.
# This provisioning_client folder has it's own submodules.
# If you face any issues that "something not found" in one of the
# git submodules linked, try to see how we can init these submodules and
# add that to the recipe

PR = "r0"

include ${BPN}.inc
