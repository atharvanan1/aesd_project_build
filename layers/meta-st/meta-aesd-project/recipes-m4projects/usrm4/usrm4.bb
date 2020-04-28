SUMMARY = "STM32MP1 Firmware examples for CM4"
LICENSE = " \
    Apache-2.0 \
    & MIT \
    & BSD-3-Clause \
    "
LIC_FILES_CHKSUM = "file://License.md;md5=5272d12bc1c2e29908b787134d73dae9"

SRC_URI = "git://git@github.com/atharvanan1/aesd_m4_app.git;protocol=ssh;branch=master"
SRCREV  = "b295d8553bdbba2df030a6c72c85b98f0b87039b"

PV = "1.2.0"

S = "${WORKDIR}/git"

require m4projects.inc

PROJECTS_LIST_DK2 = " \
	'STM32MP157C-DK2/Applications/ADC/ADC_app' \
"

PROJECTS_LIST = "${PROJECTS_LIST_DK2}"
