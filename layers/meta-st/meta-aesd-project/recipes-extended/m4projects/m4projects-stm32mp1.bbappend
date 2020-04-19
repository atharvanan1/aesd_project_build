
SUMMARY = "STM32MP1 Firmware examples for CM4"
LICENSE = " \
    Apache-2.0 \
    & MIT \
    & BSD-3-Clause \
    "
LIC_FILES_CHKSUM = "file://License.md;md5=5272d12bc1c2e29908b787134d73dae9"

SRC_URI_remove = "git://github.com/STMicroelectronics/STM32CubeMP1.git;protocol=https;branch=master"
SRC_URI_append = " git://git@github.com/atharvanan1/aesd_m4_app.git;protocol=ssh"
SRCREV  = "557d967dabbf8307649247755ca196fe8b4e9ad5"

PV = "1.2.0"

S = "${WORKDIR}/git"

PROJECTS_LIST_EV1 = " "

PROJECTS_LIST_DK2 = " \
    'STM32MP157C-DK2/Applications/OpenAMP_TTY_echo' \
    "

PROJECTS_LIST = "${PROJECTS_LIST_DK2}"